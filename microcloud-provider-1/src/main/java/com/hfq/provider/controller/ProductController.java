package com.hfq.provider.controller;

import com.hfq.api.model.Product;
import com.hfq.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description： 服务提供方 controller
 * @author： Mr.He
 * @date： 2019-06-30 14:06
 **/
@RestController
@RequestMapping
public class ProductController {

    @Resource
    public ProductService productService;



    @GetMapping("/product")
    public Object findProductAll(){
        return productService.findAllProduct();
    }

    @GetMapping("/product/{productId}")
    public Object findProductById(@PathVariable Integer productId){
        return productService.findProductByID(productId);
    }

    @PostMapping("/product")
    public Object createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return "create success";
    }

    @PutMapping("/product")
    public Object modifyProduct(@RequestBody Product product) {
        productService.modifyProduct(product);
        return "modify success";
    }

    @DeleteMapping("/product/{productId}")
    public Object deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);
        return "delete success";
    }


}
