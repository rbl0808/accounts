package com.rbl.accounts.service.impl;

import com.rbl.accounts.dao.GoodsDao;
import com.rbl.accounts.dto.request.goods.GoodsAddReq;
import com.rbl.accounts.dto.request.goods.GoodsDeleteReq;
import com.rbl.accounts.dto.request.goods.GoodsInfoReq;
import com.rbl.accounts.dto.response.TradeOperateRes;
import com.rbl.accounts.dto.response.goods.GoodsInfoRes;
import com.rbl.accounts.model.Goods;
import com.rbl.accounts.service.GoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zxd
 * @date 2021/8/5
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 查询所有商品
     *
     * @param goodsInfoReq
     * @return
     */
    @Override
    public GoodsInfoRes find(GoodsInfoReq goodsInfoReq) {
        GoodsInfoRes res = new GoodsInfoRes();

        Goods goods = new Goods();
        goods.setProjectId(goodsInfoReq.getProjectId());
        if (StringUtils.isNotBlank(goodsInfoReq.getGoodsId())) {
            goods.setGoodsId(goodsInfoReq.getGoodsId());
        }

        List<Goods> goodsList = goodsDao.find(goods);
        res.setGoodsInfos(goodsList);
        return res;
    }

    /**
     * 新增商品
     *
     * @param addReq
     * @return
     */
    @Override
    public TradeOperateRes add(GoodsAddReq addReq) {
        TradeOperateRes res = new TradeOperateRes();

        //生成goodsId
        String goodsId = getMaxGoodsId(addReq.getProjectId());

        //新增
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        goods.setProjectId(addReq.getProjectName());
        if (StringUtils.isNotBlank(addReq.getGoodsName())) {
            goods.setGoodsName(addReq.getGoodsName());
        }
        if (StringUtils.isNotBlank(addReq.getProjectName())) {
            goods.setProjectName(addReq.getProjectName());
        }
        goods.setCreateTime(new Date());

        Boolean flag = goodsDao.add(goods);
        if (flag) {
            res.setFlag("1");
        } else {
            res.setFlag("0");
            res.setError("新增失败");
        }
        return res;
    }

    /**
     * 删除商品
     *
     * @param goodsDeleteReq
     * @return
     */
    @Override
    public TradeOperateRes delete(GoodsDeleteReq goodsDeleteReq) {
        TradeOperateRes res = new TradeOperateRes();
        Goods findGoods = new Goods();
        findGoods.setGoodsId(goodsDeleteReq.getGoodsId());
        findGoods.setProjectId(goodsDeleteReq.getProjectId());
        List<Goods> goodsList = goodsDao.find(findGoods);

        if (goodsList == null || goodsList.size() == 0) {
            res.setFlag("-1");
            res.setError("商品不存在");
            return res;
        }

        Goods goods = new Goods();
        goods.setGoodsId(goodsDeleteReq.getGoodsId());
        goods.setProjectId(goodsDeleteReq.getProjectId());
        goods.setState(goodsDeleteReq.getState());
        goods.setUpdateTime(new Date());

        Boolean flag = goodsDao.delete(goods);
        if (flag) {
            res.setFlag("1");
        } else {
            res.setFlag("0");
            res.setError("新增失败");
        }
        return res;
    }


    private String getMaxGoodsId(String projectId) {
        String goodsId = "";
        Goods goodsMaxId = new Goods();
        goodsMaxId.setProjectId(projectId);
        goodsId = goodsDao.getMaxGoodsId(goodsMaxId);
        if (StringUtils.isNotBlank(goodsId)) {
            int tmp = Integer.parseInt(goodsId) + 1;
            goodsId = tmp + "";
        } else {
            goodsId = projectId + "0001";
        }
        return goodsId;
    }
}
