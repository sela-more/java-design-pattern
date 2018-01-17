package factoryMethodGraphicEditorStarter;
import java.util.*;
import java.io.*;
//problem domain - hierarchy of products
abstract class Shape { //implements IShapeCreator {
	abstract void draw();
	
}
class Circle extends Shape {
	public void draw() {
		System.out.println("Drawing circle...");
	}
}
class Rectangle extends Shape {
	public void draw() {
		System.out.println("Drawing rectangle...");
	}
}
class Polygon extends Shape {
	public void draw() {
		System.out.println("Drawing polygon...");
	}
}
//solution domain - hierarchy of creators

//STUDENT

// solution domain - main factory - a singleton, delegating requests
// to the appropriate creator, using the registration mechanism to avoid 
// OCP problems
class ShapeFactory {
	private HashMap shapes = new HashMap();

	private static ShapeFactory m_factory = new ShapeFactory();
	private ShapeFactory() {}
	public static ShapeFactory getInstance() {
		return m_factory;
	}

	//Student? More methods?
	// Registration?

	public Shape create(String shapeType) {
		//student???
	}
}

class Main  {

	public static void main (String args[]) {
		
		// Registration??? Studnet???
		
		
		ShapeFactory factory = ShapeFactory.getInstance();
		
		
		

		ArrayList<Shape> allShapes = new ArrayList<Shape>();

		try {
			FileReader fr = new FileReader("picture.txt");
			BufferedReader br = new BufferedReader(fr);
			String shape;

			shape=br.readLine();
			while(shape!=null) {
					Shape temp = factory.create(shape);
					allShapes.add(temp);
					shape=br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Iterator<Shape> itr = allShapes.iterator();
		while (itr.hasNext()) {
			(itr.next()).draw();
		}
	}
}


