package com.chxn.mall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chxn.mall.coupon.dao")
public class MallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallCouponApplication.class, args);
    }

}
