public class App {

	public static void main(String[] args) {
		String paragraph = "This is my paragraph. It has multiple sentences. The sentences can be short or long.";
		try {
			Paragraph p = new Paragraph(paragraph);
			String s1 = p.getFirstSentence();
			Presenter adj = new Presenter(100, s1, '*', "sentence");
			System.out.println(adj.toString());

			String s2 = p.getLastSentence();
			Presenter adj1 = new Presenter(10, s2, '=', "sentence");
			System.out.println(adj1.toString());
		} catch (ParagraphEmptyException e) {
			System.err.println("Paragraph has no conent.");
		}
	}

}