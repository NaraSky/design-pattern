package com.lb.ddd;

import java.math.BigDecimal;

public class VirtualWalletEntity {
    private Long id;
    private Long createTime;
    private BigDecimal balance;

    // Getter/Setter 方法
    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
