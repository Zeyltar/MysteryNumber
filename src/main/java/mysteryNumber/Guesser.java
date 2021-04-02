package mysteryNumber;

public abstract class Guesser {
	
	public void guess(Number n2) {
		
	}
	
	protected boolean isFilledByChar(String str, char c) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != c)
				return false;
		}
		return true;
	}

	protected String getClue(Number n1, Number n2) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < n1.value.length; i++) {
			str.append(checkDigit(n1.value[i], n2.value[i]));
		}

		System.out.println(str.toString());
		return str.toString();
	}

	protected String checkDigit(int a, int b) {
		if (a > b)
			return ">";
		else if (a < b)
			return "<";

		return "=";
	}
}
