package parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    protected Logger getLogger(IParser parser){
        return LogManager.getLogger(parser.getClass());
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
        LogManager.getLogger(this.getClass()).info(this.getClass() + " further parse is impossible.");
        return false;
    }
}
