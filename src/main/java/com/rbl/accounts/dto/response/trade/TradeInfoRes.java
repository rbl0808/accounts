package com.rbl.accounts.dto.response.trade;

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
public class TradeInfoRes {
    @ApiModelProperty("交易记录")
    private List<TradeDetail> tradeInfos;
}
