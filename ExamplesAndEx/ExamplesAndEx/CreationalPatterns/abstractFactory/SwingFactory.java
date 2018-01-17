package abstractFactory;
import javax.swing.JButton;

class SwingFactory implements AbstractGuiFactory
{
	public PushButton createButton(String sTitle)
	{
		return new SwingPushButton(sTitle);
	}

	public TextLine createTextLine(String sTitle)
	{
		return new SwingTextLine(sTitle);
	}
};