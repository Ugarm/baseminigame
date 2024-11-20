package org.ugarm.zupbagarre;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("looooool");
        Game game = new Game();
        game.game();
    }
}
