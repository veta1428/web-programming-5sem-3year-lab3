import java.util.ArrayList;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import comparators.PartComparer;
import parsers.IParser;
import parsers.ParagraphParser;
import parsers.SentenceParser;
import parsers.TextParser;
import parts.Code;
import parts.Part;
import parts.PunktuationMark;
import parts.Text;
import parts.Word;
import properties.AppLocale;

public class App {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    
    /** 
     * @param part
     * @param parser
     */
    private static void parseAll(Part part, IParser parser) {
        // System.out.println("Type: " + part.getClass());
        // System.out.println(part.getValue());
        boolean wasParsed = parser.parse(part);
        if (wasParsed == false) {
            return;
        }
        for (Part subpart : part.getSubParts()) {
            parseAll(subpart, parser);
        }
    }

    
    /** 
     * @param part
     * @param last
     */
    private static void transform(Part part, boolean last) {
        for (Part subpart : part.getSubParts()) {
            if(subpart.getClass() == Word.class){
                try{
                    ((Word)subpart).transform(last);
                }
                catch(IllegalArgumentException ex){
                    System.out.println("ERROR. Job terminated");
                }
            } else if(subpart.getClass() != PunktuationMark.class && subpart.getClass() != Code.class){
                transform(subpart, last);
            }
        }
    }

    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        Locale locale = new Locale("pol-PL");
        Logger logger = LogManager.getRootLogger();

        AppLocale.set(locale);

        TextParser tparser = new TextParser();
        SentenceParser sparser = new SentenceParser();
        ParagraphParser pparser = new ParagraphParser();
        tparser
                .setNext(sparser)
                .setNext(pparser);

        String strText2 = new String(
                "Hello, I привет, друзья, приветствую вас, am Liza! And what is your name? \nHow areaa you? \t\t\t\tLook!\n@code@ This is" +
                        "\n my code@code@Good \tbye! And some code for you: \n@code@ Beautiful\tcode@code@");
        Text txt2 = new Text(strText2);
        parseAll(txt2, tparser);
        System.out.println(AppLocale.getString(AppLocale.TEXT));
        System.out.println(txt2.getValue());
        System.out.println(AppLocale.getString(AppLocale.WORDS_SORTED));
        ArrayList<Part> words = txt2.getAllWords();
        for (Part word : words) {
            System.out.println(word.getValue());
        }

        System.out.println(AppLocale.getString(AppLocale.ENTER_CHARACTER));

        char character;
        
        try{
            character = getCharInput();
        }
        catch(IllegalArgumentException ex){
            logger.error("Error occured job aborted.");
            System.out.println("Error happened: " + ex.getMessage() + " - job terminated");
            return;
        }

        PartComparer comp = new PartComparer(character);
        words.sort(comp);

        System.out.println(AppLocale.getString(AppLocale.WORDS_SORTED));

        for (Part word : words) {
            System.out.println(word.getValue());
        }
        System.out.println(AppLocale.getString(AppLocale.TRANSFORM_MODE));

        try{
            character = getCharInput();
        }
        catch(IllegalArgumentException ex){
            logger.error("Error occured job aborted.");
            System.out.println("Error happened: " + ex.getMessage() + " - job terminated");
            return;
        }

        boolean last = character == 'F' ? false : true;
        transform(txt2, last);
        System.out.println(txt2.toString());
    }

    private static char getCharInput() {
        String input = System.console().readLine();
        if(input == null || input.length() == 0){
            throw new IllegalArgumentException("Invalid argument!");
        }
        return input.charAt(0);
    }
}
