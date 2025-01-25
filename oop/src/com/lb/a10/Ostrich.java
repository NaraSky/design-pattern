package com.lb.a10;

// 鸵鸟类
public class Ostrich implements Tweetable, EggLayable {
    private TweetAbility tweetAbility = new TweetAbility();
    private EggLayAbility eggLayAbility = new EggLayAbility();

    @Override
    public void tweet() {
        tweetAbility.tweet();
    }

    @Override
    public void layEgg() {
        eggLayAbility.layEgg();
    }
}