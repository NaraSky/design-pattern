package com.lb.ddd;

import com.lb.mvc.VirtualWalletEntity;
import com.lb.mvc.VirtualWalletTransactionEntity;

import java.math.BigDecimal;

public interface VirtualWalletRepository {
    VirtualWalletEntity getWalletEntity(Long walletId);
    void updateBalance(Long walletId, BigDecimal balance);
}

