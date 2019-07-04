package com.hfq.provider.service;

import com.hfq.api.model.Product;

import java.util.List;

/**
 * @description： 产品服务接口
 * @author： Mr.He
 * @date： 2019-06-29 22:18
 **/
public interface ProductService {

    List<Product> findAllProduct();

    Product findProductByID(Integer productId);

    void createProduct(Product product);

    void modifyProduct(Product product);

    void deleteProductById(Integer productId);
}
