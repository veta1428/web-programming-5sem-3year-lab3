package parts;

public class Word extends Part{

    public Word(String value) {
        super(value);
    }

    @Override
    public String toString(){
        return getValue();
    }
}
