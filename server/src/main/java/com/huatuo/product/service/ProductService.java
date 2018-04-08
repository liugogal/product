package com.huatuo.product.service;

import com.huatuo.product.common.DecreaseStockInput;
import com.huatuo.product.common.ProductInfoOutput;
import com.huatuo.product.dataobject.ProductInfo;
import com.huatuo.product.dto.CartDTO;

import java.util.List;

public interface ProductService {

    /**
     * 获取所有上架信息
     * @return
     */
    List<ProductInfo> findUpAll();


    /**
     * 通过商品id列表获取商品
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);


    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<DecreaseStockInput> cartDTOList);
}
