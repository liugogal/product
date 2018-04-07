package com.huatuo.product.service;

import com.huatuo.product.ProductApplicationTests;
import com.huatuo.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class CategoryServiceTest extends ProductApplicationTests {

    @Autowired
    CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(productCategoryList.size() > 0);

    }

}