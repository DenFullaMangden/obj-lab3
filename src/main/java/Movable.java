import java.awt.geom.Point2D;

public interface Movable {

	void move();

	void turnLeft();

	void turnRight();

	void setPosition(Point2D.Double position);
}