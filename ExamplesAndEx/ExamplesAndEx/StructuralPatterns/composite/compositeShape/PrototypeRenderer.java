package composite.compositeShape;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PrototypeRenderer extends JButton implements ListCellRenderer
{
	private IShape m_Shape;
	private Color m_DefaultColor;
	private boolean m_bSelected;
	PrototypeRenderer()
	{
		m_DefaultColor = getBackground();
		setOpaque(true);
		setPreferredSize(new Dimension(100, 100));
	}
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)  
	{
		m_Shape = (IShape)list.getModel().getElementAt(index);
		m_bSelected = cellHasFocus;
		return this;
	}
	public void paint(Graphics g)
	{

		if (m_bSelected)
			setBackground(Color.red);
		else
			setBackground(m_DefaultColor);
		super.paint(g);
		m_Shape.draw(g);
	}
};