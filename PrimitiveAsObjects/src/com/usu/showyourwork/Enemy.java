package com.usu.showyourwork;

public class Enemy {
    private int health;
    AttackBehavior behavior;

    public Enemy(AttackBehavior behavior, int health) {
        this.behavior = behavior;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void attack() {
        behavior.performAttack();
    }
}
