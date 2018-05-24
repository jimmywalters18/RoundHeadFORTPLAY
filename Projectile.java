import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Projectile extends JComponent {
	private int damageValue, speed, dX, dY;
	private String weaponType;
	
	public Projectile(int x, int y, int dx, int dy, int d, String w) {
		setLocation(x,y);
		setSize(5,5);
		dX = dx;
		dY = dy;
		damageValue = d;
		weaponType = w;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ball = new Ellipse2D.Double(0, 0, 5, 5);
		g2.fill(ball);
	}
	
	public void setDX(int x) {
		dX = x;
	}
	
	public void setDY(int y) {
		dY = y;
	}
	
	public int getDX() {
		return dX;
	}
	
	public int getDY() {
		return dY;
	}
	
	public int getDamage() {
		return damageValue;
	}
	
	public String getWeaponType() {
		return weaponType;
	}
	
	public void update() {
		setLocation(getX() + dX, getY() + dY);
	}
}
