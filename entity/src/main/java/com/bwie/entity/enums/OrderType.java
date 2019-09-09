package com.bwie.entity.enums;

import lombok.Getter;

/**
 *  订单类型
 */
@Getter
public enum OrderType {

    APPLY("申购"),

    REDEEM("赎回");

    private String desc;

    OrderType(String desc) {

        this.desc = desc;
    }
}