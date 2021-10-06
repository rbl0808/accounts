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
@ApiModel("查询交易记录请求体")
public class TradeInfoReq {
    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "项目类型", required = true)
    @NotNull(message = "不能为空")
    private String projectId;

    @ApiModelProperty(value = "交易批次")
    private String batchNo;
}
