package parsers;

import java.util.ArrayList;
import java.util.Arrays;

import parts.Part;
import parts.PunktuationMark;
import parts.Sentence;
import parts.Word;

public class SentenceParser extends AbstractParser {
    
    /** 
     * @param part
     * @return boolean
     */
    @Override
    public boolean parse(Part part) {
        getLogger(this).info(this.getClass() + " parse started...");
        if (part.getClass() == Sentence.class) {

            String source = part.getValue();

            ArrayList<String> tokens = new ArrayList<>(Arrays.asList(source.split("((?<=(;|:|[.]|[?]|!|\s-\s|,))|(?=(;|:|[.]|[?]|!|\s-\s|,)))")));  

            ArrayList<Part> parts = new ArrayList<>();
            for (String token : tokens) {
                parts.addAll(classify(token.trim()));
            }
            part.setSubParts(parts);
            getLogger(this).info(this.getClass() + " parse completed.");
            return true;
        } else {
            getLogger(this).info(this.getClass() + " parse delegated.");
            return super.parse(part);
        }
    }

    
    /** 
     * @param str
     * @return ArrayList<Part>
     */
    private ArrayList<Part> classify(String str)
    {
        ArrayList<Part> parts = new ArrayList<>();
        if(PunktuationMark.punktuation_marks.contains(str)){
            parts.add(new PunktuationMark(str));
        } else {
            ArrayList<String> textWords = new ArrayList<>(Arrays.asList(str.split("\s")));
            for (String strWord : textWords) {
                parts.add(new Word(strWord.trim()));
            }
        }
        return parts;
    }
}
