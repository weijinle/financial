package com.bwie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "order_t")
@Data
public class Order implements Serializable {

    @Id
    private String orderId;

    private String chanId;

    private String productId;

    private String chanUserId;

    /**
     * @see com.bwie.entity.enums.OrderType
     */
    private String orderType;

    /**
     * @see com.bwie.entity.enums.OrderStatus
     */
    private String orderStatus;

    private String outerOrderId;

    private String amount;

    private String memo;

    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private Date createAt;

    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private Date updateAt;
}