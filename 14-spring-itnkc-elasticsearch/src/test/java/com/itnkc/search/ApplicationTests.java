package com.itnkc.search;

import com.alibaba.fastjson.JSON;
import com.itnkc.search.entity.User;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void testData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("4");
        User user = new User();
        user.setUserName("关晓彤");
        user.setAge(22);
        user.setGender("女");
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);
        IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(index.status());

    }

    @Test
    public void searchAll() throws IOException {
        // 创建搜索请求
        SearchRequest searchRequest = new SearchRequest("users");
        // 创建搜索构造器条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            String asString = hit.getSourceAsString();
            User user = JSON.parseObject(asString, User.class);
            System.out.println(user);
        }
    }

    @Test
    public void updateData() throws Exception {
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("users");
        updateRequest.id("1");
        User user = new User();
        user.setGender("男");
        user.setUserName("王五");
        user.setAge(22);
        String jsonString = JSON.toJSONString(user);
        updateRequest.doc(jsonString, XContentType.JSON);
        UpdateResponse update = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(update.status());
    }

    @Test
    public void deleteData() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.index("users");
        deleteRequest.id("1");
        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status());
    }

    @Test
    public void aggData() throws IOException {
        // 创建搜索请求
        SearchRequest searchRequest = new SearchRequest("users");

        // 创建搜索条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.matchAllQuery());
        TermsAggregationBuilder genderAgg = AggregationBuilders.terms("genderAgg").field("gender.keyword").size(10);
        AvgAggregationBuilder avgAgg = AggregationBuilders.avg("ageAgg").field("age");
        builder.aggregation(genderAgg);
        builder.aggregation(avgAgg);
        searchRequest.source(builder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            String asString = hit.getSourceAsString();
            User user = JSON.parseObject(asString, User.class);
            System.out.println(user);
        }

        Aggregations aggregations = response.getAggregations();
        Avg ageAgg = aggregations.get("ageAgg");
        double value = ageAgg.getValue();
        System.out.println("平均年龄为：" + value);
        System.out.println("=============================");
        Terms aggregation = aggregations.get("genderAgg");
        List<? extends Terms.Bucket> buckets = aggregation.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            String key = bucket.getKeyAsString();
            System.out.println("年龄：" + key);
            long docCount = bucket.getDocCount();
            System.out.println("个数：" + docCount);
            System.out.println("-----------------------");
        }

    }


    /**
     * 1.新增一条数据
     * 2.删除一条数据
     */
    @Test
    public void batchData() throws IOException {
        // 创建批量请求
        BulkRequest bulkRequest = new BulkRequest();
        /**
         * 新增
         */
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("5");
        String jsonString = JSON.toJSONString(new User("倪克成", "男", 23));
        indexRequest.source(jsonString, XContentType.JSON);
        bulkRequest.add(indexRequest);
        /**
         * 修改
         */
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("users");
        updateRequest.id("2");
        String jsonString1 = JSON.toJSONString(new User("李太白", "男", 60));
        updateRequest.doc(jsonString, XContentType.JSON);
        bulkRequest.add(updateRequest);

        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        for (BulkItemResponse response : bulkResponse) {
            System.out.println(response.status());
        }

    }

    /**
     * 模糊查询 + 条件查询 + 排序
     */
    @Test
    public void search() throws IOException {
        SearchRequest searchRequest = new SearchRequest();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.fuzzyQuery("userName", "倪"))
                .mustNot(QueryBuilders.termQuery("gender", "女"));
        searchSourceBuilder.query(boolQueryBuilder)
                .from(0)
                .size(10);
        searchRequest.source(searchSourceBuilder);
        searchRequest.indices("users");
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            String asString = hit.getSourceAsString();
            User user = JSON.parseObject(asString, User.class);
            System.out.println(user);
            System.out.println("-------------");
        }
    }


    /**
     * 高亮
     */
    @Test
    public void highlighter() throws IOException {
        SearchRequest searchRequest = new SearchRequest();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name").requireFieldMatch(false).preTags("<span style='color:red;'>").postTags("</span>");
        searchSourceBuilder.highlighter(highlightBuilder).query(QueryBuilders.termQuery("name","呐喊"));

        searchRequest.indices("users");
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            highlightFields.forEach((k,v)-> System.out.println("key: "+k + " value: "+v.fragments()[0]));
        }
    }
}
