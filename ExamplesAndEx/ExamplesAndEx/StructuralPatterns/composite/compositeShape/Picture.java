package composite.compositeShape;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
class Picture extends AbstractShape
{
	private AbstractShape m_Shapes[];
	private int m_nShapeCounter;
	private int m_nOriginalWidth;
	private int m_nOriginalHeight;
	private int m_nOrigilanHorzPos;
	private int m_nOrigilanVerPos;

	Picture(int nWidth, int nHeight, ArrayList shapes)
	{
		m_Shapes = new AbstractShape[shapes.size()];
		for (int i = 0 ; i < m_Shapes.length ; ++i )
			m_Shapes[i] = (AbstractShape)shapes.get(i);

		m_nOriginalWidth = nWidth;
		m_nOriginalHeight = nHeight;
	}

	public void mouseUp(MouseEvent e)
	{
		int nX = e.getX();
		int nY = e.getY();
		m_nHeight = Math.abs(nY - m_nTop);
		m_nWidth = Math.abs(nX - m_nLeft);
		m_nTop = Math.min(nY, m_nTop);
		m_nLeft = Math.min(nX, m_nLeft);
		move(m_nLeft, m_nTop);
		scale(((float)m_nWidth) / ((float)m_nOriginalWidth), 
			((float)m_nHeight) / ((float)m_nOriginalHeight));
		m_nOriginalWidth = m_nWidth;
		m_nOriginalHeight = m_nHeight;
	}

	public void move(int nXOffSet, int nYOffSet)
	{
		System.out.println("In Move --> x = " + nXOffSet + " y = " + nYOffSet);
		for (int i = 0 ; i < m_Shapes.length ; ++i )
		{
			m_Shapes[i].move(m_nOrigilanHorzPos * -1, m_nOrigilanVerPos * -1);
		}

		for (int i = 0 ; i < m_Shapes.length ; ++i )
		{
			m_Shapes[i].move(nXOffSet, nYOffSet);
		}
		
		m_nOrigilanHorzPos += nXOffSet;
		m_nOrigilanVerPos += nYOffSet;
	}

	public Object clone()
	{
		Picture pOther;

		pOther = (Picture)super.clone();
		pOther.m_Shapes = new AbstractShape[pOther.m_Shapes.length];
		for (int i = 0 ; i < pOther.m_Shapes.length ; ++i )
			pOther.m_Shapes[i] = (AbstractShape)m_Shapes[i].clone();

		return pOther;
	}

	public void setNewSize(int nWidth, int nHeight)
	{
		scale(((float)nWidth) / ((float)m_nOriginalWidth), 
			((float)nHeight) / ((float)m_nOriginalHeight));
		
		m_nOriginalWidth = nWidth;
		m_nOriginalHeight = nHeight;
	}

	public void scale(float fX, float fY)
	{
		for (int i = 0 ; i < m_Shapes.length ; ++i )
		{
			m_Shapes[i].scale(fX, fY);
		}
	}

	public void draw(Graphics g)
	{
		for (int i = 0 ; i < m_Shapes.length ; ++i )
		{
			m_Shapes[i].draw(g);
		}
	}
};