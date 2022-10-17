package parsers;

import java.util.ArrayList;
import java.util.Arrays;

import parts.Code;
import parts.Paragraph;
import parts.Part;
import parts.Text;

public class TextParser extends AbstractParser {
    
    /** 
     * @param part
     * @return boolean
     */
    @Override
    public boolean parse(Part part) {
        if (part.getClass() == Text.class) {

            String regexp = Code.CodeSign;
            String str = part.getValue();
            str.indexOf(regexp);

            ArrayList<String> subparts = new ArrayList<>(Arrays.asList(str.split(regexp)));

            boolean codeFirst = str.indexOf(regexp) == 0;

            if (codeFirst) {
                subparts.remove(0);
            }
            ArrayList<Part> subpartsClassified = new ArrayList<Part>();

            for (int i = 0; i < subparts.size(); i++) {
                if ((codeFirst && i % 2 == 0) || (!codeFirst && i % 2 == 1)) {
                    subpartsClassified.add(new Code(subparts.get(i)));
                } else {
                    subpartsClassified.addAll((getParagraphs(subparts.get(i))));
                }
            }

            part.setSubParts(subpartsClassified);
            return true;
        } else {
            return super.parse(part);
        }
    }

    
    /** 
     * @param source
     * @return String
     */
    private String removeWhitespacesAndTabs(String source){
        source = source.replaceAll("\t+", " ");
        return source.replaceAll("\s{2,}", " ");
    }

    
    /** 
     * @param mergedParagraphs
     * @return ArrayList<String>
     */
    private ArrayList<String> getParagraphsStringsFromText(String mergedParagraphs){
        return new ArrayList<>(Arrays.asList(mergedParagraphs.split("\n+")));
    }

    
    /** 
     * @param mergedParagraphs
     * @return ArrayList<Paragraph>
     */
    private ArrayList<Paragraph> getParagraphs(String mergedParagraphs){
        mergedParagraphs = removeWhitespacesAndTabs(mergedParagraphs);
        ArrayList<String> paragraphsStr = getParagraphsStringsFromText(mergedParagraphs);
        ArrayList<Paragraph> paragraphs = new ArrayList<>();
        for (String paragraph : paragraphsStr) {
            paragraphs.add(new Paragraph(paragraph));
        }
        return paragraphs;
    }
}
