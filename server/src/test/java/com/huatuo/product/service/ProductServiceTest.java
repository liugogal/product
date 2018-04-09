package com.huatuo.product.service;

import com.huatuo.product.ProductApplicationTests;
import com.huatuo.product.common.DecreaseStockInput;
import com.huatuo.product.common.ProductInfoOutput;
import com.huatuo.product.dataobject.ProductInfo;
import com.huatuo.product.dto.CartDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findList() throws Exception{
        List<ProductInfoOutput> productInfoList = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void decreaseStock() throws Exception {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput();
        decreaseStockInput.setProductId("157875196366160022");
        decreaseStockInput.setProductQuantity(2);
        productService.decreaseStock(Arrays.asList(decreaseStockInput));
    }
}