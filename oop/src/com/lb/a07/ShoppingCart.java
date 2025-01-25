package com.lb.a07;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int itemsCount;
    private double totalPrice;
    private List<ShoppingCartItem> items = new ArrayList<>();

    /**
     * itemsCount和totalPrice。虽然我们将它们定义成private私有属性，但是提供了public的getter、setter方法，这就跟将这两个属性定义为public公有属性，没有什么两样了
     * 通过访问权限控制，隐藏内部数据，外部仅能通过类提供的有限的接口访问、修改内部数据。所以，暴露不应该暴露的setter方法，明显违反了面向对象的封装特性
     */
    public int getItemsCount() {
        return this.itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    public List<ShoppingCartItem> getItems() {
        return this.items;
    }

    public void addItem(ShoppingCartItem item) {
        items.add(item);
        itemsCount++;
        totalPrice += item.getPrice();
    }
    // ...省略其他方法...
}
