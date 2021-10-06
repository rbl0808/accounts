package com.rbl.accounts.service;

import com.rbl.accounts.dto.request.trade.TradeAddReq;
import com.rbl.accounts.dto.request.trade.TradeDeleteReq;
import com.rbl.accounts.dto.request.trade.TradeInfoReq;
import com.rbl.accounts.dto.request.trade.TradeUpdateReq;
import com.rbl.accounts.dto.response.TradeOperateRes;
import com.rbl.accounts.dto.response.trade.TradeInfoRes;

public interface TradeService {
    /**
     * 新增交易记录
     *
     * @param tradeAddReq
     * @return
     */
    TradeOperateRes add(TradeAddReq tradeAddReq);


    /**
     * 更改交易记录
     *
     * @param tradeUpdateReq
     * @return
     */
    TradeOperateRes update(TradeUpdateReq tradeUpdateReq);

    /**
     * 删除交易记录
     *
     * @param tradeUpdateReq
     * @return
     */
    TradeOperateRes delete(TradeDeleteReq tradeDeleteReq);

    /**
     * 查询交易记录
     *
     * @param tradeOperateReq
     * @return
     */
    TradeInfoRes find(TradeInfoReq tradeInfoReq);

}
