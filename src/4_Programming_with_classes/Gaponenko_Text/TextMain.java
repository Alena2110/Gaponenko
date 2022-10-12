import java.util.ArrayList;

public class TextMain {
    public static void main(String[] args) {
        ArrayList<Word> wordsOne = new ArrayList<>();
        ArrayList<Word> wordsTwo = new ArrayList<>();
        ArrayList<Word> wordsThree = new ArrayList<>();
        String[] array = ("Messages that contain the word or name you specified appear with the search text highlighted" +
                " in the results.").split(" ");
        for (String word : array) {
            wordsOne.add(new Word(word));
        }
        Sentence sentenceOne = new Sentence(wordsOne);//первое предложение
        array = ("Display the word Facebook in the same font size and style as the text surrounding it.").split(" ");
        for (String word : array) {
            wordsTwo.add(new Word(word));
        }
        Sentence sentenceTwo = new Sentence(wordsTwo);//второе предложение
        array = ("It is doubled to place a word in all caps; this must be repeated for each word of an all-cap text.").
                split(" ");
        for (String word : array) {
            wordsThree.add(new Word(word));
        }
        Sentence sentenceThree = new Sentence(wordsThree);//третье предложение
        ArrayList<Sentence> sentences = new ArrayList<>();
        sentences.add(sentenceOne);
        sentences.add(sentenceTwo);
        System.out.println("Текст из двух предложений");
        Text text = new Text(sentences, "Messages");
        System.out.println(text);
        text.addText(sentenceThree);
        System.out.println("Текст с добавлением третьего предложения");
        System.out.println(text);
    }
}