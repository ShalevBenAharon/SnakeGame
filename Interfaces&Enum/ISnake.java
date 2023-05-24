
import java.awt.*;
import java.util.List;

public interface ISnake {

    Direction getCurDirection();

    void setCurMove(Direction move);

    void snakeMove(Direction direction);

    void snakeExptendBody(Point head);
    int getSnakeSize();

    List<Point> getSnakeBody();

}
