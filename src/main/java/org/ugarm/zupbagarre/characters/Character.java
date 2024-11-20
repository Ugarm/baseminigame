package org.ugarm.zupbagarre.characters;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Character implements IPersonnage {
    protected String name;
    protected int healthPoints;
    protected int level;
    protected double abilityPower;
    protected double attackDamage;

    public static Logger logger = (Logger) LogManager.getLogger(Character.class);

    Character(String name, int healthPoints, double abilityPower, double attackDamage) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.abilityPower = abilityPower;
        this.attackDamage = attackDamage;


        // TODO : Rendre le niveau dynamique après l'implémentation d'une DB
        this.level = 1;

        logger.info("Character " + this.getName() + " built");
    }

    public String getName() {
        return this.name;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public int getLevel() {
        return this.level;
    }

    public double getAbilityPower() {
        return this.abilityPower;
    }

    public double getDamage() {
        return this.attackDamage;
    }

    public abstract String getClasse();

    public abstract void setClasse(String classe);
}
