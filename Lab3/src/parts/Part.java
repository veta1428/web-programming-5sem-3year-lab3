package parts;

import java.util.ArrayList;

public abstract class Part {
    private ArrayList<Part> subparts;
    private String value;

    public Part(String value){
        setValue(value);
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public ArrayList<Part> getSubParts()
    {
        return subparts;
    }

    public void setSubParts(ArrayList<Part> subparts)
    {
        this.subparts = subparts;
    }

    @Override
    public String toString(){
        String result = new String();
        for (Part subpart : subparts) {
            result += subpart.toString();
        }
        return result;
    }

    public String print() {
        return value.trim();
    }
}
