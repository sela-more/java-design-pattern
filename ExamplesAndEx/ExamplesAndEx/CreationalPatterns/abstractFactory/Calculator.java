package abstractFactory;
import java.awt.event.*;
import java.awt.*;

class Calculator extends Panel
{
	private TextLine m_txtResult;
	private int m_nDisplayedNum;
	private int m_nValue;

	private Calculator()
	{
		initGuiComponents();
	}
	private void initGuiComponents()
	{
		setLayout(new BorderLayout()); 
		m_txtResult = GUIFactory.instance().createTextLine("0.");
		add(m_txtResult, BorderLayout.NORTH);
		Panel pnlNumbers = new Panel();
		pnlNumbers.setLayout(new GridLayout(4, 3));
		NumberListener numListener = new NumberListener();
		for (int i = 1 ; i < 10 ; ++i )
		{
			PushButton btnNumber = GUIFactory.instance().createButton("" + i);
			btnNumber.addActionListener(numListener);
			pnlNumbers.add(btnNumber);
		}

		PushButton btnClear = GUIFactory.instance().createButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				m_nDisplayedNum = 0;
				m_nValue = 0;
				updateView();
			}
		});
		pnlNumbers.add(btnClear);
		
		PushButton btnZero = GUIFactory.instance().createButton("0");
		btnZero.addActionListener(numListener);
		pnlNumbers.add(btnZero); 

		PushButton btnPlus = GUIFactory.instance().createButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				m_nValue += Integer.parseInt(m_txtResult.getText());
				m_nDisplayedNum = m_nValue;
				updateView();
				m_nDisplayedNum = 0;
			}
		});
		pnlNumbers.add(btnPlus);
		add(pnlNumbers);
	}

	private void updateView()
	{
		m_txtResult.setText("" + m_nDisplayedNum);
	}

	class NumberListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			m_nDisplayedNum = m_nDisplayedNum * 10 + Integer.parseInt(e.getActionCommand());
			updateView();
		}
	};

	public static void main(String args[])
	{
		if (args.length != 0)
			System.setProperty("AppTechnology", args[0]);
		else //Assuming AWT
			System.setProperty("AppTechnology", "awt");

		Frame f = new Frame("Calculator");
		f.setSize(150, 200);
		f.add(new Calculator());
		f.setVisible(true);
	}
};