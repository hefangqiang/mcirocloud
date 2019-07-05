package com.hfq.consumerfeign.controller;

import com.hfq.consumerfeign.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description： 消费方controller feign
 * @author： Mr.He
 * @date： 2019-07-05 15:00
 **/
@RestController
@RequestMapping
public class ConsumerFeignController {

    @Resource
    public IProductService iProductService;

    @GetMapping("/product/{productId}")
    public Object findProductById(@PathVariable Integer productId){
        return iProductService.findProductById(productId);
    }

    @GetMapping("/product")
    public Object findProductAll(){
        return iProductService.findProductAll();
    }

}
