package command.graphicEditor;
import java.awt.Graphics;
import java.awt.Point;
class Circle
{
	private Point	m_pCenter;
	private int		m_nRadius;
	public Circle(Point pCenter, int nRadius)
	{
		m_pCenter = pCenter;
		m_nRadius = nRadius;
	}
	public Point getPoint() {
		return m_pCenter;
	}
	public void draw(Graphics g)
	{
		g.drawOval(m_pCenter.x - m_nRadius, m_pCenter.y - m_nRadius, m_nRadius * 2, m_nRadius * 2);
	}
	public String toString()
	{
		return " (" + m_pCenter.x + ", " + m_pCenter.y + ")";
	}
};