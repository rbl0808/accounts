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
public class TradeDetail {
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
     * 交易批次id
     */
    private String batchNo;

    /**
     * 交易id
     */
    private String tradeId;

    /**
     * 项目类型
     */
    private String projectId;

    /**
     * 物品id
     */
    private String goodsId;

    /**
     * 物品名称
     */
    private String goodsName;

    /**
     * 物品数量
     */
    private String goodsCount;

    /**
     * 买入价格
     */
    private Integer income;

    /**
     * 卖出价格
     */
    private Integer sell;


    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 出售时间
     */
    private Date sellTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
