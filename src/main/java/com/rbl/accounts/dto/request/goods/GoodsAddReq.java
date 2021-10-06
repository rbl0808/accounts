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
@ApiModel("商品增加请求体")
public class GoodsAddReq {
    @ApiModelProperty(value = "项目类型", required = true)
    @NotNull(message = "不能为空")
    private String projectId;

    @ApiModelProperty(value = "物品名称")
    private String goodsName;

    @ApiModelProperty(value = "项目名称")
    private String projectName;
}
