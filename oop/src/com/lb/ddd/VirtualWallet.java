package com.lb.ddd;

import com.lb.a05.InvalidAmountException;

import java.math.BigDecimal;

public class VirtualWallet {
    private Long id;
    private Long createTime;
    private BigDecimal balance;
    private boolean isAllowedOverdraft;
    private BigDecimal overdraftAmount;
    private BigDecimal frozenAmount;

    // 构造函数
    public VirtualWallet(Long id) {
        this.id = id;
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.isAllowedOverdraft = true;
        this.overdraftAmount = BigDecimal.ZERO;
        this.frozenAmount = BigDecimal.ZERO;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean isAllowedOverdraft() {
        return isAllowedOverdraft;
    }

    public BigDecimal getOverdraftAmount() {
        return overdraftAmount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public BigDecimal getAvailableBalance() {
        BigDecimal totalAvailableBalance = this.balance.subtract(this.frozenAmount);
        if (this.isAllowedOverdraft) {
            totalAvailableBalance = totalAvailableBalance.add(this.overdraftAmount);
        }
        return totalAvailableBalance;
    }

    public void freeze(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Freeze amount must be positive");
        }
        this.frozenAmount = this.frozenAmount.add(amount);
    }

    public void unfreeze(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Unfreeze amount must be positive");
        }
        if (this.frozenAmount.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient frozen balance to unfreeze");
        }
        this.frozenAmount = this.frozenAmount.subtract(amount);
    }

    public void increaseOverdraftAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Overdraft amount must be positive");
        }
        this.overdraftAmount = this.overdraftAmount.add(amount);
    }

    public void decreaseOverdraftAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Overdraft amount must be positive");
        }
        if (this.overdraftAmount.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient overdraft balance to decrease");
        }
        this.overdraftAmount = this.overdraftAmount.subtract(amount);
    }

    public void debit(BigDecimal amount) {
        if (getAvailableBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance for the transaction");
        }
        this.balance = this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("Amount must be positive");
        }
        this.balance = this.balance.add(amount);
    }
}
