package com.huatuo.product.service.impl;

import com.huatuo.product.dataobject.ProductInfo;
import com.huatuo.product.dto.CartDTO;
import com.huatuo.product.enums.ProductStatusEnum;
import com.huatuo.product.enums.ResultEnum;
import com.huatuo.product.exception.ProductException;
import com.huatuo.product.repository.ProductInfoRepository;
import com.huatuo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {

        return productInfoRepository.findByProductIdIn(productIdList);
    }


    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        //遍历传入参数，通过id查询库存是否满足
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            //判断id对应的商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //判断数量是否够扣
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
