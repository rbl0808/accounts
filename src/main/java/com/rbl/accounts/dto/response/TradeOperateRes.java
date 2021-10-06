package com.rbl.accounts.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("交易记录增删改返回体")
public class TradeOperateRes {
    @ApiModelProperty("提交状态")
    private String flag;

    @ApiModelProperty("错误信息")
    private String error;
}
