import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {
	Font titleFont;
	Font titlePage;
	Font endTitle;
	Font endPage;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Timer frameDraw;

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titlePage = new Font("Arial", Font.PLAIN, 20);
		endTitle = new Font("Arial", Font.PLAIN, 48);
		endPage = new Font("Arial", Font.PLAIN, 20);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} 
		else if (currentState == GAME) {
			drawGameState(g);
		} 
		else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("League Invaders", 70, 100);

		g.setFont(titlePage);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to start", 150, 400);
		g.drawString("Press SPACE for instructions", 115, 500);
	}

	void drawGameState(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Game Over", 70, 100);

		g.setFont(titlePage);
		g.setColor(Color.WHITE);
		g.drawString("You killed enemis", 150, 400);
		g.drawString("Press ENTER to restart", 125, 500);
	}

}
