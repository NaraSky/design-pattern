package com.lb.mvc;

import java.math.BigDecimal;

public class VirtualWalletController {
    // 通过构造函数或者 IOC 框架注入
    private VirtualWalletService virtualWalletService;

    public VirtualWalletController(VirtualWalletService virtualWalletService) {
        this.virtualWalletService = virtualWalletService;
    }

    // 查询余额
    public BigDecimal getBalance(Long walletId) {
        return virtualWalletService.getBalance(walletId);
    }

    // 出账
    public void debit(Long walletId, BigDecimal amount) {
        virtualWalletService.debit(walletId, amount);
    }

    // 入账
    public void credit(Long walletId, BigDecimal amount) {
        virtualWalletService.credit(walletId, amount);
    }

    // 转账
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        virtualWalletService.transfer(fromWalletId, toWalletId, amount);
    }
}
