package composite.compositeShape;
import java.awt.Graphics;
class Rectangle extends AbstractShape
{
	Rectangle(int nLeft, int nTop, int nWidth, int nHeight)
	{
		super(nLeft, nTop, nWidth, nHeight);
	}

	public void draw(Graphics g)
	{
		System.out.println(m_nLeft + ", " + m_nTop+ ", " + + m_nWidth+ ", " + m_nHeight);
		g.drawRect(m_nLeft, m_nTop, m_nWidth, m_nHeight);
	}
};