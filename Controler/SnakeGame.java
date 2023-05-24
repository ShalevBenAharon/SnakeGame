
public class SnakeGame {
    private IBoard board;
    private ISnake snake;

    private boolean isRunning;

    public SnakeGame(int boardHeight, int boardWidth) {
        snake = new Snake(boardHeight,boardWidth);
        board = new Board(boardHeight, boardWidth, snake);
    }

    public void displayBoard() {
        board.displayBoard();
    }

    public void startGame(){
        setRunning(true);

        while (isRunning) {

            switch (snake.getCurDirection()) {
                case UP:
                   snake.snakeMove(Direction.UP);
                    break;
                case DOWN:
                    snake.snakeMove(Direction.DOWN);
                    break;
                case LEFT:
                    snake.snakeMove(Direction.LEFT);
                    break;
                case RIGHT:
                    snake.snakeMove(Direction.RIGHT);
                    break;
                case STOP:
                    setRunning(false);
                    System.out.println("GAME OVER");
                    continue;

            }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                displayBoard();
        }

    }

    public ISnake getSnake() {
        return snake;
    }

    private void setRunning(boolean running) {
        isRunning = running;
    }
}
