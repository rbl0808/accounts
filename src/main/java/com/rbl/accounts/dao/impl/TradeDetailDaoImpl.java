package com.rbl.accounts.dao.impl;

import com.rbl.accounts.dao.TradeDetailDao;
import com.rbl.accounts.mapper.TradeDetailMapper;
import com.rbl.accounts.model.TradeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zxd
 * @date 2021/7/11
 */
@Repository
public class TradeDetailDaoImpl implements TradeDetailDao {
    @Autowired
    TradeDetailMapper tradeDetailMapper;

    /**
     * 查找交易记录
     *
     * @param tradeDetail
     * @return
     */
    @Override
    public List<TradeDetail> find(TradeDetail tradeDetail) {
        setFlag(tradeDetail);
        return tradeDetailMapper.find(tradeDetail);
    }

    /**
     * 新增交易记录
     *
     * @param tradeDetail
     * @return
     */
    @Override
    public Boolean add(TradeDetail tradeDetail) {
        setFlag(tradeDetail);
        return tradeDetailMapper.add(tradeDetail);
    }

    /**
     * 更新交易记录
     *
     * @param tradeDetail
     * @return
     */
    @Override
    public Boolean update(TradeDetail tradeDetail) {
        setFlag(tradeDetail);
        return tradeDetailMapper.update(tradeDetail);
    }

    /**
     * 删除交易记录
     *
     * @param tradeDetail
     * @return
     */
    @Override
    public Boolean delete(TradeDetail tradeDetail) {
        return tradeDetailMapper.delete(tradeDetail);
    }

    private TradeDetail setFlag(TradeDetail tradeDetail) {
        if (null == tradeDetail.getState()) {
            tradeDetail.setState(1);
        }
        return tradeDetail;
    }
}
