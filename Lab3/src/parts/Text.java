package parts;

import java.util.ArrayList;

import comparators.PartComparer;

public class Text extends Part {

    public Text(String value) {
        super(value);
    }
    
    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        String result = new String();
        for (Part subpart : getSubParts()) {
            result += subpart.toString() + '\n';
        }
        return result;
    }

    
    /** 
     * @return ArrayList<Part>
     */
    public ArrayList<Part> getAllWords(){
        ArrayList<Part> words = new ArrayList<>();
        for (Part subpart : getSubParts()) {
            if(subpart.getClass() == Paragraph.class)
            {
                for (Part sentence : subpart.getSubParts()) {
                    for (Part signOrWord : sentence.getSubParts()) {
                        if(signOrWord.getClass() == Word.class){
                            words.add(signOrWord);
                        }
                    }
                }
            }
        }
        return words;
    }
}
