import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Projectile(int x2, int y2, int width2, int height2) {
		super(x2, y2, width2, height2);
		speed = 10;
		if (needImage) {
		    loadImage ("bullet.png");
		}
	}
	@Override
	void update() {
		super.update();
		y -=speed;
        super.update();
	}
void draw(Graphics g) {
	if (gotImage) {
		g.drawImage(image, x, y, width, height, null);
	} else {
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, width, height);
	}}
void loadImage(String imageFile) {
    if (needImage) {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    gotImage = true;
        } catch (Exception e) {
            
        }
        needImage = false;
    }
}
}
