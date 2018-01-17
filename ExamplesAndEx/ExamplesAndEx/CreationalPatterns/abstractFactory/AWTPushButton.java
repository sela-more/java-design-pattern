package abstractFactory;
import java.awt.*;
import java.awt.event.*;
class AWTPushButton extends PushButton
{
	AWTPushButton(String sTitle)
	{
		super(new Button(sTitle));
	}

	public void addActionListener(java.awt.event.ActionListener listener)
	{
		((Button)m_Button).addActionListener(listener);
	}

	public void setText(String sText)
	{
		((Button)m_Button).setLabel(sText);
	}
};