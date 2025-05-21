package com.rbl.accounts.dto.response.project;

import com.rbl.accounts.model.Project;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@Schema(name = "查询交易记录返回体")
public class ProjectInfoRes {
    @Schema(name = "交易记录")
    private List<Project> projects;
}
