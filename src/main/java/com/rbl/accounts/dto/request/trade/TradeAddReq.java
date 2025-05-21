package com.rbl.accounts.dto.request.trade;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@Schema(name = "交易记录增加请求体")
public class TradeAddReq {
    @Schema(name = "用户id")
    private String userId;

    @Schema(name = "项目类型", required = true)
    @NotNull(message = "不能为空")
    private String projectId;

    @Schema(name = "交易批次", required = true)
    @NotNull(message = "不能为空")
    private String batchNo;

    @Schema(name = "物品id")
    private String goodsId;

    @Schema(name = "物品名称", required = true)
    @NotNull(message = "不能为空")
    private String goodsName;

    @Schema(name = "物品数量", required = true)
    @NotNull(message = "不能为空")
    private String goodsCount;

    @Schema(name = "买入价格", required = true)
    @NotNull(message = "不能为空")
    private int income;

    @Schema(name = "卖出价格")
    private int sell;

    @Schema(name = "可见状态")
    private int state;

    @Schema(name = "备注")
    private String remarks;

}
