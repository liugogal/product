package com.huatuo.product.utils;

import com.huatuo.product.VO.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO<Object> resultVO = new ResultVO<>();

        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;

    }

}
