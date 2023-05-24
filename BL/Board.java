
import java.awt.*;
import java.util.List;
import java.util.Random;

public class Board implements IBoard {

    private static int BOARD_HEIGHT;
    private static int BOARD_WIDTH;
    private static final char BOARD_CELL = ' ';
    private static final char BORDER_CELL = '#';
    private static final char FOOD_CELL = '$';
    private static final char SNAKE_BODY = 'O';
    private static int foodX;
    private static int foodY;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    ISnake snake;
    List snakeBody;

    public Board(int height, int width, ISnake snake) {
        BOARD_HEIGHT = height;
        BOARD_WIDTH = width;
        this.snake = snake;
        snakeBody = snake.getSnakeBody();
        rndFoodPosition();
    }
    @Override
    public void displayBoard() {
        for (int y = 0; y < BOARD_HEIGHT; ++y) {
            for (int x = 0; x < BOARD_WIDTH; ++x) {
                Point cordinats = new Point(x, y);
                Point head = (Point) snakeBody.get(0);

                if (!isValid() || !isCollition(head, snakeBody)) {
                    if(snake.getCurDirection()!= Direction.STOP) {
                        snake.snakeMove(Direction.STOP);
                    }
                }
                if (snakeBody.contains(cordinats)) {
                        System.out.print(ANSI_GREEN + SNAKE_BODY + ANSI_RESET);
                } else if (y == 0 || y == BOARD_HEIGHT - 1) {//Top-Bottom
                    System.out.print(BORDER_CELL);
                } else if (y > 0 && y < BOARD_HEIGHT) { // Sides
                    if (y == foodY && x == foodX) {
                        System.out.print(ANSI_RED + FOOD_CELL + ANSI_RESET);
                    } else if (x == 0 || x == BOARD_WIDTH - 1) {
                        System.out.print(BORDER_CELL);
                    } else {
                        System.out.print(BOARD_CELL);
                    }
                }
                if (head.x == foodX && head.y == foodY) {
                    snake.snakeExptendBody(head);
                    rndFoodPosition();
                }

            }
            System.out.println("");
        }

        for (int i = 0; i < 14; ++i) { //FOR SPACE IN THE CONSOLE
            System.out.println("");
        }
    }

    @Override
    public void rndFoodPosition() {
        Random rnd = new Random();
        foodX = rnd.nextInt(BOARD_WIDTH - 2) + 1;
        foodY = rnd.nextInt(BOARD_HEIGHT - 2) + 1;
    }

    public boolean isValid() {
        Point curHead = (Point) snakeBody.get(0);
        if (curHead.x <= 0 || curHead.x >= BOARD_WIDTH - 1 || curHead.y <= 0 || curHead.y >= BOARD_HEIGHT - 1){
            return (false);
        }
        return (true);
    }
    public boolean isCollition(Point head,List snakeBody ){

        for(int i = 1; i <snakeBody.size(); ++i){
            if(head.equals(snakeBody.get(i))){
                return false;
            }
        }
        return true;
    }
}
