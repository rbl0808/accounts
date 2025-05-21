package com.rbl.accounts.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zxd
 * @date 2021/1/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "交易记录增删改返回体")
public class TradeOperateRes {
    @Schema(name = "提交状态")
    private String flag;

    @Schema(name = "错误信息")
    private String error;
}
