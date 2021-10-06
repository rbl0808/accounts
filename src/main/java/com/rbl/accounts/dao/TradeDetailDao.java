package com.rbl.accounts.dao;

import com.rbl.accounts.model.TradeDetail;

import java.util.List;

/**
 * @author zxd
 * @date 2021/7/11
 */
public interface TradeDetailDao {
    /**
     * 查找交易记录
     *
     * @param tradeDetail
     * @return
     */
    List<TradeDetail> find(TradeDetail tradeDetail);

    /**
     * 新增交易记录
     *
     * @param tradeDetail
     * @return
     */
    Boolean add(TradeDetail tradeDetail);

    /**
     * 更新交易记录
     *
     * @param tradeDetail
     * @return
     */
    Boolean update(TradeDetail tradeDetail);

    /**
     * 删除
     *
     * @param tradeDetail
     * @return
     */
    Boolean delete(TradeDetail tradeDetail);
}
