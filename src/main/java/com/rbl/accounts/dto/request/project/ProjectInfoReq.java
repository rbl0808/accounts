package com.rbl.accounts.dto.request.project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@ApiModel("查询项目类型请求体")
public class ProjectInfoReq {
    @ApiModelProperty(value = "用户id")
    private String userId;
}
