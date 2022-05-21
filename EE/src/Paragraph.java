// Take a string that represents a paragraph. Paragraph will have a few sentences that are separated by a period ".".

import java.util.Arrays;

public class Paragraph {

	private String[] sentences;
	//
   // Fix compilation errors
   // throw an exception when a pargraph is empty, or null, sintce
   // we cannot do much in this case
   //
	public Paragraph(String paragraph) throws ParagraphEmptyException {
      // your code goes here
		if (paragraph == null || paragraph == "") {
		throw new ParagraphEmptyException(paragraph);  //change in para spelling 

	}
	}

   // Split paragraph on "." periods. Strip leading/trailing white space
  // from each sentence. Return a copy of the sentences.
  // Hint: read up on the split method from the String class. Make sure
  // to note that periods may need to be escaped for split to work correctly.
	public String[] extractSentences(String paragraph) {
      // your code goes here
		String[] str = paragraph.split("\\.");
		return str;
		
		//stub
	}

   // return the first sentence in the paragraph
	public String getFirstSentence() throws ParagraphEmptyException {
		// your code goes here
		if(sentences == null || sentences[0] == "") {
			throw new ParagraphEmptyException("null");
		}
		return sentences[0];  //returning the first sentence from the array
	}

   // return the last sentence in the paragraph
	public String getLastSentence() {
      // your code goes here
		return sentences[sentences.length-1];
	}
}
