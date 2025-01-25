package com.lb.a10;

// 麻雀类
public class Sparrow implements Flyable, Tweetable, EggLayable {
    private FlyAbility flyAbility = new FlyAbility();
    private TweetAbility tweetAbility = new TweetAbility();
    private EggLayAbility eggLayAbility = new EggLayAbility();

    @Override
    public void fly() {
        flyAbility.fly();
    }

    @Override
    public void tweet() {
        tweetAbility.tweet();
    }

    @Override
    public void layEgg() {
        eggLayAbility.layEgg();
    }
}