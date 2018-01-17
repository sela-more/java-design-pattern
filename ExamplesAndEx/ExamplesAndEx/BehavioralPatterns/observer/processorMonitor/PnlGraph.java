package observer.processorMonitor;
import javax.swing.*;
import java.awt.*;

class PnlGraph extends JPanel implements ProcessorObserver
{
	private Color m_Colors[] = {Color.blue, Color.green, Color.red};
	private ProcessorInterest m_Model;
	private float m_nMaxValue;
	PnlGraph(ProcessorInterest Model)
	{
		setBackground(Color.white);
		m_Model = Model;
		m_nMaxValue = m_Model.getMaxValue();
		Model.registerObserver(this);
	}

	private Color getColor(int nPrecentage)
	{
		return m_Colors[(int)(nPrecentage / (m_nMaxValue / m_Colors.length))];
	}


	public void paint(Graphics g)
	{
		super.paint(g);
		int nHeight = getHeight();
		int nWidth = getWidth();

		int nColWidth = (int)((nWidth * 1f) / (m_Model.getSize() * 2));
		int nColSeparator = (int)(nColWidth / 2f);
		
		int nTopPosition = 20;
		int nMaxHeight = nHeight - 40;
		int nXPosition = nColSeparator;
		Color OldColor = g.getColor();
		for (int i = 0 ; i < m_Model.getSize() ; ++i)
		{
			int nCurrentValue = m_Model.getValueAt(i);
			g.setColor(getColor(nCurrentValue));
			int nColHeightInPixel = (int)(nCurrentValue / m_nMaxValue * nMaxHeight);
			g.fillRect(nXPosition, nMaxHeight - nColHeightInPixel + 20, nColWidth, nColHeightInPixel);
			g.setColor(OldColor);
			g.drawRect(nXPosition, nMaxHeight - nColHeightInPixel + 20, nColWidth, nColHeightInPixel);
			g.drawString(m_Model.getValueAt(i) + "%", nXPosition, nHeight - 5);
			nXPosition += 2 * nColWidth;
		}
	}
	public void dataChanged()
	{
		repaint();
	}
};