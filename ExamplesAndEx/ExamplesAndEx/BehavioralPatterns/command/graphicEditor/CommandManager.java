package command.graphicEditor;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import java.awt.Graphics;

class CommandManager extends AbstractListModel implements IDocument
{
	public void addCircle(Circle c)
	{
		AbstractCommand cmd = new AddCircleCommand(c.getPoint(), 30);
		doIt(cmd);
		m_Commands.add(cmd);
		fireIntervalAdded(this, m_Commands.size() - 1, m_Commands.size() -1);
	}
	private ArrayList m_Commands = new ArrayList();
	private Document m_Document = new Document();
	public void removeCircle(Circle c) {
	}

	public void doIt(AbstractCommand command)
	{
		command.doIt(m_Document);
		m_Commands.add(command);
		fireIntervalAdded(this, m_Commands.size() - 1, m_Commands.size() -1);
	}

	public void undoIt(int nIndex)
	{
		if (nIndex<1) {
			System.out.println("Select a command");
			return;
		}
		AbstractCommand toRemove = (AbstractCommand)m_Commands.remove(nIndex);
		toRemove.undoIt(m_Document);
		fireIntervalRemoved(this, nIndex, nIndex);
	}

	public Object getElementAt(int nIndex)
	{
		return m_Commands.get(nIndex);
	}

	public int getSize()
	{
		return m_Commands.size();
	}

	public void draw(Graphics g)
	{
		m_Document.draw(g);
	}

};