package com.hfq.api.model;

import lombok.Data;

@Data
public class Product {
    // 产品id
    private Integer productId;
    // 产品名字
    private String productName;
    // 产品详情
    private String productDetail;

}