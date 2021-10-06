package com.rbl.accounts.dao.impl;

import com.rbl.accounts.dao.GoodsDao;
import com.rbl.accounts.mapper.GoodsMapper;
import com.rbl.accounts.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zxd
 * @date 2021/7/11
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private GoodsMapper goodsMapper;
    /**
     * 查找所有商品类型
     *
     * @param goods
     * @return
     */
    @Override
    public List<Goods> find(Goods goods) {
        setFlag(goods);
        return goodsMapper.find(goods);
    }

    /**
     * 新增商品类型
     *
     * @param goods
     * @return
     */
    @Override
    public Boolean add(Goods goods) {
        setFlag(goods);
        return goodsMapper.add(goods);
    }

    /**
     * 更改商品类型
     *
     * @param goods
     * @return
     */
    @Override
    public Boolean update(Goods goods) {
        setFlag(goods);
        return goodsMapper.update(goods);
    }

    /**
     * 删除商品
     *
     * @param goods
     * @return
     */
    @Override
    public Boolean delete(Goods goods) {
        return goodsMapper.delete(goods);
    }

    /**
     * 获取最大的商品id
     *
     * @param goods
     * @return
     */
    @Override
    public String getMaxGoodsId(Goods goods) {
        return goodsMapper.getMaxGoodsId(goods);
    }

    private Goods setFlag(Goods goods) {
        if (null == goods.getState()) {
            goods.setState(1);
        }
        return goods;
    }
}
