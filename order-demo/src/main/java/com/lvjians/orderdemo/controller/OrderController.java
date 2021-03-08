package com.lvjians.orderdemo.controller;

import com.lvjians.orderdemo.feign.ProductInfoFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: OrderController
 * Description: OrderController
 *
 * @author lvjian
 * @version 1.0.0
 * @date 2021/3/8 0:09
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductInfoFeignApi productInfoFeignApi;


    @GetMapping("createOrder")
    public String createOrder() {
        String productInfo = productInfoFeignApi.queryProductInfo();
        System.out.println(productInfo);
        return "SUCCESS";
    }

}
