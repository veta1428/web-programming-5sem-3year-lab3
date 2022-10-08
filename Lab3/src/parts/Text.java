package parts;

public class Text extends Part{

    public Text(String value) {
        super(value);
    }
    
    @Override
    public String toString(){
        String result = new String();
        for (Part subpart : getSubParts()) {
            result += subpart.toString() + '\n';
        }
        return result;
    }
}
