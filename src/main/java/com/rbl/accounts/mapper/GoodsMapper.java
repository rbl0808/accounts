package com.rbl.accounts.mapper;

import com.rbl.accounts.model.Goods;
import com.rbl.accounts.model.TradeDetail;

import java.util.List;

public interface GoodsMapper {
    /**
     * 查找所有商品类型
     *
     * @param goods
     * @return
     */
    List<Goods> find(Goods goods);

    /**
     * 新增商品类型
     *
     * @param goods
     * @return
     */
    Boolean add(Goods goods);

    /**
     * 更改商品类型
     *
     * @param goods
     * @return
     */
    Boolean update(Goods goods);

    /**
     * 删除商品(更改可见状态)
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
