package abstractFactory;
import java.awt.*;
abstract class PushButton extends Panel
{
	protected Component m_Button;
	PushButton(java.awt.Component button) 
	{
		setLayout(new java.awt.BorderLayout());
		m_Button = button;
		add(button);
	}
	public abstract void addActionListener(java.awt.event.ActionListener listener);
	public abstract void setText(String sText);
}