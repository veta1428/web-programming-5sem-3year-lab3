package comparators;

import java.util.Comparator;

import parts.Part;

public class PartComparer implements Comparator<Part> {
    
    private char character;

    public PartComparer(char character) {
        super();
        this.character = character;
    }

    
    /** 
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(Part o1, Part o2) {
        long countO1 = o1.getValue().chars().filter(ch -> ch == character).count();
        long countO2 = o2.getValue().chars().filter(ch -> ch == character).count();
        if (countO1 > countO2){
            return -1;
        } else if(countO1 < countO2){
            return 1;
        } else{
            return o1.getValue().toLowerCase().compareTo(o2.getValue().toLowerCase());
        }
    }
    
}
