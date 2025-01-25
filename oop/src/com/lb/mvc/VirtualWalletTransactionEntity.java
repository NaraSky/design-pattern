package com.lb.mvc;

import java.math.BigDecimal;

public class VirtualWalletTransactionEntity {
    private Long transactionId;
    private Long fromWalletId;
    private Long toWalletId;
    private BigDecimal amount;
    private Long createTime;
    private Status status;

    // Getter/Setter methods
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setFromWalletId(Long fromWalletId) {
        this.fromWalletId = fromWalletId;
    }

    public void setToWalletId(Long toWalletId) {
        this.toWalletId = toWalletId;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}