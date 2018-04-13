package com.huatuo.product.controller;

import com.huatuo.product.VO.ProductInfoVO;
import com.huatuo.product.VO.ProductVO;
import com.huatuo.product.VO.ResultVO;
import com.huatuo.product.common.DecreaseStockInput;
import com.huatuo.product.common.ProductInfoOutput;
import com.huatuo.product.dataobject.ProductCategory;
import com.huatuo.product.dataobject.ProductInfo;
import com.huatuo.product.dto.CartDTO;
import com.huatuo.product.service.CategoryService;
import com.huatuo.product.service.ProductService;
import com.huatuo.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "/list")
    public ResultVO<ProductVO> list() {
        //1、查询上架商品列表
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2、获取商品中的类目列表
        List<Integer> categoryTypeList = productInfoList.stream()
//                .map(productInfo -> productInfo.getCategoryType())
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3、从数据库中查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4、构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());//设置类目名
            productVO.setCategoryType(productCategory.getCategoryType());//设置类目类型

            List<ProductInfoVO> productInfoVoList = new ArrayList<>();
            //遍历商品列表，找到类目所对应的商品
            for (ProductInfo productInfo : productInfoList) {

                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVoList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVoList);//设置类目下商品列表
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);


    }

    /**
     * 获取商品列表(给订单服务用的)
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);
    }


}
