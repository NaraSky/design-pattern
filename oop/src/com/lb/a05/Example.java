package com.lb.a05;

/**
 * 多态（Polymorphism）是面向对象编程中的核心概念之一，它指的是同一操作作用于不同的对象时，可以有不同的表现形式。
 * 具体来说，多态允许对象以不同的方式响应相同的消息或方法调用，具体表现为方法重载（Overloading）和方法重写（Overriding）。
 *
 * 多态的表现形式：
 *      方法重写（Override）： 子类重新定义父类的方法，以实现不同的行为。
 *      在 SortedDynamicArray 类中，add 方法被重写。尽管 DynamicArray 和 SortedDynamicArray 都有 add 方法，但它们的实现方式不同。DynamicArray 只是将元素追加到数组末尾，而 SortedDynamicArray 在添加元素时会保持数组的有序性。
 *
 *      方法重载（Overload）： 同一个方法名根据不同的参数类型或数量进行多次定义，从而支持不同的调用方式。
 *      这种情况在你提供的代码中并没有直接出现，但在很多场景下，重载也经常用于多态的实现。例如，add 方法可能会根据传入的参数类型不同，调用不同的实现。
 *
 * 多态的核心特性：
 *      编译时多态（静态多态）： 主要通过方法重载实现，不同的参数类型或数量会调用不同的方法版本。
 *      例如，可以有多个 add 方法，接受不同类型的参数（如 Integer、String 等）。
 *
 *      运行时多态（动态多态）： 通过方法重写实现，调用的实际方法由对象的实际类型决定，而不是由变量的类型决定。
 *      即便变量是 DynamicArray 类型，实际调用的是 SortedDynamicArray 的 add 方法，因为我们创建了一个 SortedDynamicArray 的实例。这种行为依赖于对象的实际类型，而不是引用的类型。
 *
 * 多态的优势：
 *      提高代码的灵活性和可扩展性： 通过多态，可以编写通用的代码，并根据不同的对象类型提供不同的行为。
 *      例如，Example 类中的 test 方法可以接受 DynamicArray 类型的参数，但是它能够正确地处理 SortedDynamicArray 对象，因为 SortedDynamicArray 重写了 add 方法来实现不同的行为。
 *
 *      代码复用和可维护性： 多态允许子类根据需要重新定义父类方法，继承父类的基本功能，并根据具体需求进行定制。
 *      这种特性使得我们能够在不修改父类代码的情况下，修改子类的行为，从而提高代码的可维护性。
 */
public class Example {
    public static void test(DynamicArray dynamicArray) {
        dynamicArray.add(5);
        dynamicArray.add(1);
        dynamicArray.add(3);
        // 打印数组内容
        for (int i = 0; i < dynamicArray.size(); ++i) {
            System.out.println(dynamicArray.get(i));
        }
    }

    public static void main(String args[]) {
        DynamicArray dynamicArray = new SortedDynamicArray(); // 使用 SortedDynamicArray
        test(dynamicArray); // 打印结果：1、3、5
    }
}