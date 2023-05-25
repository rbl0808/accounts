package com.rbl.accounts.enums;

/**
 * @author : rbl
 * @date : 2023/5/25
 */
public enum CalculateEnums {

    BUYGOLDBYGOLDCOINS(1, "dnf金币寄售购买金币"),
    BUYGOLDBYFASTDELIVERY(2, "uu898游戏币商城收"),
    BUYAMPLIFYINGMATERIABYFASTDELIVERY(3, "uu898矛盾商城收")
    ;


    private int code;
    private String desc;

    CalculateEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

}
