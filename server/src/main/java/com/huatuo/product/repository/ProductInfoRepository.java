package com.huatuo.product.repository;

import com.huatuo.product.common.ProductInfoOutput;
import com.huatuo.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfoOutput> findByProductIdIn(List<String> productIdList);
}
