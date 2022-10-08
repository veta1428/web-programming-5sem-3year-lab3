import parsers.IParser;
import parsers.ParagraphParser;
import parsers.SentenceParser;
import parsers.TextParser;
import parts.Part;
import parts.Text;

public class App {

    private static void parseAll(Part part, IParser parser)
    {
        System.out.println("Type: " + part.getClass());
        System.out.println(part.getValue());
        boolean wasParsed = parser.parse(part);
        if(wasParsed == false){
            return;
        }
        for (Part subpart : part.getSubParts()) {
            parseAll(subpart, parser);
        }
    }

    public static void main(String[] args) throws Exception {

        TextParser tparser = new TextParser();
        SentenceParser sparser = new SentenceParser();
        ParagraphParser pparser = new ParagraphParser();
        tparser
            .setNext(sparser)
            .setNext(pparser);
        
        String strText = new String("Hello привет, I am Liza! And what is your name? \nHow are you? \t\t\t\tLook!\n@code@ This is" +  
        "\n my code@code@Good \tbye! And some code for you: \n@code@ Beautiful\tcode@code@");
        Text txt = new Text(strText);
        parseAll(txt, tparser);
        //System.out.println("*************************Restored text ************************");
        //System.out.println(txt.toString());
    }
}
