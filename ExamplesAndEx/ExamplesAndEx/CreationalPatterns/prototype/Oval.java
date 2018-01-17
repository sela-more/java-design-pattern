package prototype;
import java.awt.Graphics;
class Oval extends AbstractShape
{
	Oval(int nLeft, int nTop, int nWidth, int nHeight)
	{
		super(nLeft, nTop, nWidth, nHeight);
	}

	public void draw(Graphics g)
	{
		System.out.println(m_nLeft + ", " + m_nTop+ ", " + + m_nWidth+ ", " + m_nHeight);
		g.drawOval(m_nLeft, m_nTop, m_nWidth, m_nHeight);
	}
};