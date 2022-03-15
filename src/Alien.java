
public class Alien extends GameObject{
int speed;
	Alien(int x2, int y2, int width2, int height2) {
		super(x2, y2, width2, height2);
		speed = 1;
	}
	@Override
	void update() {
		super.update();
		y +=speed;
	}
void draw() {


}
}
