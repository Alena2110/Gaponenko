/*1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на консоль
     текст, заголовок текста.*/

public class Word { //класс слово
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word;
    }
}