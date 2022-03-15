import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Rocketship(int x2, int y2, int width2, int height2) {
		super(x2, y2, width2, height2);
		speed = 15;
		if (needImage == true) {
		    loadImage ("rocket.png");
		}
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	   public void right() {
	        x+=speed;
			   if (x>451) {
				   x = 450;
			   }
	    }
	   public void left() {
	        x-=speed;
	        if (x<0) {
				   x = 0;
			   }

	    }
	   public void up() {
	        y-=speed;
	        if (y<0) {
				   y = 0;
			   }
	    }
	   public void down() {
	        y+=speed;
	        if (y>721) {
				   y = 720;
			   }
	    }
	   void loadImage(String imageFile) {
		    if (needImage == true) {
		        try {
		            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			    gotImage = true;
		        } catch (Exception e) {
		            
		        }
		        needImage = false;
		    }
		}
}
