package abstractFactory;
import java.awt.*;
class AWTTextLine extends TextLine
{
	AWTTextLine(String sText) 
	{
		super(new TextField(sText));
	}

	public String getText()
	{
		return ((TextField)m_TextLine).getText();
	}

	public void setText(String sText)
	{
		((TextField)m_TextLine).setText(sText);
	}
}