import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingManFrame extends JFrame implements ActionListener
{
	int direction = 0; 
	int direction1 = 0;
	private Man man;
	private Man dog;
	private ArrayList<Man> men = new ArrayList<Man>();
	public ArrayList<Ball> b = new ArrayList<Ball>();
	public WalkingManFrame()
	{
		setBounds(100, 100, 1200, 700);
		setLayout(null);
		man = new Man(0, 0, Color.RED);
		dog = new Man(0,0, Color.BLUE);
		men.add(man);
		men.add(dog);
		for (int i =0; i<men.size(); i++)
		{
			add(men.get(i));
		}
		setVisible(true);
		Timer timer = new Timer(10, this);
		timer.start();
		addKeyListener(new KeyListener()
				{
					public void keyPressed(KeyEvent e)
					{
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(-2);
							direction = 1;
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(-2);
							direction = 2;
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(2);
							direction = 3;
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(2);
							direction = 4;
						}
						if(e.getKeyCode() == e.VK_SPACE)
						{
							switch (direction) 
							{
							case 1:
								
								Ball bb = new Ball(man.getX(), man.getY(), 0,-5);
								b.add(bb);
								add(bb);
								break;
							case 2: 
							
								Ball bb1 = new Ball(man.getX(), man.getY(), -5,0);
								b.add(bb1);
								add(bb1);
								break;
							case 3:
						
								Ball bb2 = new Ball(man.getX(), man.getY(), 0,5);
								b.add(bb2);
								add(bb2);
								break;
							case 4: 
								
								Ball bb3 = new Ball(man.getX(), man.getY(), 5,0);
								b.add(bb3);
								add(bb3);
								break;
								
							
							}
						}
						
					}
					public void keyReleased(KeyEvent e)
					{
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(0);
							
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(0);
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(0);
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(0);
						}
					}
					public void keyTyped(KeyEvent e)
					{
					}
					
				});
	addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent r)
			{
				if(r.getKeyCode() == r.VK_UP)
				{
					dog.setDY(-2);
					direction1 = 1;
				}
				if(r.getKeyCode() == r.VK_LEFT)
				{
					dog.setDX(-2);
					direction1 = 2;
				}
				if(r.getKeyCode() == r.VK_DOWN)
				{
					dog.setDY(2);
					direction1 = 3;
				}
				if(r.getKeyCode() == r.VK_RIGHT)
				{
					dog.setDX(2);
					direction1 = 4;
				}
				if(r.getKeyCode() == r.VK_SLASH)
				{
					switch (direction1) 
					{
					case 1:
						
						Ball bb = new Ball(dog.getX(), dog.getY(), 0,-5);
						b.add(bb);
						add(bb);
						break;
					case 2: 
					
						Ball bb1 = new Ball(dog.getX(), dog.getY(), -5,0);
						b.add(bb1);
						add(bb1);
						break;
					case 3:
				
						Ball bb2 = new Ball(dog.getX(), dog.getY(), 0,5);
						b.add(bb2);
						add(bb2);
						break;
					case 4: 
						
						Ball bb3 = new Ball(dog.getX(), dog.getY(), 5,0);
						b.add(bb3);
						add(bb3);
						break;
						
					
					}
				}
				
			}
			public void keyReleased(KeyEvent r)
			{
				if(r.getKeyCode() == r.VK_UP)
				{
					dog.setDY(0);
					
				}
				if(r.getKeyCode() == r.VK_LEFT)
				{
					dog.setDX(0);
				}
				if(r.getKeyCode() == r.VK_DOWN)
				{
					dog.setDY(0);
				}
				if(r.getKeyCode() == r.VK_RIGHT)
				{
					dog.setDX(0);
				}
			}
			public void keyTyped(KeyEvent r)
			{
			}
			
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		for (int i = 0; i<men.size(); i++)
		{
			if (men.get(i).getX() + men.get(i).getDX() >= this.getWidth() || men.get(i).getX() + men.get(i).getDX() <= 0)
			{
				men.get(i).setDX(0);
			}
			if (men.get(i).getY() + men.get(i).getDY() >= this.getHeight() || men.get(i).getY() + men.get(i).getDY() <= 0)
			{
				
				men.get(i).setDY(0);
			}
			men.get(i).update();
		}
		for(int i = 0; i < b.size(); i++)
		{
			b.get(i).update();
			if(b.get(i).getX() > this.getWidth() || b.get(i).getX() < 0 || b.get(i).getY() < 0 || b.get(i).getY() > this.getHeight())
			{
				this.remove(b.get(i));
				b.remove(i);
			}
		}
		repaint();
	}
	public static void main(String[] args)
	{
		new WalkingManFrame();
		
	}
}