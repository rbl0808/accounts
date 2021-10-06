package com.rbl.accounts.dao;

import com.rbl.accounts.model.Goods;

import java.util.List;

/**
 * @author zxd
 * @date 2021/7/15
 */
public interface GoodsDao {
    /**
     * 查找所有商品
     *
     * @param goods
     * @return
     */
    List<Goods> find(Goods goods);

    /**
     * 新增商品
     *
     * @param goods
     * @return
     */
    Boolean add(Goods goods);

    /**
     * 更改商品
     *
     * @param goods
     * @return
     */
    Boolean update(Goods goods);

    /**
     * 删除商品
     *
     * @param goods
     * @return
     */
    Boolean delete(Goods goods);

    /**
     * 获取最大的商品id
     * @param goods
     * @return
     */
    String getMaxGoodsId(Goods goods);
}
