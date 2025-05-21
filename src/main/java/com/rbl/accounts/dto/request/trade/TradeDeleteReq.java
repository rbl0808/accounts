package com.rbl.accounts.dto.request.trade;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@Schema( name = "交易记录删除请求体")
public class TradeDeleteReq {
    @Schema(name = "用户id")
    private String userId;

    @Schema(name = "交易id",required = true)
    @NotNull(message = "不能为空")
    private String tradeId;

    @Schema(name = "可见状态",required = true)
    @NotNull(message = "不能为空")
    private int state;

}
