package com.rbl.accounts.dto.response.goods;

import com.rbl.accounts.model.Goods;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@Schema(name = "查询交易记录返回体")
public class GoodsInfoRes {
    @Schema(name = "商品列表")
    private List<Goods> goodsInfos;
}
