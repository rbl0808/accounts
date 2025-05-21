package com.rbl.accounts.dto.request.calculate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @author : rbl
 * @date : 2023/5/25
 */
@Data
public class CalculateReq {

    @Schema(name = "计算类型 " +
            " 1-dnf金币寄售购买金币" +
            " 2-uu898游戏币商城收" +
            " 3-uu898矛盾商城收", required = true)
    @NotNull(message = "不能为空")
    private Integer type;

    @Schema(name = "点券优惠比例(点券购买比例) ps:0.835")
    private String taoBaoZheKou;

    @Schema(name = "金币寄售比例 点券/亿 100点券=1元")
    private String jinBiPaiMai;

    @Schema(name = "拍卖优惠折扣 默认97折")
    private String paiMaiYouHui;

    @Schema(name = "uu898商城收取金价  万金/元")
    private String goldPriceOfUU898FastDelivery;

    @Schema(name = "uu898商城普通卖金金价 万金/元")
    private String goldPriceOfUU898Normal;

    @Schema(name = "uu898商城收取矛盾  个/元")
    private String amplifyingMaterialOfUU898FastDelivery;

    @Schema(name = "uu898商城普通出售矛盾 个/元")
    private String amplifyingMaterialOfUU898Normal;

    @Schema(name = "uu898提现手续费")
    private String withdrawalProcessingFeeOfUU898;
}
