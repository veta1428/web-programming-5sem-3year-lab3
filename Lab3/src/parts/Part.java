package parts;

import java.util.ArrayList;

public abstract class Part {
    private ArrayList<Part> subparts;
    private String value;

    public Part(String value){
        setValue(value);
    }

    
    /** 
     * @return String
     */
    public String getValue()
    {
        return value;
    }

    
    /** 
     * @param value
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    
    /** 
     * @return ArrayList<Part>
     */
    public ArrayList<Part> getSubParts()
    {
        return subparts;
    }

    
    /** 
     * @param subparts
     */
    public void setSubParts(ArrayList<Part> subparts)
    {
        this.subparts = subparts;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        String result = new String();
        for (Part subpart : subparts) {
            result += subpart.toString();
        }
        return result;
    }

    
    /** 
     * @return String
     */
    public String print() {
        return value.trim();
    }
}
