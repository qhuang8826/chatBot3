package graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Hero {
	
	BufferedImage sprite;
	String name;
	int x;
	int y;
	
	public Hero(String name, String imageLocation, int locationX, int locationY, int wid, int hei){
		this.name =name;
		int width = wid;
		int height = hei;
		y=locationY;
		x=locationX;
		sprite = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imageLocation);
		//"/images/heros/megaman.jpg"
		try {
			BufferedImage original =ImageIO.read(url);
			//draw the image file into a scaled version on the sprite canvas
			Graphics2D g =(Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			
			//what to draw, where to start(x,y), width of canvas (relative to start), 
			//height of canvas (relative to start), where to start from original(x,y)
			//width of original, height, null
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public BufferedImage getImage(){
		return sprite;
	}
	
	public String getName(){
		return name;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public void moveUp() {
		// TODO Auto-generated method stub\
		if(y-5>-1){
			y-=5;			
		}
		else{
			y-= MyWindow.height-y;
		}
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		y+=5;
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		x+=5;
	}

	public void moveLeft() {
		// TODO Auto-generated method stub
		x-=5;
	}
}
