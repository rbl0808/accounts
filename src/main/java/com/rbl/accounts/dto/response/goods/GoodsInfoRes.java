package com.rbl.accounts.dto.response.goods;

import com.rbl.accounts.model.Goods;
import com.rbl.accounts.model.TradeDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@ApiModel("查询交易记录返回体")
public class GoodsInfoRes {
    @ApiModelProperty("商品列表")
    private List<Goods> goodsInfos;
}
