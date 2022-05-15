package com.chxn.mall.product;

import com.chxn.mall.product.entity.BrandEntity;
import com.chxn.mall.product.entity.CategoryEntity;
import com.chxn.mall.product.service.BrandService;
import com.chxn.mall.product.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = MallProductApplication.class)
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

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

}
