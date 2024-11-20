package org.ugarm.zupbagarre;

import org.ugarm.zupbagarre.characters.Character;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Matchup <T> {
    private T[] matchup;
    private Map<String, Integer> score;

    @SuppressWarnings("unchecked")
    Matchup(Class<T> matchup) {
        this.matchup = (T[]) Array.newInstance(matchup, 2);
        this.score = new HashMap<>();
    }

    public T[] getMatchup() {

        return this.matchup;
    }

    public void add(T character) {

        for (int i = 0; i < this.matchup.length; i++) {
            if (this.matchup[i] == null) {
                this.matchup[i] = character;
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void setScore(Matchup<T> matchup, String winner) {
        Character player = (Character) matchup.getMatchup()[0];
        Character botPlayer = (Character) matchup.getMatchup()[1];

        if (Objects.equals(player.getName(), winner)) {
            this.score.put(winner, this.score.getOrDefault(winner, 0) + 1);
        } else if (Objects.equals(botPlayer.getName(), winner)) {
            this.score.put(winner, this.score.getOrDefault(winner, 0) + 1);
        } else {
            System.out.println("Winner name doesn't match any players in the matchup.");
        }
    }

    public Map<String, Integer> getScore() {

        return this.score;
    }
}
