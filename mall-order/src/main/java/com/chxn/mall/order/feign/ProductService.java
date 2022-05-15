package com.chxn.mall.order.feign;

import com.chxn.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @FeignClient 指明我们要从注册中心中发现的服务的名称
 */
@FeignClient(name = "mall-product")
public interface ProductService {

    @GetMapping("/product/brand/all")
    public R queryAllBrands();
}
