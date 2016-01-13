package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MyWindow extends JFrame implements KeyListener{
	
	int width = 500;
	static int height = 500;
	Hero girl;
	Hero guy;
	boolean itemPickedUp;
	BufferedImage landscape;
	
	public static void main(String[] args){
		new MyWindow();
	}
	
	public MyWindow(){
		//the following are JFrame methods
		girl = new Hero("Girl","/images/heros/hero.png",200,200,150,200);
		guy = new Hero("Guy","/images/heros/guy.png",50,300,100,150);
		itemPickedUp = false;
		landscape = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 =(Graphics2D)landscape.getGraphics();
		paintLandscape(g2);
		
		setVisible(true); 
		setSize(width,height);//units in px
		setLocation(200,150);//200px right, 150 px down (location of pop-up on window)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//static constant reference for special close operation
		addKeyListener(this);
	}
	
	private void paintLandscape(Graphics2D g2) {
		// TODO Auto-generated method stub
		int squareD = 20;
		int margin =2;
		int c=0;
		for(int x=0; x<width; x+=squareD+margin){
			for(int y=0;y<height;y+=squareD+margin){
				if(c>255)c=0;
				g2.setColor(new Color(0,150,c));
				c+=1;
				g2.fillRect(x, y, squareD,squareD);
			}
		}
	}

	public void paint(Graphics g){
		//Graphics is a crayon box
		//Graphics2d is like an art kit
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		//Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		
//		g2.setColor(Color.blue);
//		g2.drawOval(50, 110, 200, 100);
//		
//		//x,y,width,height,startDEG,lengthDEG
//		g2.drawArc(50, 300, 200, 100, 0, 90);
//		
//		//String
//		g2.drawString("String", 300, 300);
//		
//		//lines: startX, startY, endX, endY
//		g2.drawLine(0, 0, width, height);
		
//		int c=0;
//		int y=0;
//			for(int x=0;x<width;x+=10){
//				if(c>255)c=0;
//				g2.setColor(new Color(0,0,c));
//				g2.drawLine(x, y, width, height-y);	
//				c+=5;
//			}
		
		g2.drawImage(landscape, 0, 0, null);
		g2.drawImage(girl.getImage(), girl.getX(), girl.getY(), null);
		if(Math.abs(girl.getX()-guy.getX())+Math.abs(girl.getY()-guy.getY()) <50)itemPickedUp=true;
		if(!itemPickedUp)g2.drawImage(guy.getImage(), guy.getX(), guy.getY(), null);	
		//draw the bufferedImage on the canvas
		g.drawImage(image, 0, 0,null);
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			girl.moveUp();
		}
		else if(key == KeyEvent.VK_DOWN){
			girl.moveDown();
		}
		else if(key == KeyEvent.VK_RIGHT){
			girl.moveRight();
		}
		else if(key == KeyEvent.VK_LEFT){
			girl.moveLeft();
		}
		repaint();
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
