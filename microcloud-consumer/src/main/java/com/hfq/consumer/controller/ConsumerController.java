package com.hfq.consumer.controller;

import com.hfq.api.model.Product;
import com.hfq.consumer.utils.ProductURL;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description： 消费方controller restTemplate
 * @author： Mr.He
 * @date： 2019-06-30 14:32
 **/
@RestController
@RequestMapping
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/product")
    public Object findProductAll(){
        return restTemplate.exchange(ProductURL.PRODUCT_FINDALL_URL,
                HttpMethod.GET, new HttpEntity<>(httpHeaders),String.class);
    }

    @GetMapping("/product/{productId}")
    public Object findProductById(@PathVariable Integer productId){
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT-PROVIDER");
        System.out.println("\033[33;0m instanceService1     host="+serviceInstance.getHost()
            +"   port="+ serviceInstance.getPort()+"    serviceID="+serviceInstance.getServiceId()
                +"\033[0m");
        return restTemplate.exchange(ProductURL.PRODUCT_FIND_URL +productId,
                HttpMethod.GET, new HttpEntity<>(httpHeaders),String.class);
    }

    @PostMapping("/product")
    public Object createProduct(@RequestBody Product product) {
        return restTemplate.exchange(ProductURL.PRODUCT_CREATE_URL,
                HttpMethod.POST,new HttpEntity<>(product,httpHeaders),String.class);
    }

    @PutMapping("/product")
    public Object modifyProduct(@RequestBody Product product) {
        return restTemplate.exchange(ProductURL.PRODUCT_MODIFY_URL,
                HttpMethod.PUT,new HttpEntity<>(product,httpHeaders),String.class);
    }

    @DeleteMapping("/product/{productId}")
    public Object deleteProduct(@PathVariable Integer productId) {
        return restTemplate.exchange(ProductURL.PRODUCT_DELETE_URL+productId,
                HttpMethod.DELETE,new HttpEntity<>(httpHeaders),String.class);
    }
}
