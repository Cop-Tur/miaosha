package com.miaoshaproject.service;

import com.miaoshaproject.service.model.PromoModel;

/**
 * @author: yaoyw@asiainfo.com
 * @description:
 * @date: 2020/9/5 4:58 下午
 */
public interface PromoService {

    PromoModel getPromoByItemId(Integer itemId);
}
