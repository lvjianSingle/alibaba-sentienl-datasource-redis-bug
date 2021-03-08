package com.lvjians.orderdemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Title: ProductInfoFeignApi
 * Description: 商品信息查询api
 *
 * @author lvjian
 * @version 1.0.0
 * @date 2021/3/8 0:09
 */
@FeignClient(name = "product")
public interface ProductInfoFeignApi {

    /**
     * 查询商品信息
     * @return
     */
    @GetMapping("product/queryInfo")
    String queryProductInfo();

}
