
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Rectangle;
	import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

	public class Map extends JComponent
	{
		private int dy = 0, dx = 0;
		private Color coellear;  
		public Map(int x, int y, Color c)
		{
			setLocation(x, y);
			setSize(75, 275);
			coellear = c;
		}
		
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			Rectangle2D.Double head = new Rectangle.Double(0,0,500, 600);
			g2.setColor(coellear);
			g2.fill(head);
			
			
		}
		public void setDY(int y)
		{
			dy = y;
		}
		public void setDX(int x)
		{
			dx = x;
		}
		public int getDX()
		{
			return dx;
		}
		public int getDY()
		{
			return dy;
		}
		public void update()
		{
			setLocation(getX() + dx, getY() + dy);
		}
	}

