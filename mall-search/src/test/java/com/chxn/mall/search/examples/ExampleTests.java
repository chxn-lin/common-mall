package com.chxn.mall.search.examples;

import com.chxn.mall.search.config.MallElasticSearchConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.cluster.metadata.MetaData;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.SearchResult;
import java.io.IOException;

@SpringBootTest
public class ExampleTests {

    @Autowired
    @Qualifier("myRestHighLevelClient")
    RestHighLevelClient client;

    @Test
    void saveIndex() throws IOException {
        System.out.println(client);
        System.out.println(MallElasticSearchConfiguration.COMMON_OPTIONS);

        IndexRequest indexRequest = new IndexRequest("my_index");
        indexRequest.id("20220621001");
        User user = new User();
        user.setAge(22);
        user.setName("张三");
        user.setGender("M");

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);
        indexRequest.source(s, XContentType.JSON);

        IndexResponse index = client
                .index(indexRequest, MallElasticSearchConfiguration.COMMON_OPTIONS);
        System.out.println(index);
    }

    @Data
    class User{
        private String name;
        private Integer age;
        private String gender;
    }

    /**
     * 检索出所有的bank索引的所有文档
     */
    @Test
    void searchIndexAll() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("bank");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query();
//        sourceBuilder.from();
//        sourceBuilder.size()

        searchRequest.source(sourceBuilder);

        // 执行查询
        SearchResponse search = client.search(searchRequest, MallElasticSearchConfiguration.COMMON_OPTIONS);
        System.out.println("获取到的数据：" + search);

    }

    // 根据address全文检索
    @Test
    void searchIndexByAddress() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("bank");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("address", "mill"));

        searchRequest.source(sourceBuilder);

        // 执行查询
        SearchResponse search = client.search(searchRequest, MallElasticSearchConfiguration.COMMON_OPTIONS);
        System.out.println("获取到的数据：" + search);
    }

    // 嵌套的聚合操作：检索出bank下的年龄分布和每个年龄段的平均薪资
    @Test
    void searchIndexAggs() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("bank");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());

        // 聚合
        AvgAggregationBuilder subAggs = AggregationBuilders
                .avg("balanceAggs")
                .field("balance");
        AggregationBuilder aggBuilder = AggregationBuilders
                .terms("ageAggs")
                .size(10)
                .field("age")
                .subAggregation(subAggs);
        sourceBuilder.aggregation(aggBuilder);

        sourceBuilder.size(0);
        searchRequest.source(sourceBuilder);

        // 执行查询
        SearchResponse search = client.search(searchRequest, MallElasticSearchConfiguration.COMMON_OPTIONS);
        System.out.println("获取到的数据：" + search);
    }

    @Test
    void searchIndexResponse() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("bank");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        sourceBuilder.query(QueryBuilders.matchQuery("address", "mill"));
        searchRequest.source(sourceBuilder);

        SearchResponse response = client.search(searchRequest, MallElasticSearchConfiguration.COMMON_OPTIONS);
        // 处理数据
        SearchHits hits = response.getHits();
        TotalHits totalHits = hits.getTotalHits();
        System.out.println("总数：" + totalHits);
        for (SearchHit hit : hits.getHits()) {
            String str = hit.getSourceAsString();
            Account account = new ObjectMapper().readValue(str, Account.class);
            System.out.println(account);
        }
    }

    @ToString
    @Data
    static class Account {
        private int account_number;
        private int balance;
        private String firstname;
        private String lastname;
        private int age;
        private String gender;
        private String address;
        private String employer;
        private String email;
        private String city;
        private String state;
    }

}
