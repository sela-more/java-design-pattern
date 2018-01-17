package prototype;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Catalogue extends AbstractListModel
{
	private ArrayList m_Prototypes = new ArrayList();

	Catalogue()
	{
		m_Prototypes.add(new Rectangle(20, 20, 60, 60));
		m_Prototypes.add(new Oval(20, 20, 60, 60));
	}
	public Object getElementAt(int nIndex)
	{
		return m_Prototypes.get(nIndex);
	}

	public IShape getShape(int nIndex)
	{
		return (AbstractShape)((AbstractShape)m_Prototypes.get(nIndex)).clone();
	}

	public void addShape(Picture newShape)
	{
		newShape.setNewSize(60, 60);
		newShape.move(20, 20);
		m_Prototypes.add(newShape);
		fireIntervalAdded(this, m_Prototypes.size() - 1, m_Prototypes.size() - 1);
	}
	
	public int getSize()
	{
		return m_Prototypes.size();
	}
}