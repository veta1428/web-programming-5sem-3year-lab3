package parts;

import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Part {
    private ArrayList<Part> subparts;
    private String value;
    protected Logger logger;

    public Part(String value){
        logger = LogManager.getLogger();
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
        if(value == null){
            logger.warn("You are setting Part object value to null.");
        }
        this.value = value;
    }

    
    /** 
     * @return ArrayList<Part>
     */
    public ArrayList<Part> getSubParts()
    {
        if(subparts == null){
            logger.warn("Subparts are null here.");
        }
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

        if(subparts == null){
            logger.error("Subparts are null");
        }

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
