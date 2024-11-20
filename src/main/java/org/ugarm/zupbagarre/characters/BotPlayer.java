package org.ugarm.zupbagarre.characters;

import org.ugarm.zupbagarre.CharacterErrorHandler;

public class BotPlayer extends Character {
    private String classe;

    public BotPlayer(String name, int healthPoints, int level, double abilityPower, double attackDamage, String classe) throws CharacterErrorHandler {
        super(name, healthPoints, abilityPower + (level*1.35), attackDamage + (level*1.35));
        this.classe = classe;

        botErrorHandler(name, healthPoints, level, classe);
    }

    @Override
    public String getClasse() {
        return this.classe;
    }

    @Override
    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void botErrorHandler(String name, int healthPoints, int level, String playerClass) throws CharacterErrorHandler {
        if (name.length() <= 2){
            throw new CharacterErrorHandler("Bot has an invalid name. Must be at least 3 characters long.");
        }

        if (healthPoints <= 0){
            throw new CharacterErrorHandler("Bot health points must be greater than zero.");
        }

        if (level <= 0){
            throw new CharacterErrorHandler("Bot level must be greater than zero.");
        }

        if (!Classes.VALID_CLASSES.contains(playerClass)){
            throw new CharacterErrorHandler("Bot class is not a valid class.");
        }
    }
}
