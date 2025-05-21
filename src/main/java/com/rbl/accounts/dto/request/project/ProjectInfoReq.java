package com.rbl.accounts.dto.request.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@Schema(name = "查询项目类型请求体")
public class ProjectInfoReq {
    @Schema(name = "用户id")
    private String userId;
}
