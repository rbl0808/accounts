package com.rbl.accounts.service.impl;

import com.rbl.accounts.dao.TradeDetailDao;
import com.rbl.accounts.dto.request.trade.TradeAddReq;
import com.rbl.accounts.dto.request.trade.TradeDeleteReq;
import com.rbl.accounts.dto.request.trade.TradeInfoReq;
import com.rbl.accounts.dto.request.trade.TradeUpdateReq;
import com.rbl.accounts.dto.response.TradeOperateRes;
import com.rbl.accounts.dto.response.trade.TradeInfoRes;
import com.rbl.accounts.model.Goods;
import com.rbl.accounts.model.TradeDetail;
import com.rbl.accounts.service.TradeService;
import com.rbl.accounts.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeDetailDao tradeDetailDao;

    @Autowired
    private CommonUtils commonUtils;

    /**
     * 新增交易记录
     *
     * @param tradeAddReq@return
     */
    @Override
    public TradeOperateRes add(TradeAddReq tradeAddReq) {
        TradeOperateRes res = new TradeOperateRes();

        if (StringUtils.isBlank(tradeAddReq.getUserId())) {
            tradeAddReq.setUserId("rbl");
        }

        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setUserId(tradeAddReq.getUserId());
        tradeDetail.setBatchNo(tradeAddReq.getBatchNo());
        tradeDetail.setProjectId(tradeAddReq.getProjectId());
        tradeDetail.setTradeId(commonUtils.getTradeId(tradeAddReq.getUserId()));
        tradeDetail.setGoodsId(tradeAddReq.getGoodsId());
        tradeDetail.setGoodsName(tradeAddReq.getGoodsName());
        tradeDetail.setGoodsCount(tradeAddReq.getGoodsCount());
        tradeDetail.setIncome(tradeAddReq.getIncome());
        tradeDetail.setRemarks(tradeAddReq.getRemarks());
        tradeDetail.setState(1);
        tradeDetail.setCreateTime(new Date());
        if (0 != tradeAddReq.getSell()) {
            tradeDetail.setSell(tradeAddReq.getSell());
            tradeDetail.setSellTime(new Date());
        }
        Boolean flag = tradeDetailDao.add(tradeDetail);

        if (flag) {
            res.setFlag("OK");
        } else {
            res.setFlag("ERROR");
        }
        return res;
    }

    /**
     * 更改交易记录
     *
     * @param tradeUpdateReq
     * @return
     */
    @Override
    public TradeOperateRes update(TradeUpdateReq tradeUpdateReq) {
        TradeOperateRes res = new TradeOperateRes();

        if (StringUtils.isBlank(tradeUpdateReq.getUserId())) {
            tradeUpdateReq.setUserId("rbl");
        }

        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setUserId(tradeUpdateReq.getUserId());
        tradeDetail.setTradeId(tradeUpdateReq.getTradeId());
        if (StringUtils.isNotBlank(tradeUpdateReq.getProjectId())) {
            tradeDetail.setProjectId(tradeUpdateReq.getProjectId());
        }

        if (StringUtils.isNotBlank(tradeUpdateReq.getBatchNo())) {
            tradeDetail.setBatchNo(tradeUpdateReq.getBatchNo());
        }

        if (StringUtils.isNotBlank(tradeUpdateReq.getGoodsId())) {
            tradeDetail.setGoodsId(tradeUpdateReq.getGoodsId());
        }

        if (StringUtils.isNotBlank(tradeUpdateReq.getGoodsName())) {
            tradeDetail.setGoodsName(tradeUpdateReq.getGoodsName());
        }

        if (StringUtils.isNotBlank(tradeUpdateReq.getGoodsCount())) {
            tradeDetail.setGoodsCount(tradeUpdateReq.getGoodsCount());
        }

        if (0 != tradeUpdateReq.getIncome()) {
            tradeDetail.setIncome(tradeUpdateReq.getIncome());
        }

        if (0 != tradeUpdateReq.getSell()) {
            tradeDetail.setSell(tradeUpdateReq.getSell());
            tradeDetail.setSellTime(new Date());
        }

        if (StringUtils.isNotBlank(tradeUpdateReq.getRemarks())) {
            tradeDetail.setRemarks(tradeUpdateReq.getRemarks());
        }

        if (0 != tradeUpdateReq.getState() || 1 != tradeUpdateReq.getState()) {
            tradeDetail.setState(tradeUpdateReq.getState());
        }

        tradeDetail.setUpdateTime(new Date());
        Boolean flag = tradeDetailDao.update(tradeDetail);

        if (flag) {
            res.setFlag("OK");
        } else {
            res.setFlag("ERROR");
        }
        return res;
    }

    /**
     * 删除交易记录
     *
     * @param tradeDeleteReq
     * @return
     */
    @Override
    public TradeOperateRes delete(TradeDeleteReq tradeDeleteReq) {
        TradeOperateRes res = new TradeOperateRes();

        if (StringUtils.isBlank(tradeDeleteReq.getUserId())) {
            tradeDeleteReq.setUserId("rbl");
        }

        TradeDetail findTradeDetail = new TradeDetail();
        findTradeDetail.setUserId(tradeDeleteReq.getUserId());
        findTradeDetail.setTradeId(tradeDeleteReq.getTradeId());
        List<TradeDetail> tradeDetails = tradeDetailDao.find(findTradeDetail);
        if (tradeDetails == null || tradeDetails.size() == 0) {
            res.setFlag("-1");
            res.setError("交易记录不存在");
            return res;
        }

        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setUserId(tradeDeleteReq.getUserId());
        tradeDetail.setTradeId(tradeDeleteReq.getTradeId());
        tradeDetail.setState(tradeDeleteReq.getState());
        tradeDetail.setUpdateTime(new Date());
        Boolean flag = tradeDetailDao.delete(tradeDetail);

        if (flag) {
            res.setFlag("OK");
        } else {
            res.setFlag("ERROR");
        }
        return res;
    }

    /**
     * 查询交易记录
     *
     * @param tradeInfoReq
     * @return
     */
    @Override
    public TradeInfoRes find(TradeInfoReq tradeInfoReq) {
        TradeInfoRes tradeInfoRes = new TradeInfoRes();

        TradeDetail tradeDetail = new TradeDetail();
        BeanUtils.copyProperties(tradeInfoReq, tradeDetail);
        List<TradeDetail> tradeDetails = tradeDetailDao.find(tradeDetail);
        for (TradeDetail tmp : tradeDetails) {
            commonUtils.filling(tmp);
        }

        tradeInfoRes.setTradeInfos(tradeDetails);

        return tradeInfoRes;
    }
}
