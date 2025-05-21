package com.rbl.accounts.dto.request.trade;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@Schema(name = "查询交易记录请求体")
public class TradeInfoReq {
    @Schema(name = "用户id")
    private String userId;

    @Schema(name = "项目类型", required = true)
    @NotNull(message = "不能为空")
    private String projectId;

    @Schema(name = "交易批次")
    private String batchNo;
}
