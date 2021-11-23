package com.itnkc.search;

import com.alibaba.fastjson.JSON;
import com.itnkc.search.entity.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class ApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void testData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("2");
        User user = new User();
        user.setUserName("李白");
        user.setAge(22);
        user.setGender("男");
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


}
