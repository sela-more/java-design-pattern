package command.graphicEditor;
import java.awt.Point;

class AddCircleCommand extends AbstractCommand
{
	private Circle m_Circle;
	AddCircleCommand(Point pCenter, int nRadius)
	{
		m_Circle = new Circle(pCenter, nRadius);
	}

	public void doIt(IDocument document)
	{
		document.addCircle(m_Circle);
	}
	public void undoIt(IDocument document)
	{
		document.removeCircle(m_Circle);
	}

	public String toString()
	{
		return "Add Oval " + m_Circle;
	}
};