package abstractFactory;
import java.awt.*;
abstract class TextLine extends Panel
{
	protected Component m_TextLine;
	TextLine(java.awt.Component textLine) 
	{
		setLayout(new java.awt.BorderLayout());
		m_TextLine = textLine;
		add(m_TextLine);
	}

	public abstract void setText(String sText);
	public abstract String getText();
}