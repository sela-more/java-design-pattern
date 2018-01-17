package factoryMethod.goodButtons;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Application extends Frame
{
	private void initGuiComponents() {
		GUIButtonCreator.getCreator().createButton(this);
	}
	private Application()
	{
		super("Good Example");
		setSize(300, 100);
		setLayout(new FlowLayout());
		initGuiComponents();
		setVisible(true);
	}
	public static void main(String args[])
	{
		if (args.length != 0)
			System.setProperty("AppTechnology", args[0]);
		else //Assuming AWT
			System.setProperty("AppTechnology", "swing");
		new Application();
	}
}

abstract class GUIButtonCreator {
	private static GUIButtonCreator m_theFactoryInstance = null;
	public static synchronized GUIButtonCreator getCreator() {
		if (m_theFactoryInstance == null) {
		
			String buttonType=System.getProperty("AppTechnology");
			if (buttonType.equals("swing"))
				m_theFactoryInstance = new SWINGButtonCreator();
			else
				m_theFactoryInstance = new AWTButtonCreator();
		}
		return m_theFactoryInstance;
			
	}
	abstract void createButton(Frame source);		// Factory method
}

class AWTButtonCreator extends GUIButtonCreator{
	public void createButton(Frame source){
			Button btnIncrement = new Button("Click Here");
			final Button btnShowValue = new Button("Value = 0");
			btnIncrement.addActionListener(new ActionListener() {
				private int m_nValue=0;
				public void actionPerformed(ActionEvent e)
				{
					btnShowValue.setLabel("Value = " + (++m_nValue));
				}
			});
			source.add(btnIncrement);
			source.add(btnShowValue);
	}
}

class SWINGButtonCreator extends GUIButtonCreator{
	public void createButton(Frame source){
			JButton btnIncrement = new JButton("Click Here");
			final JButton btnShowValue = new JButton("Value = 0");
			btnIncrement.addActionListener(new ActionListener() {
				private int m_nValue=0;
				public void actionPerformed(ActionEvent e)
				{
					btnShowValue.setText("Value = " + (++m_nValue));
				}
			});
			source.add(btnIncrement);
			source.add(btnShowValue);
	}
}