package com.fox.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

@TableName(value = "account_tbl")
public class Account {
    @TableId(value = t.id)
    private Integer id;
    @TableField(value = t.user_id)
    private String userId;
    @TableField(value = t.money)
    private BigDecimal money;

    public final static class t {
        public static final String id = "id";
        public static final String user_id = "user_id";
        public static final String money = "money";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
