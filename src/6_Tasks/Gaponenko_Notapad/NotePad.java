
import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotePad implements Serializable {
    private String fileName = "notepad.dat";//файл для записи/чтения блокнота
    private String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private ArrayList<Note> notes;//заметки в блокноте
    Scanner scanner;

    NotePad() {
        notes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addNote() {//добавление записи в блокнот
        String topic;
        String email;
        String message;
        System.out.println("Введите тему заметки:");
        topic = scanner.nextLine();
        System.out.println("Введите e-mail:");
        while (!((email = scanner.nextLine()).matches(regexEmail))) {
            System.out.println("Необходимо ввести корректный e-mail");
        }
        System.out.println("Введите сообщение:");
        message = scanner.nextLine();
        notes.add(new Note(topic, email, message));
    }

    public boolean isDateValid(String date) {//проверка корректности даты
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public ArrayList<Note> findTopic() { //поиск заметок по теме
        String topicFind;
        ArrayList<Note> topicList = new ArrayList<>();
        System.out.println("Введите тему для поиска:");
        topicFind = scanner.nextLine();
        for (Note note : notes) {
            if (note.getTopic().matches(topicFind)) {
                topicList.add(note);
            }
        }
        return topicList;
    }

    public ArrayList<Note> findEmail() { //поиск заметок по электронному адресу
        String emailFind;
        ArrayList<Note> emailList = new ArrayList<>();
        System.out.println("Введите e-mail для поиска:");
        while (!((emailFind = scanner.nextLine()).matches(regexEmail))) {
            System.out.println("Необходимо ввести корректный e-mail");
        }
        for (Note note : notes) {
            if (note.getEmail().matches(emailFind)) {
                emailList.add(note);
            }
        }
        return emailList;
    }

    public ArrayList<Note> findData() { //поиск заметок по дате
        String dataFind;
        ArrayList<Note> dataList = new ArrayList<>();
        System.out.println("Введите дату(yyyy-MM-dd) для поиска: ");
        while (!isDateValid(dataFind = scanner.nextLine())) {
            System.out.println("Необходимо ввести корректную дату");
        }
        for (Note note : notes) {
            if (note.getDate().toString().matches(dataFind)) {
                dataList.add(note);
            }
        }
        return dataList;
    }

    public ArrayList<Note> findMessage() { //поиск заметок по сообщению
        String messageFind;
        ArrayList<Note> messageList = new ArrayList<>();
        System.out.println("Введите сообщение для поиска: ");
        messageFind = scanner.nextLine();
        for (Note note : notes) {
            if (note.getMessage().matches(messageFind)) {
                messageList.add(note);
            }
        }
        return messageList;
    }

    public ArrayList<Note> findEmailTopic() { //поиск заметок по электронному адресу и теме
        String emailFind;
        String topicFind;
        ArrayList<Note> emailTopicList = new ArrayList<>();
        System.out.println("Введите тему для поиска:");
        topicFind = scanner.nextLine();
        System.out.println("Введите e-mail для поиска:");
        while (!((emailFind = scanner.nextLine()).matches(regexEmail))) {
            System.out.println("Необходимо ввести корректный e-mail");
        }
        for (Note note : notes) {
            if (note.getEmail().matches(emailFind) && note.getTopic().matches(topicFind)) {
                emailTopicList.add(note);
            }
        }
        return emailTopicList;
    }

    public ArrayList<Note> findWord() {//поиск заметок по вхождению слова
        ArrayList<Note> wordList = new ArrayList<>();
        String word;
        System.out.println("Введите слово для поиска:");
        word = scanner.nextLine();
        Pattern p = Pattern.compile(word);
        Matcher matcherTopic;
        Matcher matcherMessage;
        for (Note note : notes) {
            matcherMessage = p.matcher(note.getMessage());
            matcherTopic = p.matcher(note.getTopic());
            if (matcherMessage.find() || matcherTopic.find()) {
                wordList.add(note);
            }
        }
        return wordList;
    }

    public ArrayList<Note> sortTopic() {//сортировка заметок по теме
        notes.sort(Comparator.comparing(Note::getTopic));
        return notes;
    }

    public ArrayList<Note> sortEmail() {//сортировка заметок по электронному адресу
        notes.sort(Comparator.comparing(Note::getEmail));
        return notes;
    }

    public ArrayList<Note> sortData() {//сортировка заметок по дате
        notes.sort(Comparator.comparing(Note::getDate));
        return notes;
    }

    public ArrayList<Note> sortMessage() {//сортировка заметок по сообщению
        notes.sort(Comparator.comparing(Note::getMessage));
        return notes;
    }

    public void write() {//запись заметок в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(notes);
        } catch (Exception ex) {
        }
    }

    public void read() {//чтение заметок из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            notes = (ArrayList<Note>) ois.readObject();
        } catch (Exception ex) {
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Note note : notes) {
            result.append(note);
        }
        return result.toString();
    }
}
