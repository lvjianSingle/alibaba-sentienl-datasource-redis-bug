package com.lvjians.productdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: ProductInfoController
 * Description: 商品信息
 *
 * @author lvjian
 * @version 1.0.0
 * @date 2021/3/8 0:06
 */
@RestController
@RequestMapping("product")
public class ProductInfoController {



    @GetMapping("/queryInfo")
    public String queryInfo() {
        return "This is a product information";
    }


}
