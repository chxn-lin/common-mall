package com.chxn.mall.product;

import com.chxn.mall.product.entity.BrandEntity;
import com.chxn.mall.product.entity.CategoryEntity;
import com.chxn.mall.product.service.BrandService;
import com.chxn.mall.product.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.UUID;

@SpringBootTest(classes = MallProductApplication.class)
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {

        CategoryEntity en = new CategoryEntity();
        en.setCatLevel(123);
        categoryService.save(en);

    }

    @Test
    void selectAll() {
        List<BrandEntity> list = brandService.list();
        for (BrandEntity entity : list) {
            System.out.println(entity);
        }
    }

    @Test
    void redisTest(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("chxn", UUID.randomUUID().toString());
        System.out.println("" + ops.get("chxn"));
    }

}
