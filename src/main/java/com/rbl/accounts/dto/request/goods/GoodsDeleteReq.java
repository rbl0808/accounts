package com.rbl.accounts.dto.request.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@ApiModel("商品删除请求体")
public class GoodsDeleteReq {
    @ApiModelProperty(value = "项目类型", required = true)
    @NotNull(message = "不能为空")
    private String projectId;

    @ApiModelProperty(value = "物品id",required = true)
    @NotNull(message = "不能为空")
    private String goodsId;


    @ApiModelProperty(value = "可见状态",required = true)
    @NotNull(message = "不能为空")
    private int state;


}
