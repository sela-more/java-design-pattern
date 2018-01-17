package command.graphicEditor;
import javax.swing.JPanel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListDataEvent;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

class Editor extends JPanel
{
	private CommandManager m_Manager;

	Editor(CommandManager Manager)
	{
		m_Manager = Manager;
		m_Manager.addListDataListener(new RepaintManager());
		addMouseListener(new CircleDrawer());
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		m_Manager.draw(g);
	}

	class CircleDrawer extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			m_Manager.doIt(new AddCircleCommand(e.getPoint(), 30));
			//m_Manager.addCircle(new Circle(e.getPoint(), 30));
		}
	};

	class RepaintManager implements ListDataListener
	{
		public void contentsChanged(ListDataEvent e) 
		{
			repaint();
		}
		public void intervalAdded(ListDataEvent e) 
		{
			repaint();
		}
		public void intervalRemoved(ListDataEvent e) 
		{
			repaint();
		}
	};
};