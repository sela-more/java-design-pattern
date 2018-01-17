package factoryMethodGraphicEditor.phaseTwo;
import java.util.*;
import java.io.*;


abstract class Shape {
	
	abstract void draw();
}
interface IShapeCreator{
	abstract Shape create(String initializationTokens);
}

class CircleCreator implements IShapeCreator {
	public Shape create(String initializationTokens) {
		return new Circle(initializationTokens);
	}
}

class RectangleCreator implements IShapeCreator {
	public Shape create(String initializationTokens) {
		return new Rectangle(initializationTokens);
	}
}
class PolygonCreator implements IShapeCreator {
	public Shape create(String initializationTokens) {
		return new Polygon(initializationTokens);
	}
}
class Circle extends Shape {
	private int m_x;
	private int m_y;
	private int m_radius;

	public Circle() {}
	public Circle(String initializationTokens) {
		String []args = initializationTokens.split(",");
		m_x = Integer.parseInt(args[0].trim());
		m_y = Integer.parseInt(args[1].trim());
		m_radius = Integer.parseInt(args[2].trim());
	}

	
	public void draw() {
		System.out.println("Drawing circle: x=" + m_x + ", y=" + m_y + ", radius=" + m_radius);
	}
}

class Rectangle extends Shape {
	int m_x;
	int m_y;
	int m_width;
	int m_height;

	public Rectangle() {}
	public Rectangle(String initializationTokens) {
		String []args = initializationTokens.split(",");
		m_x = Integer.parseInt(args[0].trim());
		m_y = Integer.parseInt(args[1].trim());
		m_width = Integer.parseInt(args[2].trim());
		m_height = Integer.parseInt(args[3].trim());
	}

	
	public void draw() {
		System.out.println("Drawing rectangle: x=" + m_x + ", y=" + m_y + ", width=" + m_width + ", height="+m_height);
	}
}

class Polygon extends Shape {
	public Polygon() {}
	public Polygon(String initializationTokens) {
		String []args = initializationTokens.split(",");
		for (int i=0; i<args.length; i++)
			System.out.println(args[i]);
	}

	
	public void draw() {
		System.out.println("Drawing polygon...");
	}
}



class ShapeFactory {
	private HashMap<String,IShapeCreator> shapes = new HashMap<String,IShapeCreator>();

	private static ShapeFactory m_factory = new ShapeFactory();
	private ShapeFactory() {}
	public static ShapeFactory getInstance() {
		return m_factory;
	}

	public void registerShape(String shapeType, IShapeCreator newShape) {
		shapes.put(shapeType, newShape);
	}

	public Shape create(String shapeType, String initializationTokens) {
		IShapeCreator temp = (IShapeCreator)shapes.get(shapeType);
		return temp.create(initializationTokens);
	}
}

class Main  {

	public static void main (String args[]) {
		ShapeFactory factory = ShapeFactory.getInstance();
		factory.registerShape("circle", new CircleCreator());
		factory.registerShape("rect", new RectangleCreator());
		factory.registerShape("polygon", new PolygonCreator());

		ArrayList<Shape> allShapes = new ArrayList<Shape>();

		try {
			FileReader fr = new FileReader("factoryMethodGraphicEditor\\phaseTwo\\picture.txt");
			BufferedReader br = new BufferedReader(fr);
			String shape;

			shape=br.readLine();
			while(shape!=null) {
					int idx = shape.lastIndexOf("-");
					String shapeType = shape.substring(0,idx);
					String tokenizers=shape.substring(idx+1);

					Shape tempShape = factory.create(shapeType, tokenizers);
					allShapes.add(tempShape);
					shape=br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Iterator<Shape> itr = allShapes.iterator();
		while (itr.hasNext()) {
			((Shape)itr.next()).draw();
		}
	}
}
