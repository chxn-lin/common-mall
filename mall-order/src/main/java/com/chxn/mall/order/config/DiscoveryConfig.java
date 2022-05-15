package com.chxn.mall.order.config;

import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// 无效
@Data
@Component
//@ConfigurationProperties("spring.application")
public class DiscoveryConfig {

    @Value("${user.name}")
    private String name;

    {
        System.out.println("==========:" + name);
    }

}
