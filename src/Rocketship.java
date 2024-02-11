import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;

	Rocketship(int x2, int y2, int width2, int height2) {
		super(x2, y2, width2, height2);
		speed = 15;
		if (needImage == true) {
			loadImage("rocket.png");
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

	@Override
	void update() {
		// TODO Auto-generated method stub
		super.update();
		if (up) {
			y -= speed;
			if (y < 0) {
				y = 0;
			}
		}
		if (down) {
			y += speed;
			if (y > 721) {
				y = 720;
			}
		}
		if (right) {
			x += speed;
			if (x > 451) {
				x = 450;
			}
		}
		if (left) {
			x -= speed;
			if (x < 0) {
				x = 0;
			}
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

	public Projectile getProjectile() {
		return new Projectile(x + width / 2, y, 10, 10);
	}
}
