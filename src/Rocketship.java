import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	Rocketship(int x2, int y2, int width2, int height2) {
		super(x2, y2, width2, height2);
		speed = 15;
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
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

}
