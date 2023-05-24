/*package il.co.lird.FS133.Projects.SnakeGame;*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventListener extends JFrame implements KeyListener {

    private final ISnake snake;

    public EventListener(SnakeGame snakeGame){
        this.snake = snakeGame.getSnake();
    }
    void initialize(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(10, 10));
        pack();
        setLocationRelativeTo(null);
        addKeyListener(this);
        setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == KeyEvent.VK_UP && snake.getCurDirection() != Direction.DOWN) {
            snake.setCurMove(Direction.UP);
        } else if (keyCode == KeyEvent.VK_DOWN && snake.getCurDirection() != Direction.UP) {
            snake.setCurMove(Direction.DOWN);
        } else if (keyCode == KeyEvent.VK_LEFT && snake.getCurDirection() != Direction.RIGHT) {
            snake.setCurMove(Direction.LEFT);
        } else if (keyCode == KeyEvent.VK_RIGHT && snake.getCurDirection() != Direction.LEFT) {
            snake.setCurMove(Direction.RIGHT);
        }
        if (keyCode == KeyEvent.VK_ESCAPE){
          snake.setCurMove(Direction.STOP);
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
