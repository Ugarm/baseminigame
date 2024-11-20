package org.ugarm.zupbagarre;

import org.ugarm.zupbagarre.characters.BotPlayer;
import org.ugarm.zupbagarre.characters.Character;
import org.ugarm.zupbagarre.characters.Classes;
import org.ugarm.zupbagarre.characters.Player;

import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    double playerOneHealth, playerTwoHealth;
    double playerOneAbilityPower, playerTwoAbilityPower;
    double playerOneDamage, playerTwoDamage;

    public Logger Log = LogManager.getLogger(Game.class);

    public void game(){
        // INDEX 0 IS A PLAYER, INDEX 1 IS THE BOT
        // TODO : Uuuuuh, make this less cheesy I suppose
        Matchup<Character> matchup = createMatchup();

        setPlayersStats(matchup.getMatchup()[0], matchup.getMatchup()[1]);

        // Returns 0 if player one (index 0 in matchup) is defeated.
        // Returns 1 if player two (index 1 in matchup) is defeated.
        fight(matchup.getMatchup()[0].getName(), matchup.getMatchup()[1].getName());
    }

    private Matchup<Character> createMatchup(){
        Matchup<Character> matchup = new Matchup<>(Character.class);

        try {
            Character player = new Player("GIGA BANGALAX", 100, 50, 100, 13, Classes.INBRED);
            System.out.println("CREATED PLAYER\n" + player.getName() + ", " + player.getClasse() + " level " + player.getLevel() + "\nHP : " + player.getHealthPoints() + "\nAbility power : " + player.getAbilityPower() + "\nAttack damage : " + player.getDamage() + "\n");
            matchup.add(player);
            System.out.println("ADDED " + player.getName() + " TO THE MATCHUP!\n\n");
        } catch (CharacterErrorHandler e) {
            System.out.println(e.getMessage());
        }

        try {
            Character bot = new BotPlayer("Bot", 100, 1, 100, 15,  Classes.CHAV);
            System.out.println("CREATED BOT\n" + bot.getName() + ", " + bot.getClasse() + " level " + bot.getLevel() + "\nHP : " + bot.getHealthPoints() + "\nAbility power : " + bot.getAbilityPower() + "\nAttack damage : " + bot.getDamage() + "\n");
            matchup.add(bot);
            System.out.println("ADDED " + bot.getName() + " TO THE MATCHUP!\n\n");
        } catch (CharacterErrorHandler e) {
            System.out.println(e.getMessage());
        }
        Log.debug("Created matchup successfully.");
        return matchup;
    }

    private void fight(String playerOne, String playerTwo) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (playerOneHealth > 0 && playerTwoHealth > 0) {
            System.out.print(playerOne + " ! what's your next move bwai ? (atk || def)\n" + "you have " + playerOneHealth + " HP left. \n");
            String answer = scanner.nextLine();

            switch (answer) {
                case "atk":
                    playerTwoHealth = Math.max(0, playerTwoHealth - playerOneDamage);
                    System.out.println(playerOne + " attacked " + playerTwo + " and caused " + playerOneDamage + " damage!");
                    break;
                case "def":
                    playerOneHealth = playerOneHealth + playerOneDamage/3;
                    System.out.println(playerOne + " defends and recovers " + playerOneDamage / 3 + " health!");
                    break;
                default:
                    System.out.println("Invalid move, " + playerOne + " did nothing this turn.");
            }

            if (playerTwoHealth <= 0) {
                System.out.println(playerTwo + " has been defeated!");
                Log.debug("Game ended normally.");
                scanner.close();
                return; // minigame.characters.Player one wins
            }

            System.out.println(playerTwo + " got " + playerTwoHealth + "health points.");
            int randomNum = random.nextInt(2) + 1;

            switch (randomNum) {
                case 1:
                    playerOneHealth = Math.max(0, playerOneHealth - playerTwoAbilityPower);
                    System.out.println(playerTwo + " inflicted " + playerTwoAbilityPower + " power to " + playerOne + " " + playerOneHealth + " left");
                    break;
                case 2:
                    playerTwoHealth = playerTwoHealth + playerTwoAbilityPower/3;
                    System.out.println(playerTwo + " drank Mountain Dew and recovered " + playerTwoAbilityPower/3);
                    break;
                default:
                    System.out.println("You brain farted and did nothing off your turn, " + playerTwo);
            }

            if (playerOneHealth <= 0) {
                System.out.println(playerOne + " has been defeated!");
                Log.debug("Game ended normally.");
                scanner.close();
                return; // Bot wins
            }

        }
    }

    private void setPlayersStats(Character playerOne, Character playerTwo) {
        this.playerOneDamage = playerOne.getDamage();
        this.playerTwoDamage = playerTwo.getDamage();
        this.playerOneHealth = playerOne.getHealthPoints();
        this.playerTwoHealth = playerTwo.getHealthPoints();
        this.playerOneAbilityPower = playerOne.getAbilityPower();
        this.playerTwoAbilityPower = playerTwo.getAbilityPower();

        Log.debug("Player stats set successfully.");
    }

}
