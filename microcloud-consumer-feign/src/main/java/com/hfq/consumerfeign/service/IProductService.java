package com.hfq.consumerfeign.service;

import com.hfq.api.model.Product;
import com.hfq.consumerfeign.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description： feign 接口调用
 * @author： Mr.He
 * @date： 2019-07-05 14:45
 **/
//path:服务方的 server.servlet.context-path  不设置会404
@FeignClient(name = "PRODUCT-PROVIDER",configuration = FeignClientConfig.class,path = "/provider")
public interface IProductService {

    @GetMapping("/product/{productId}")
    Product findProductById(@PathVariable Integer productId);

    @GetMapping("/product")
    List<Product> findProductAll();
}
