package mysteryNumber;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private static Game instance;
	public static final int MAX_ATTEMPT = 10;
	public static int attemptCount;

	private Guesser guesser;

	public Game() {
		attemptCount = 0;
	}

	public static void start() {
		Number nb = new Number(new Random().nextInt((9999 - 1000) + 1) + 1000);

		instance = new Game();
		instance.guesser = new Player(nb);
	}
	
	public static void autoStart() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		Number nb = new Number(num);
		
		instance = new Game();
		instance.guesser = new Computer(nb);
	}

}
