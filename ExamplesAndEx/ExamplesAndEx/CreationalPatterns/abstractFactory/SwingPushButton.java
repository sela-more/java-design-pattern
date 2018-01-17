package abstractFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class SwingPushButton extends PushButton
{
	SwingPushButton(String sTitle)
	{
		super(new JButton(sTitle));
	}

	public void addActionListener(java.awt.event.ActionListener listener)
	{
		((JButton)m_Button).addActionListener(listener);
	}

	public void setText(String sText)
	{
		((JButton)m_Button).setText(sText);
	}


};