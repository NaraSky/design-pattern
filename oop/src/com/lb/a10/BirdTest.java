package com.lb.a10;

public class BirdTest {
    public static void main(String[] args) {
        Ostrich ostrich = new Ostrich();
        Sparrow sparrow = new Sparrow();

        System.out.println("Ostrich:");
        ostrich.tweet();
        ostrich.layEgg();

        System.out.println("\nSparrow:");
        sparrow.fly();
        sparrow.tweet();
        sparrow.layEgg();
    }
}