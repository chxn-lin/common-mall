package com.chxn.mall.coupon;

import com.chxn.mall.coupon.entity.HomeSubjectSpuEntity;
import com.chxn.mall.coupon.service.HomeSubjectSpuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallCouponApplicationTests {

    @Autowired
    HomeSubjectSpuService homeSubjectSpuService;

    @Test
    void contextLoads() {
        HomeSubjectSpuEntity en = new HomeSubjectSpuEntity();
        en.setName("1234");
        homeSubjectSpuService.save(en);
    }

}
