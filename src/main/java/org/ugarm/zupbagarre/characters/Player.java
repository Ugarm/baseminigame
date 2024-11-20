package org.ugarm.zupbagarre.characters;

import org.ugarm.zupbagarre.CharacterErrorHandler;

public class Player extends Character {
    private String classe;

    public Player(String name, int healthPoints, int level, double abilityPower, double attackDamage, String classe) throws CharacterErrorHandler {
        super(name, healthPoints, abilityPower + (level*1.35), attackDamage + (level*1.35));
        this.classe = classe;

        playerErrorHandler(name, healthPoints, level, classe);
    }

    @Override
    public String getClasse(){

        return this.classe;
    }

    @Override
    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void playerErrorHandler(String name, int healthPoints, int level, String playerClass) throws CharacterErrorHandler {
        if (name.length() <= 2){
            throw new CharacterErrorHandler("Your username must be at least 3 characters long.");
        }

        if (healthPoints <= 0){
            throw new CharacterErrorHandler("Your health points must be greater than zero.");
        }

        if (level <= 0){
            throw new CharacterErrorHandler("Your level must be greater than zero.");
        }

        if (!Classes.VALID_CLASSES.contains(playerClass)){
            throw new CharacterErrorHandler("Your player class is not a valid class.");
        }
    }
}
