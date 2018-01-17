
package doubleDispatchSolution;

public class Circle extends Shape {
	 public boolean intersects(Shape s1){
	 	return s1.letIntersect(this);
	 }
	 public boolean letIntersect(Shape s1){
	 	return s1.intersects(this);
	 }
	 public boolean intersects(Rectangle r1){
	 	System.out.println("In Circe intersects Rectangle");
	 	return true;
	 }
	 public boolean intersects(Circle c1){
	 	System.out.println("In Circe intersects Circe");
	 	return true;
	 }
	 



}
