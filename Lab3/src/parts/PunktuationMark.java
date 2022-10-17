package parts;

import java.util.ArrayList;
import java.util.Arrays;

public class PunktuationMark extends Part {

    public static ArrayList<String> punktuation_marks = new ArrayList<String>(Arrays.asList(".", ",", ";", ":", "!", "?", "-"));
    public PunktuationMark(String value) {
        super(value);
    } 

    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        return getValue();
    }
}
