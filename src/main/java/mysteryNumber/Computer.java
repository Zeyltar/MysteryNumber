package mysteryNumber;

import java.util.Random;

public class Computer extends Guesser {

	private String[] clueList;
	private Number[] numberList;

	public Computer() {
		clueList = new String[Game.MAX_ATTEMPT];
		numberList = new Number[Game.MAX_ATTEMPT];
	}

	@Override
	public void guess(Number n2) {
		numberList[Game.attemptCount] = new Number(new Random().nextInt((9999 - 1000) + 1) + 1000);
		clueList[Game.attemptCount] = getClue(numberList[Game.attemptCount], n2);
		Game.attemptCount++;

		while (Game.attemptCount < Game.MAX_ATTEMPT) {
			int num = analyze();
			numberList[Game.attemptCount] = new Number(num);
			clueList[Game.attemptCount] = getClue(numberList[Game.attemptCount], n2);

			if (isFilledByChar(clueList[Game.attemptCount], '=')) {
				System.out.println("Bonne reponse");
				break;
			}
			Game.attemptCount++;
		}
		if (Game.attemptCount >= Game.MAX_ATTEMPT)
			System.out.println("Nombre de tentative maximale atteint");

	}

	// Vérifier pour chaque digits du Number précédent, la relation entre celui-ci
	// et l'indice,
	// puis choisira quelle action à effectuer.
	protected int analyze() {
		int num = 0;
		int length = numberList[Game.attemptCount - 1].value.length - 1;
		
		for (int i = length; i >= 0; i--) {
			if (clueList[Game.attemptCount - 1].charAt(i) == '=') {
				num += Math.pow(10, length - i) * numberList[Game.attemptCount - 1].value[i];
			} else if (clueList[Game.attemptCount - 1].charAt(i) == '>') {
				num += Math.pow(10, length - i) * randomDigit(0, numberList[Game.attemptCount - 1].value[i]);
			} else if (clueList[Game.attemptCount - 1].charAt(i) == '<') {
				num += Math.pow(10, length - i) * randomDigit(numberList[Game.attemptCount - 1].value[i], 9);
			}
		}
		return num;
	}

	protected int randomDigit(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}

}
