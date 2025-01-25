package com.lb.mvc;

import java.math.BigDecimal;

public class VirtualWalletBo {
    private Long id;
    private Long createTime;
    private BigDecimal balance;

    // 省略 getter/setter/constructor 方法
    public VirtualWalletBo(Long id, Long createTime, BigDecimal balance) {
        this.id = id;
        this.createTime = createTime;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
