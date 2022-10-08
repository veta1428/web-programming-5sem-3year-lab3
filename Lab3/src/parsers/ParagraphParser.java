package parsers;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

import parts.Paragraph;
import parts.Part;
import parts.Sentence;

public class ParagraphParser extends AbstractParser {
    @Override
    public boolean parse(Part part) {
        if (part.getClass() == Paragraph.class) {
            BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
            String source = part.getValue();
            iterator.setText(source);

            ArrayList<Part> sentences = new ArrayList<Part>();

            int start = iterator.first();

            for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
                Sentence sentence = new Sentence(source.substring(start, end).trim());
                sentences.add(sentence);
            }

            part.setSubParts(sentences);
            return true;
        } else {
            return super.parse(part);
        }
    }
}
