
package doubleDispatchStarter;

public class Circle extends Shape {
	 public boolean intersects(Shape s1){
	 	System.out.println("In Circe intersects Shape");
	 	return true;
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
