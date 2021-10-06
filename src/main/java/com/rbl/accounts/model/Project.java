package com.rbl.accounts.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author zxd
 * @date 2021/7/10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Project {
    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 项目类型
     */
    private String projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 状态
     */
    private int state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
