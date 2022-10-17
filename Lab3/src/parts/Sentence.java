package parts;

public class Sentence extends Part{

    public Sentence(String value) {
        super(value);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        String result = new String();
        for (Part subpart : getSubParts()) {
            if(subpart.getClass() == Word.class){
                result += '\s' + subpart.toString();
            } else{
                result += subpart.toString();
            }
        }
        return result;
    }
}
