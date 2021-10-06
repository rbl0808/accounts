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
@ApiModel("交易记录增加请求体")
public class TradeAddReq {
    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "项目类型", required = true)
    @NotNull(message = "不能为空")
    private String projectId;

    @ApiModelProperty(value = "交易批次", required = true)
    @NotNull(message = "不能为空")
    private String batchNo;

    @ApiModelProperty(value = "物品id")
    private String goodsId;

    @ApiModelProperty(value = "物品名称", required = true)
    @NotNull(message = "不能为空")
    private String goodsName;

    @ApiModelProperty(value = "物品数量", required = true)
    @NotNull(message = "不能为空")
    private String goodsCount;

    @ApiModelProperty(value = "买入价格", required = true)
    @NotNull(message = "不能为空")
    private int income;

    @ApiModelProperty(value = "卖出价格")
    private int sell;

    @ApiModelProperty(value = "可见状态")
    private int state;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
