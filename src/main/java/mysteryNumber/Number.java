package mysteryNumber;

public class Number {
	static final int LENGTH = 4;
	public int[] value;

	public Number(int number) {
		value = toList(number);
	}

	private int[] toList(int num) {
		int[] numList = new int[LENGTH];
		int count = countDigits(num);

		if (count > LENGTH)
			System.out.println("Too many numbers, ignoring " + (count - LENGTH) + " numbers.");

		for (int i = count - 1; i >= 0; i--) {
			if (i < LENGTH) {
				numList[i] = num % 10;
			}
			num /= 10;
		}

		if (count < LENGTH) {
			System.out.println("Not enough numbers, replacing " + (LENGTH - count) + " empty space(s) with 0.");

			for (int i = count; i < LENGTH; i++) {
				numList[i] = 0;
			}
		}
		return numList;
	}

	private int countDigits(int num) {
		int i = 0;

		while (num > 0) {
			num /= 10;
			i++;
		}
		return i;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < value.length; i++) {
			str.append(value[i] + "");
		}
		return str.toString();
	}
}
