import java.text.MessageFormat;
import java.util.ArrayList;

public class Sentence {//класс предложение
    private ArrayList<Word> sentence;

    public Sentence(ArrayList<Word> sentence) {
        this.sentence = sentence;
    }

    public void setSentence(ArrayList<Word> sentence) {
        this.sentence = sentence;
    }

    public ArrayList<Word> getSentence() {
        return sentence;
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Word word : this.sentence) {
            sentence.append(word).append(' ');
        }
        sentence.append("\n");
        return sentence.toString();
    }
}
