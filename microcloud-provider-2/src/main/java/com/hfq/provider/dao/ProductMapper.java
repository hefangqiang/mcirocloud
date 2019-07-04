package com.hfq.provider.dao;

import com.hfq.api.model.Product;

import java.util.List;
/**
 * @description： 产品dao层接口
 * @author： Mr.He
 * @date： 2019-06-29 22:19
 **/
public interface ProductMapper {

    List<Product> selectAllProduct();

    Product selectByPrimaryKey(Integer productId);

    int insert(Product product);

    int updateByPrimaryKeySelective(Product product);

    int updateByPrimaryKey(Product product);

    int deleteByPrimaryKey(Integer productId);
}