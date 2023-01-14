public class Paragraph {

	/**
	 * A paragraph is a list of sentences
	 */
	private String[] sentences;

	// implementation shown solely for the purpose of demonstrating the efficiency of the program
	public Paragraph(String paragraph) {
		getSentences(paragraph);
	}

	/**
	 * @param paragraph A multi-sentence string.
	 *                  Precondition: Each sentence has words separated by one space
	 *                  and all sentences separated by a period.
	 * @return an Array of sentences obtained from the paragraph parameter.
	 */
	public String[] getSentences(String paragraph) {
		// answer to part (a)
		sentences = paragraph.split("\\.");
		return sentences;
	}

	// getter of the field variable
	public String[] getSentencesArray() {
		return sentences;
	}

	/**
	 * @param sentences an Array of sentences.
	 *                  Precondition: parameter contains at least one string.
	 * @param target    a word that can be found in any of the sentences in the array
	 *                  obtained from the parameter
	 * @return the location of the sentence containing the word and its index in the
	 * specific sentence. Return type will be a String: format "0,1" with 0 being the
	 * location of the sentence in the sentence parameter array and 1 being the
	 * location of the word in the sentence. If the word is not found,
	 * return "-1, -1"
	 */
	public String findWord(String[] sentences, String target) {
		// answer to part (b)
		String[] words;
		for (int i = 0; i < sentences.length; i++) {
			words = sentences[i].split(" ");
			for (int j = 0; j < words.length; j++) {
				if (sentences[i].contains(target) && target.equals(words[j])) {
					return "" + Integer.toString(i) + "," + Integer.toString(j);
				}

			}
		}
		return "-1, -1";
	}
}

