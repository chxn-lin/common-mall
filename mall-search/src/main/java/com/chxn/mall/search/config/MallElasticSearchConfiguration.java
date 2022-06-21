package com.chxn.mall.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.alibaba.nacos.api.common.Constants.TOKEN;

/**
 * es配置类
 */
@Configuration
public class MallElasticSearchConfiguration {

    public static final RequestOptions COMMON_OPTIONS;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
//        builder.addHeader("Authorization", "Bearer " + TOKEN);
//        builder.setHttpAsyncResponseConsumerFactory(
//                new HttpAsyncResponseConsumerFactory
//                        .HeapBufferedResponseConsumerFactory(
//                                30 * 1024 * 1024 * 1024
//                )
//        );
        COMMON_OPTIONS = builder.build();
    }

    @Bean(name = "myRestHighLevelClient")
    public RestHighLevelClient getRestHighLevelClient(){
        RestClientBuilder restClientBuilder = RestClient.builder(
                new HttpHost("192.168.217.141", 9200, "http")
        );
        RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);
        return client;
    }

}
