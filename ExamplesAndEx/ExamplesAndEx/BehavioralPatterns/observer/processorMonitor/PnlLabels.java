package observer.processorMonitor;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
class PnlLabels extends JPanel implements ProcessorObserver, Runnable
{
	private ProcessorInterest m_Model;
	private JLabel m_Labels[];
	float m_nMaxValue;
	private Color m_Colors[] = {Color.blue, Color.green, Color.red};

	PnlLabels(ProcessorInterest Model)
	{
		setBackground(Color.black);
		m_Model = Model;
		m_nMaxValue = m_Model.getMaxValue();
		m_Labels = new JLabel[m_Model.getSize()];
		setLayout(new GridLayout(m_Labels.length, 1, 10, 10));
		for (int i = 0 ; i < m_Labels.length ; ++i )
		{
			m_Labels[i] = new JLabel("Processor #" + i + ": 0%");
			//m_Labels[i].setOpaque(true);
			//m_Labels[i].setBackground(Color.white);
			add(m_Labels[i]);
		}
		m_Model.registerObserver(this);
	}

	private Color getColor(int nPrecentage)
	{
		return m_Colors[(int)(nPrecentage / (m_nMaxValue / m_Colors.length))];
	}

	public void dataChanged()
	{
		SwingUtilities.invokeLater(this);
	}


	public void run()
	{
		for (int i = 0 ; i < m_Labels.length ; ++i )
		{
			int nCurrentValue = m_Model.getValueAt(i);
			m_Labels[i].setText("Processor #" + i + ": " + nCurrentValue + "%");
			m_Labels[i].setForeground(getColor(nCurrentValue));
		}
	}
};