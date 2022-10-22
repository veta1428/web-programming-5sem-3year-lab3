package parts;

public class Word extends Part{

    public Word(String value) {
        super(value);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        return getValue();
    }

    
    /** 
     * @param last
     */
    public void transform(boolean last){
        String val = getValue();

        if(val == null){
            logger.error("Value is null");
            throw new IllegalArgumentException("Value cannot be null!");
        }

        if(val.length() == 0){
            return;
        }

        String newVal = new String();
        if(last){
            Character ch = Character.valueOf(val.charAt(val.length() - 1));
            newVal = val.replaceAll(ch.toString(), "");
        } else{
            Character ch = Character.valueOf(val.charAt(0));
            newVal = val.replaceAll(ch.toString(), "");
        }
        setValue(newVal);
    }
}
