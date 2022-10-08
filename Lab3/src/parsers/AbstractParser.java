package parsers;

import parts.Part;

public abstract class AbstractParser implements IParser {
    private IParser _nextParser;

    public IParser setNext(IParser parser) {
        this._nextParser = parser;
        return parser;
    }

    public IParser getNext() {
        return _nextParser;
    }

    public boolean parse(Part part) {
        if (this._nextParser != null) {
            return this._nextParser.parse(part);
        }

        return false;
    }
}
