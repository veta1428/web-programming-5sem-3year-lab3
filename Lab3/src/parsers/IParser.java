package parsers;

import parts.Part;

public interface IParser {
    public abstract IParser setNext(IParser parser);
    public abstract IParser getNext();
    public abstract boolean parse(Part part);
}
