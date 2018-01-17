
package doubleDispatchSolution;

abstract public class Shape {
	abstract public boolean intersects(Shape s1);
	abstract public boolean intersects(Rectangle r1);
	abstract public boolean intersects(Circle c1);
	
	abstract public boolean letIntersect(Shape s1);

}
