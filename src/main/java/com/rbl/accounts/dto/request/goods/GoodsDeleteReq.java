package com.rbl.accounts.dto.request.goods;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@Schema(name = "商品删除请求体")
public class GoodsDeleteReq {
    @Schema(name = "项目类型", required = true)
    @NotNull(message = "不能为空")
    private String projectId;

    @Schema(name = "物品id",required = true)
    @NotNull(message = "不能为空")
    private String goodsId;


    @Schema(name = "可见状态",required = true)
    @NotNull(message = "不能为空")
    private int state;


}
