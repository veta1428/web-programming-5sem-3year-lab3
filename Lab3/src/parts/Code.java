package parts;

public class Code extends Part {

    public static String CodeSign = "@code@";
    public Code(String value) {
        super(value);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        return CodeSign + getValue() + CodeSign;
    }
}
