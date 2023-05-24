
import javax.swing.*;

public class StartGame {


    public static void main(String[] args) throws InterruptedException {
        SnakeGame snakeGame = new SnakeGame(20,20);
        EventListener controler = new EventListener(snakeGame);
        SwingUtilities.invokeLater(controler::initialize);
        snakeGame.startGame();

    }
}
