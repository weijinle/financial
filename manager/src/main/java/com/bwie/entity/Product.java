package com.bwie.entity;


import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Product implements Serializable {

    @Id
    private String id;

    private String name;

    //起投金额
    private BigDecimal thresholdAmount;

    //投资步长
    private BigDecimal stepAmount;

    //锁定期
    private Integer lockTerm;

    //收益率
    private BigDecimal rewardRate;

    /**
     * @see com.bwie.entity.enums.ProductStatus
     */
    private String status;

    private String memo;

    private Date createAt;

    private String createUser;

    private Date updateAt;

    private String updateUser;

}