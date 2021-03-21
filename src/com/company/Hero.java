package com.company;

public abstract class Hero extends GameEntity implements HavingSuperAbility{

    private EnumSuperAbility superAbility;

    public Hero(int health, int damage, String name,
                EnumSuperAbility superAbility) {
        super(health, damage, name);
        this.superAbility = superAbility;
    }

    public EnumSuperAbility getSuperAbility() {
        return superAbility;
    }

    public void setSuperAbility(EnumSuperAbility superAbility) {
        this.superAbility = superAbility;
    }

    public abstract void applySuperAbility(Boss boss, Hero[] heroes);
}

