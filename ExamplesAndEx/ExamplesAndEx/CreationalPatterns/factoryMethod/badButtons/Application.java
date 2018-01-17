package factoryMethod.badButtons;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Application extends Frame
{
	private int m_nValue;

	private void initGuiComponents()
	{
		if (System.getProperty("AppTechnology").equalsIgnoreCase("swing"))
		{
			JButton btnIncrement = new JButton("Click Here");
			final JButton btnShowValue = new JButton("Value = 0");
			btnIncrement.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					btnShowValue.setText("Value = " + (++m_nValue));
				}
			});
			add(btnIncrement);
			add(btnShowValue);
		}
		else // Assuming AWT
		{
			Button btnIncrement = new Button("Click Here");
			final Button btnShowValue = new Button("Value = 0");
			btnIncrement.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					btnShowValue.setLabel("Value = " + (++m_nValue));
				}
			});
			add(btnIncrement);
			add(btnShowValue);
		}
	}

	private Application()
	{
		super("Bad Example");
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
			System.setProperty("AppTechnology", "awt");
		
		new Application();
	}
}