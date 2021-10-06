package com.rbl.accounts.service;


import com.rbl.accounts.dto.request.goods.GoodsAddReq;
import com.rbl.accounts.dto.request.goods.GoodsDeleteReq;
import com.rbl.accounts.dto.request.goods.GoodsInfoReq;
import com.rbl.accounts.dto.response.TradeOperateRes;
import com.rbl.accounts.dto.response.goods.GoodsInfoRes;

public interface GoodsService {
    /**
     * 查询所有商品
     * @param goodsInfoReq
     * @return
     */
    GoodsInfoRes find(GoodsInfoReq goodsInfoReq);

    /**
     * 新增商品
     * @param addReq
     * @return
     */
    TradeOperateRes add(GoodsAddReq addReq);

    /**
     * 删除商品
     * @param goodsDeleteReq
     * @return
     */
    TradeOperateRes delete(GoodsDeleteReq goodsDeleteReq);
}
