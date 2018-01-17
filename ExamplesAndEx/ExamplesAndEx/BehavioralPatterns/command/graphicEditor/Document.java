package command.graphicEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Graphics;

class Document implements IDocument
{
	private ArrayList m_Circles = new ArrayList();

	public void addCircle(Circle c)
	{
		m_Circles.add(c);
	}

	public void removeCircle(Circle c)
	{
		m_Circles.remove(c);
	}

	public void draw(Graphics g)
	{
		Iterator iter = m_Circles.iterator();

		while(iter.hasNext())
		{
			((Circle)iter.next()).draw(g);
		}
	}
};