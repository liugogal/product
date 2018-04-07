package com.huatuo.product.service.impl;

import com.huatuo.product.dataobject.ProductInfo;
import com.huatuo.product.enums.ProductStatusEnum;
import com.huatuo.product.repository.ProductInfoRepository;
import com.huatuo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
