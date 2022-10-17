package parsers;

import parts.Part;

public abstract class AbstractParser implements IParser {
    private IParser _nextParser;

    
    /** 
     * @param parser
     * @return IParser
     */
    public IParser setNext(IParser parser) {
        this._nextParser = parser;
        return parser;
    }

    
    /** 
     * @return IParser
     */
    public IParser getNext() {
        return _nextParser;
    }

    
    /** 
     * @param part
     * @return boolean
     */
    public boolean parse(Part part) {
        if (this._nextParser != null) {
            return this._nextParser.parse(part);
        }

        return false;
    }
}
