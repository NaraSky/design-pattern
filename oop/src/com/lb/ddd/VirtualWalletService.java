package com.lb.ddd;

import com.lb.mvc.*;

import java.math.BigDecimal;

public class VirtualWalletService {
    private VirtualWalletRepository walletRepo;
    private VirtualWalletTransactionRepository transactionRepo;

    // 通过构造函数注入仓库
    public VirtualWalletService(VirtualWalletRepository walletRepo, VirtualWalletTransactionRepository transactionRepo) {
        this.walletRepo = walletRepo;
        this.transactionRepo = transactionRepo;
    }

    // 获取虚拟钱包信息
    public VirtualWallet getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        return new VirtualWallet(walletEntity.getId());
    }

    // 获取余额
    public BigDecimal getBalance(Long walletId) {
        VirtualWallet wallet = getVirtualWallet(walletId);
        return wallet.getBalance();
    }

    // 出账操作
    public void debit(Long walletId, BigDecimal amount) {
        VirtualWallet wallet = getVirtualWallet(walletId);
        wallet.debit(amount);
        walletRepo.updateBalance(walletId, wallet.getBalance());
    }

    // 入账操作
    public void credit(Long walletId, BigDecimal amount) {
        VirtualWallet wallet = getVirtualWallet(walletId);
        wallet.credit(amount);
        walletRepo.updateBalance(walletId, wallet.getBalance());
    }

    // 转账操作
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        // 创建交易记录
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setStatus(Status.TO_BE_EXECUTED);

        Long transactionId = transactionRepo.saveTransaction(transactionEntity);

        try {
            // 出账
            debit(fromWalletId, amount);
            // 入账
            credit(toWalletId, amount);
            // 更新交易状态为已执行
            transactionRepo.updateStatus(transactionId, Status.EXECUTED);
        } catch (InsufficientBalanceException e) {
            transactionRepo.updateStatus(transactionId, Status.FAILED);
            throw e; // 异常抛出
        } catch (Exception e) {
            transactionRepo.updateStatus(transactionId, Status.FAILED);
            throw new RuntimeException("Transfer failed", e); // 异常处理
        }
    }
}
