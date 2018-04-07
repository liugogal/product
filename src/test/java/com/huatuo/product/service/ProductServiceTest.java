package com.huatuo.product.service;

import com.huatuo.product.ProductApplicationTests;
import com.huatuo.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }

}