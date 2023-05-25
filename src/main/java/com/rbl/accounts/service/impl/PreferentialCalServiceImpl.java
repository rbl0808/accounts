package com.rbl.accounts.service.impl;

import com.rbl.accounts.dto.request.calculate.CalculateReq;
import com.rbl.accounts.enums.CalculateEnums;
import com.rbl.accounts.service.PreferentialCalService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author : rbl
 * @date : 2023/5/25
 */
@Service
public class PreferentialCalServiceImpl implements PreferentialCalService {
    @Override
    public String calculate(CalculateReq calculateReq) {
        String checkParam = checkParam(calculateReq);
        if (StringUtils.isNotBlank(checkParam)) {
            return checkParam;
        }
        String res = "";
        if (calculateReq.getType() == CalculateEnums.BUYGOLDBYGOLDCOINS.getCode()) {
            //dnf金币寄售购买金币
            res = calGoldJiShou(calculateReq);
        } else if (calculateReq.getType() == CalculateEnums.BUYGOLDBYFASTDELIVERY.getCode()) {
            //uu898商城收游戏币
        } else if (calculateReq.getType() == CalculateEnums.BUYAMPLIFYINGMATERIABYFASTDELIVERY.getCode()) {
            //uu898商城收矛盾
        }

        return res;
    }

    /**
     * 校验入参
     *
     * @param req
     * @return
     */
    private String checkParam(CalculateReq req) {
        if (req.getType() == CalculateEnums.BUYGOLDBYGOLDCOINS.getCode()) {
            //dnf金币寄售购买金币
            if (StringUtils.isBlank(req.getTaoBaoZheKou())) {
                return "计算dnf金币寄售购买金币时,点券购买比例不能为空";
            }

            if (StringUtils.isBlank(req.getJinBiPaiMai())) {
                return "计算dnf金币寄售购买金币时,金币寄售比例不能为空";
            }

            if (StringUtils.isBlank(req.getPaiMaiYouHui())) {
                req.setPaiMaiYouHui("0.97");
            }
        }

        if (req.getType() == CalculateEnums.BUYGOLDBYFASTDELIVERY.getCode()) {
            //uu898商城收游戏币
        }

        if (req.getType() == CalculateEnums.BUYAMPLIFYINGMATERIABYFASTDELIVERY.getCode()) {
            //uu898商城收矛盾
        }
        return "";
    }

    /**
     * 计算dnf金币寄售购买金币
     *
     * @param req
     * @return
     */
    private String calGoldJiShou(CalculateReq req) {
        BigDecimal x = new BigDecimal(100000000);

        // 1亿金币寄售价格
        BigDecimal y = new BigDecimal(req.getJinBiPaiMai());

        // 点券折扣
        BigDecimal z = new BigDecimal(req.getTaoBaoZheKou());
        /**真实价格**/
        BigDecimal realPrice = x.divide(y.multiply(z), 5, BigDecimal.ROUND_UP);


        // 拍卖打折 一般0.97
        BigDecimal r = new BigDecimal(req.getPaiMaiYouHui());
        /**玩家收取价格**/
        BigDecimal getFromGamer = realPrice.divide(r, 5, BigDecimal.ROUND_UP);

        /**uu898去除手续费**/
        BigDecimal q = new BigDecimal(1 - 0.0049);
        BigDecimal getFromFast = getFromGamer.divide(q, 5, BigDecimal.ROUND_UP);

        /**建议出售价格**/
        BigDecimal paiMai = new BigDecimal(req.getPaiMaiYouHui());
        BigDecimal shouXuFei = new BigDecimal(1).subtract(paiMai).multiply(new BigDecimal(100));
        //直接出玩家
        BigDecimal directSalePrice = getFromGamer.multiply(paiMai);

        // 走普通网站
        MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal uu898Normal = paiMai.add(new BigDecimal(0.02), mc);
        //不算提现手续费
        BigDecimal uu898NormalSalePrice = realPrice.multiply(uu898Normal);

        //算提现手续费 50元上限,在20000时到顶
        BigDecimal v = new BigDecimal(20000).multiply(format(uu898NormalSalePrice));
        BigDecimal noProfit = v.divide(new BigDecimal(20050),5,BigDecimal.ROUND_UP);

        StringBuilder sb = new StringBuilder(" 金币到手比例:").append(format(realPrice)).append("万/元;\n")
                .append(" 相当于uu898普通收币比例: ").append(format(getFromGamer)).append("万/元;\n")
                .append(" 相当于uu898商城收货收币比例: ").append(format(getFromFast)).append("万/元;\n")
                .append(" 在拍卖手续费为: ").append(shouXuFei).append("%时,\n")
                .append(" 不亏损直接出手价格: ").append(format(directSalePrice)).append("万/元;\n")
                .append(" 不亏损无提现手续费uu898出手价格: ").append(format(uu898NormalSalePrice)).append("万/元;\n")
                .append(" 不亏损有提现手续费uu898出手价格: ").append(noProfit).append("万/元;\n");


        return sb.toString();
    }

    private BigDecimal format(BigDecimal source) {
        return source.divide(new BigDecimal(100), 5, BigDecimal.ROUND_UP);
    }
}




























