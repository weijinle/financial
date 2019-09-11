package com.bawei.api.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program:financial
 * @description:
 * @author:Mr.WeiLa
 * @create:2019-09-1109:54
 **/
@Data
public class ProductRpcReq {

    private List<String> idList;

    private BigDecimal minRewardRate;

    private BigDecimal maxRewardRate;

    private List<String> statusList;
}
