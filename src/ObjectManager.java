import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship Rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	public ObjectManager(Rocketship r) {
		Rocket = r;
		for (Alien alien : aliens) {
			alien.update();
			if (alien.y > LeagueInvaders.HEIGHT) {
				alien.isActive = false;
			}
		}
		for (Alien alien : aliens) {
			alien.draw();
		}
		for (Projectile projectile : projectiles) {
			projectile.draw();
		}
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAlien() {
		Random random = new Random();
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {

	}

	void draw(Graphics g) {
		Rocket.draw(g);
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien et = aliens.get(i);
			if (et.isActive == false) {
				aliens.remove(i);
		}
			for (int i1 = 0; i1 < projectiles.size(); i1++) {
				Projectile missile = projectiles.get(i1);
				if (missile.isActive == false) {
					projectiles.remove(i1);
		}
	}
}
}
}