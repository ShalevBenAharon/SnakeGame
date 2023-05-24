/*package il.co.lird.FS133.Projects.SnakeGame;*/

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) throws InterruptedException {
        SnakeGame snakeGame = new SnakeGame(20,30);
        EventListener controler = new EventListener(snakeGame);
        SwingUtilities.invokeLater(controler::initialize);
        snakeGame.startGame();

    }
}
