import java.util.ArrayList;

public class Text {//класс текст
    private ArrayList<Sentence> text;//текст
    private String title;//заголовок

    public Text(ArrayList<Sentence> text, String title) {
        this.text = text;
        this.title = title;
    }

    public void addText(Sentence sentence) {
        this.text.add(sentence);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("\n").append(title).append("\n\n");
        for (Sentence sentence : this.text) {
            text.append(sentence);
        }
        return text.toString();
    }
}
