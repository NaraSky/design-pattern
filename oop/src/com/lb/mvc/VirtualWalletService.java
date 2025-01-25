package com.lb.mvc;

import java.math.BigDecimal;

public class VirtualWalletService {
    // 通过构造函数或者 IOC 框架注入
    private VirtualWalletRepository walletRepo;
    private VirtualWalletTransactionRepository transactionRepo;

    public VirtualWalletService(VirtualWalletRepository walletRepo, VirtualWalletTransactionRepository transactionRepo) {
        this.walletRepo = walletRepo;
        this.transactionRepo = transactionRepo;
    }

    // 获取钱包信息
    public VirtualWalletBo getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletBo walletBo = convert(walletEntity); // 假设有一个 convert 方法将 entity 转换成 BO
        return walletBo;
    }

    // 查询余额
    public BigDecimal getBalance(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        return walletEntity.getBalance();
    }

    // 出账
    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        if (balance.compareTo(amount) < 0) {
            throw new NoSufficientBalanceException("Insufficient balance for wallet: " + walletId);
        }
        walletRepo.updateBalance(walletId, balance.subtract(amount));
    }

    // 入账
    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        walletRepo.updateBalance(walletId, balance.add(amount));
    }

    // 转账
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        // 创建交易记录
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setStatus(Status.TO_BE_EXECUTED); // 初始状态为待执行

        // 保存交易记录
        Long transactionId = transactionRepo.saveTransaction(transactionEntity);

        try {
            // 执行出账操作
            debit(fromWalletId, amount);
            // 执行入账操作
            credit(toWalletId, amount);
            // 更新交易状态为已执行
            transactionRepo.updateStatus(transactionId, Status.EXECUTED);
        } catch (NoSufficientBalanceException e) {
            // 如果余额不足，则关闭交易
            transactionRepo.updateStatus(transactionId, Status.CLOSED);
            throw e; // 重新抛出异常
        } catch (Exception e) {
            // 如果发生其他异常，则标记交易为失败
            transactionRepo.updateStatus(transactionId, Status.FAILED);
            throw e; // 重新抛出异常
        }
    }

    // 假设这里有一个 convert 方法用于转换实体对象到业务对象
    private VirtualWalletBo convert(VirtualWalletEntity walletEntity) {
        return new VirtualWalletBo(walletEntity.getId(), walletEntity.getCreateTime(), walletEntity.getBalance());
    }
}
