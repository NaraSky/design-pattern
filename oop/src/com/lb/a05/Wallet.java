package com.lb.a05;

import java.math.BigDecimal;

/**
 * 封装（Encapsulation）是面向对象编程（OOP）的四大基本特征之一。
 * 它指的是将对象的状态（属性）和行为（方法）封装在一起，并通过提供合适的接口来访问这些数据，而不是直接暴露给外部。这可以增强代码的安全性、可维护性和灵活性。
 *
 * 1. 数据隐藏：通过使用访问控制符（如 private）将类的内部状态（属性）隐藏起来，只能通过类内部的方法来操作。这防止了外部直接访问和修改这些数据，保证了数据的一致性和正确性。
 * 在 Wallet 类中，属性如 id、balance 都是 private，外部代码不能直接访问它们，而只能通过提供的 get 方法来获取数据，或者通过 increaseBalance 和 decreaseBalance 方法来修改余额。
 *
 * 2. 提供接口：通过公共方法（public）暴露必要的行为，让外部代码可以与对象交互。
 * 例如，在 Wallet 类中，我们通过 increaseBalance 和 decreaseBalance 方法来修改余额，而不是让外部直接操作 balance 属性。
 *
 * 3. 控制访问：封装的核心是控制对数据的访问。通过适当的验证，确保外部代码只能做合法的操作。
 * 例如，increaseBalance 和 decreaseBalance 方法中有逻辑检查，确保金额为正，且余额不足时不能减少余额。
 */
public class Wallet {
    private String id; // 钱包的唯一标识
    private long createTime; // 钱包创建时间
    private BigDecimal balance; // 当前余额
    private long balanceLastModifiedTime; // 余额最后修改时间
    // ...省略其他属性...

    // 构造函数，初始化钱包
    public Wallet() {
        this.id = IdGenerator.getInstance().generate(); // 使用生成器生成唯一ID
        this.createTime = System.currentTimeMillis(); // 获取当前时间戳作为创建时间
        this.balance = BigDecimal.ZERO; // 初始余额为0
        this.balanceLastModifiedTime = System.currentTimeMillis(); // 余额最后修改时间设置为当前时间
    }

    public String getId() {
        return this.id;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public long getBalanceLastModifiedTime() {
        return this.balanceLastModifiedTime;
    }

    public void increaseBalance(BigDecimal increasedAmount) {
        if (increasedAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("增加的金额不能为负数");
        }
        // 增加余额，使用 BigDecimal 的 add 方法，因为直接使用 "+" 不会修改原对象
        this.balance = this.balance.add(increasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    public void decreaseBalance(BigDecimal decreasedAmount) {
        if (decreasedAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("减少的金额不能为负数");
        }
        if (decreasedAmount.compareTo(this.balance) > 0) {
            throw new InsufficientAmountException("余额不足");
        }
        // 减少余额，使用 BigDecimal 的 subtract 方法
        this.balance = this.balance.subtract(decreasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
}
