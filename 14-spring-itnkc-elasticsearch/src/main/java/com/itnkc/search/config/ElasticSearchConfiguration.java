package com.itnkc.search.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/11/23 11:18
 */
@Configuration
public class ElasticSearchConfiguration {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("121.40.210.58:9200")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
