public class Main {
	public static void main(String[] args) {

		Paragraph paragraph = new Paragraph("Overall revenue for the weekend was down a steep 37 percent as Pacific Rim and four other new nationwide releases failed to wow, including a new movie from Steven Soderbergh. There was plenty of competition for the attention of moviegoers, between the NCAA basketball tournament and Saturday's marches across the country in protest of gun violence.");
		System.out.println(paragraph.findWord(paragraph.getSentencesArray(), "percent"));

	}
}
