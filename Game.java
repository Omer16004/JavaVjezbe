package aa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Game game = new Game();

		ArrayList<Player> neprijatelji = new ArrayList<>();

		ArrayList<String> eventlog = new ArrayList<>();

		neprijatelji.add(new Player("Neprijatelj1", 50, 50, 10, 10, 100));
		neprijatelji.add(new Player("Neprijatelj2", 70, 70, 10, 10, 100));
		neprijatelji.add(new Player("Neprijatelj3", 90, 90, 10, 10, 100));
		neprijatelji.add(new Player("Neprijatelj4", 110, 110, 10, 10, 100));
		neprijatelji.add(new Player("Neprijatelj5", 130, 130, 10, 10, 100));

	}

	Player player = new Player("Hero", 60, 60, 10, 10, 200);
	Enemy enemy = new Enemy("Goblin", 65, 65, 10, 10, 20);

	public static void checkCollision(Player player, Enemy enemy) {
		if (player.getPozitionX() < enemy.getX() + enemy.getWidth()
				&& player.getPozitionX() + player.getWidth() > enemy.getX()
				&& player.getPozitionY() < enemy.getY() + enemy.getHeight()
				&& player.getPozitionY() + player.getHeight() > enemy.getY()) {

			System.out.println(" Desio se sudar između " + player.getName() + " i " + enemy.getType());
		} else {
			System.out.println(" Nema sudara.");
		}

	}
}