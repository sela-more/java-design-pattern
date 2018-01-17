package abstractFactory;
import javax.swing.*;
class SwingTextLine extends TextLine
{
	SwingTextLine(String sText) 
	{
		super(new JTextField(sText));
	}

	public String getText()
	{
		return ((JTextField)m_TextLine).getText();
	}

	public void setText(String sText)
	{
		((JTextField)m_TextLine).setText(sText);
	}
}