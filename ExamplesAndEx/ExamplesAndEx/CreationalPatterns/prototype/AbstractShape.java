package prototype;
import java.awt.event.*;
import java.awt.Graphics;
abstract class AbstractShape extends MouseAdapter implements IShape
{
	protected int m_nTop, m_nLeft, m_nHeight, m_nWidth;

	AbstractShape() {}
	AbstractShape(int nLeft, int nTop, int nWidth, int nHeight)
	{
		m_nLeft = nLeft;
		m_nTop = nTop;
		m_nWidth = nWidth;
		m_nHeight = nHeight;
	}
	protected void scale(float x, float y)
	{
		m_nWidth *= x;
		m_nHeight *= y;
		m_nLeft *= x;
		m_nTop *= y;
	}

	protected void move(int x, int y)
	{
		m_nLeft += x;
		m_nTop += y;
	}

	public void mouseDown(MouseEvent e)
	{
		m_nTop = e.getY();
		m_nLeft = e.getX();
	}

	public void mouseUp(MouseEvent e)
	{
		int nX = e.getX();
		int nY = e.getY();
		m_nHeight = Math.abs(nY - m_nTop);
		m_nWidth = Math.abs(nX - m_nLeft);
		m_nTop = Math.min(nY, m_nTop);
		m_nLeft = Math.min(nX, m_nLeft);
	}

	public Object clone()
	{
		try
		{
			return super.clone();	
		}
		catch (Exception e)
		{
			return null;
		}
		
	}

	public abstract void draw(Graphics g);
};