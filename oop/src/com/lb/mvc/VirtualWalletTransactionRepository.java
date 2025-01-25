package com.lb.mvc;

public interface VirtualWalletTransactionRepository {
    Long saveTransaction(VirtualWalletTransactionEntity transactionEntity);
    void updateStatus(Long transactionId, Status status);
}
