package prototype;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

class Viewer extends JPanel 
{
	private ArrayList m_Document = new ArrayList();
	private IShape m_CurrentShape;
	private IShape m_CurrentType;

	Viewer()
	{
		addMouseListener(new MouseDrawer());
	}

	public void setShape(IShape shp)
	{
		m_CurrentType = shp;
		m_CurrentShape = (IShape)shp.clone();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Iterator iter = m_Document.iterator();
		while(iter.hasNext())
		{
			
			((IShape)iter.next()).draw(g);
		}
	}

	public Picture createPicture()
	{
		Picture retVal = new Picture(getWidth(), getHeight(), m_Document);
		m_Document = new ArrayList();
		repaint();
		return retVal;
	}

	class MouseDrawer extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			if (m_CurrentShape != null)
			{
				m_CurrentShape.mouseDown(e);
			}
		}

		public void mouseReleased(MouseEvent e)
		{
			if (m_CurrentShape == null)
				return;

			m_CurrentShape.mouseUp(e);
			m_Document.add(m_CurrentShape);
			m_CurrentShape = (IShape)m_CurrentType.clone();
			System.out.println("Repating ==> Size = " + m_Document.size());
			repaint();
		}
	};
};