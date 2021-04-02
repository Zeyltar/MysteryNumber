package mysteryNumber;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private static Game instance;
	public static final int MAX_ATTEMPT = 10;
	public static int attemptCount;
	public static Scanner sc;

	private Guesser guesser;

	public Game() {
	}

	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}

	public void start(int choice) {
		if (choice == 1) {
			System.out.println("Un nombre a ete genere, essayez de le deviner :)");
			Number nb = new Number(new Random().nextInt((9999 - 1000) + 1) + 1000);
			
			Game.attemptCount = 0;
			guesser = new Player();
			guesser.guess(nb);
		} else if (choice == 2) {
			System.out.println("Entrer un nombre a faire deviner a l'ordinateur :)");
			int num = Game.sc.nextInt();
			Number nb = new Number(num);
			
			Game.attemptCount = 0;
			guesser = new Computer();
			guesser.guess(nb);
		}

	}

	public void menu() {
		System.out.println("MENU");
		System.out.println("1: Player guess");
		System.out.println("2: Computer guess");
		System.out.println("3: Quit");

		Game.sc = new Scanner(System.in);
		int choice;
		while ((choice = Game.sc.nextInt()) > 4 && choice != 0) {
			choice = Game.sc.nextInt();
		}

		switch (choice) {
		case 1:
		case 2:
			start(choice);
			break;
		case 3:
			quit();
			break;

		default:
			break;
		}

	}

	public void quit() {
		Game.sc.close();
		System.exit(0);
	}

}
