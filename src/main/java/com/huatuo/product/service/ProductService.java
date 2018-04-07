package com.huatuo.product.service;

import com.huatuo.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    /**
     * 获取所有上架信息
     * @return
     */
    public List<ProductInfo> findUpAll();
}
