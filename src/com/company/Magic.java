package com.company;

import java.util.Random;

public class Magic extends Hero{

    public Magic(int health, int damage, String name,
                 EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int coeff = random.nextInt(2);
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getHealth() + coeff );
        } System.out.println(getName() + " point " + getDamage());


    }
}
