/*package il.co.lird.FS133.Projects.SnakeGame;*/

import java.awt.*;
import java.util.List;

public interface ISnake {

    Direction getCurDirection();

    void setCurMove(Direction move);

    void snakeMove(Direction direction);

    void snakeExtendBody(Point head);

    List<Point> getSnakeBody();

}
