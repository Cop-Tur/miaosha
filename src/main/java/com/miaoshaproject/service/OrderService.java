package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.OrderModel;

/**
 * @author: yaoyw@asiainfo.com
 * @description:
 * @date: 2020/9/3 8:54 下午
 */
public interface OrderService {

    OrderModel createOrder(Integer userId,Integer itemId,Integer promoId,Integer amount) throws BusinessException;
}
