import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent
{
	private int dX = 10;
	private int dY = 0;
	public Ball(int x, int y, int dx, int dy)
	{
		setLocation(x, y);
		setSize(5, 5);
		dX = dx;
		dY = dy;
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ball = new Ellipse2D.Double(0, 0, 4, 4);
		g2.fill(ball);
	}
	public void update()
	{
		setLocation(getX() + dX, getY()+ dY);
	}
	public void setDX(int x)
	{
		dX = x;
	}
	public void setDY(int y)
	{
		dY = y;
	}
	public int getDX()
	{
		return dX;
	}
}