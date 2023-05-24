/*package il.co.lird.FS133.Projects.SnakeGame;*/


import java.awt.*;
import java.util.ArrayList;

public class Snake implements ISnake {
    private int snakeX;
    private int snakeY;
    public Point snakeHead;

    private ArrayList<Point> snakeBody = new ArrayList<>();

    private static int snakeSize = 1;
    private static Direction curDirection = Direction.RIGHT;

    public Snake(int boardHeight, int boardWidth){
        snakeX = boardWidth / 2;
        snakeY = boardHeight / 2;
        snakeHead = new Point(snakeX,snakeY);
        snakeBody.add(snakeHead);
    }
    public Direction getCurDirection() {
        return curDirection;
    }
    public void setCurMove(Direction move){
        curDirection = move;
    }

    public void snakeMove(Direction direction){
        switch (direction){
            case UP:
                IncrementSnakeY();
                break;
            case DOWN:
                DecrementSnakeY();
                break;
            case LEFT:
                DecrementSnakeX();
                break;
            case RIGHT:
                IncrementSnakeX();
                break;
            case STOP:
                curDirection = Direction.STOP;
                break;
        }
    }
    private void IncrementSnakeX() {
        setTheSnakeBody();
        Point head = snakeBody.get(0);
        head.setLocation(head.x + 1, head.y);
    }

    private void DecrementSnakeX() {

        setTheSnakeBody();
        Point head = snakeBody.get(0);
        head.setLocation(head.x - 1, head.y);
    }
    private void IncrementSnakeY() {
        setTheSnakeBody();
        Point head = snakeBody.get(0);
        head.setLocation(head.x, head.y - 1);
    }
    private void DecrementSnakeY() {

        setTheSnakeBody();
        Point head = snakeBody.get(0);
        head.setLocation(head.x, head.y + 1);
    }

    private void setTheSnakeBody() {
        for (int i = snakeSize - 1; i > 0; --i) {
            Point current = snakeBody.get(i);
            Point previous = snakeBody.get(i - 1);
            current.setLocation(previous);
        }
    }

    public void snakeExtendBody(Point head) {

        Point newHead = null;
        switch (curDirection) {
            case UP:
                newHead = new Point(head.x, head.y - 1);
                break;
            case DOWN:
                newHead = new Point(head.x, head.y + 1);
                break;
            case RIGHT:
                newHead = new Point(head.x + 1, head.y);
                break;
            case LEFT:
                newHead = new Point(head.x - 1, head.y);
                break;
        }
        setSnakeSize();
        snakeBody.add(0,newHead);
    }
    public ArrayList<Point> getSnakeBody() {
        return snakeBody;
    }
    public void setSnakeSize() {
        ++snakeSize;
    }

}
