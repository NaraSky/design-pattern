package com.lb.mvc;

import java.math.BigDecimal;

public interface VirtualWalletRepository {
    VirtualWalletEntity getWalletEntity(Long walletId);
    void updateBalance(Long walletId, BigDecimal newBalance);
}

