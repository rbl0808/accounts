package com.rbl.accounts.dto.request.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@ApiModel("交易记录删除请求体")
public class TradeDeleteReq {
    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "交易id",required = true)
    @NotNull(message = "不能为空")
    private String tradeId;

    @ApiModelProperty(value = "可见状态",required = true)
    @NotNull(message = "不能为空")
    private int state;

}
