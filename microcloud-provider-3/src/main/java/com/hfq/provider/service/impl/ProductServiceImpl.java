package com.hfq.provider.service.impl;

import com.hfq.api.model.Product;
import com.hfq.provider.dao.ProductMapper;
import com.hfq.provider.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description： 产品服务实现接口
 * @author： Mr.He
 * @date： 2019-06-29 22:19
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    public ProductMapper productMapper;

    @Override
    public List<Product> findAllProduct() {
        return productMapper.selectAllProduct();
    }

    @Override
    public Product findProductByID(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public void createProduct(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void modifyProduct(Product product) {
        productMapper.updateByPrimaryKey(product);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productMapper.deleteByPrimaryKey(productId);
    }
}
