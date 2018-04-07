package com.huatuo.product.service;

import com.huatuo.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
