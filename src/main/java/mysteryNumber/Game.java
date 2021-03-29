package mysteryNumber;

import java.util.Random;

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

}
