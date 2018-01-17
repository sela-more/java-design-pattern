package factoryMethodGraphicEditor.phaseOne;
import java.util.*;
import java.io.*;
//problem domain - hierarchy of products
abstract class Shape { //implements IShapeCreator {
	abstract void draw();
	//public abstract Shape create();
}
class Circle extends Shape {
	public void draw() {
		System.out.println("Drawing circle...");
	}
//	public Shape create() {
//			return new Circle();
//		}
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
interface IShapeCreator{
	Shape create();
}
class CircleCreator implements IShapeCreator {
	public Shape create() {
		return new Circle();
	}
}

class RectangleCreator implements IShapeCreator {
	public Shape create() {
		return new Rectangle();
	}
}
class PolygonCreator implements IShapeCreator {
	public Shape create() {
		return new Polygon();
	}
}

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

	public void registerShape(String shapeType, IShapeCreator newShape) {
		shapes.put(shapeType, newShape);
	}

	public Shape create(String shapeType) {
		IShapeCreator temp = (IShapeCreator)shapes.get(shapeType);
		return temp.create();
	}
}

class Main  {

	public static void main (String args[]) {
		ShapeFactory factory = ShapeFactory.getInstance();
		// I can replace that by reading a table from a file,
		// containing "key" as a string, and a class name for 
		// the creator. In that case, I would:
		/*
		String creatorName="creatorName"; // read it from a file
		String creatorKey = "key"; // read it from a file
		try {
			Class c = Class.forName(creatorName);
			Object creatorObj = c.newInstance();
			factory.registerShape(creatorKey, (IShapeCreator)creatorObj);
			
		}
		catch (Exception e) {
		}
		*/
		
		factory.registerShape("circle", new CircleCreator());
		factory.registerShape("rect", new RectangleCreator());
		factory.registerShape("polygon", new PolygonCreator());

		ArrayList<Shape> allShapes = new ArrayList<Shape>();

		try {
			FileReader fr = new FileReader("factoryMethodGraphicEditor\\phaseOne\\picture.txt");
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


