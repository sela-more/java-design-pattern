package composite.compositeShape;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

interface IShape extends Cloneable
{
	public void draw(java.awt.Graphics g);
	public void mouseDown(MouseEvent e);
	public void mouseUp(MouseEvent e);
	public Object clone();
}