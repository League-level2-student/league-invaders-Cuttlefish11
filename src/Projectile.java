
public class Projectile extends GameObject{

	Projectile(int x2, int y2, int width2, int height2) {
		super(x2, y2, width2, height2);
		speed = 10;
	}
	@Override
	void update() {
		super.update();
		y -=speed;
	}
private void draw() {


}
}
