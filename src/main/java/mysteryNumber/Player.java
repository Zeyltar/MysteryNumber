package mysteryNumber;

import java.util.Scanner;

public final class Player extends Guesser {

	public Player(Number nb) {
		guess(nb);
	}

	@Override
	protected void guess(Number n2) {
		Scanner sc = new Scanner(System.in);

		while (Game.attemptCount < Game.MAX_ATTEMPT) {
			Game.attemptCount++;
			System.out.print("Tentative n." + Game.attemptCount + ": ");

			int num = sc.nextInt();
			Number n1 = new Number(num);

			String clue = getClue(n1, n2);

			if (isFilledByChar(clue, '=')) {
				System.out.println("Bonne reponse");
				break;
			}
		}

		if (Game.attemptCount >= Game.MAX_ATTEMPT)
			System.out.println("Nombre de tentative maximale atteint");

		sc.close();
	}

}
