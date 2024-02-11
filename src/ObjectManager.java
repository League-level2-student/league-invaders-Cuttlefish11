import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship Rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	int score = 0;

	public ObjectManager(Rocketship r) {
		Rocket = r;
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAlien() {
		Random random = new Random();
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (Alien alien : aliens) {
			alien.update();
			if (alien.y > LeagueInvaders.HEIGHT) {
				alien.isActive = false;
			}
		}
		for (Projectile projectile : projectiles) {
			projectile.update();
			if (projectile.y > LeagueInvaders.HEIGHT) {
				projectile.isActive = false;
			}
		}
		Rocket.update();
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		Rocket.draw(g);

		for (Alien alien : aliens) {
			alien.draw(g);
		}
		for (Projectile projectile : projectiles) {
			projectile.draw(g);
		}
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

	public int scoreGetter() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}

	void checkCollision() {
		for (Alien alien : aliens) {
			if (Rocket.collisionBox.intersects(alien.collisionBox)) {
				alien.isActive = false;
				Rocket.isActive = false;
			}
			for (Projectile projectile : projectiles) {
				if (projectile.collisionBox.intersects(alien.collisionBox)) {
					alien.isActive = false;
					score++;
				}
			}
		}
	}
}
