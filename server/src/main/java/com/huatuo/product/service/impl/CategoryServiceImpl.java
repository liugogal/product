package com.huatuo.product.service.impl;

import com.huatuo.product.dataobject.ProductCategory;
import com.huatuo.product.repository.ProductCategoryRepository;
import com.huatuo.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {

        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);

    }
}
