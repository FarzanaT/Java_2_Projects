public class CharCalculator {
	private String str;

	public CharCalculator(String str) {
		if (str == null)
			str = "";
		this.str = str;
	}

	public int getNumberOf(char c) {
		int number = 0;
		for (int i = 0; i < str.length(); ++i) {
			if (c == str.charAt(i)) ++number;
		}
		return number;
	}

}