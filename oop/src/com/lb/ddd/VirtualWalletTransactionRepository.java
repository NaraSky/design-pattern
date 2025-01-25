package com.lb.ddd;

public interface VirtualWalletTransactionRepository {
    Long saveTransaction(VirtualWalletTransactionEntity transactionEntity);
    void updateStatus(Long transactionId, Status status);
}
