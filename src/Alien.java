import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {
	int speed;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Alien(int x2, int y2, int width2, int height2) {
		super(x2, y2, width2, height2);
		speed = 1;
		if (needImage) {
			loadImage("alien.png");
		}

	}

	@Override
	void update() {
		super.update();
		y += speed;
		super.update();
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.GREEN);
			g.fillRect(x, y, width, height);
		}

	}

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
