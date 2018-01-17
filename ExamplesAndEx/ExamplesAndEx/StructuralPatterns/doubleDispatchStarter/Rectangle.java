package doubleDispatchStarter;

public class Rectangle extends Shape {
	public boolean intersects(Shape s1){
		System.out.println("In Rectangle intersects Shape");
	 	return true;
	 }
	 
	 public boolean intersects(Rectangle r1){
	 	System.out.println("In Rectangle intersects Rectangle");
	 	return true;
	 }
	 public boolean intersects(Circle c1){
	 	System.out.println("In Rectangle intersects Circe");
	 	return true;
	 }

}
