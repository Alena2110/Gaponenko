/*Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить.*/


public class Main {
    public static void main(String[] args) {
        File fileOne = new File("textOne.txt");
        File fileTwo = new File("textTwo.txt");
        Directory directory = new Directory("C://Dir");
        TextFile textFileOne = new TextFile(directory, fileOne);
        textFileOne.createTextFile();
        TextFile textFileTwo = new TextFile(directory, fileTwo);
        textFileTwo.createTextFile();
        TextFile textFileThree = new TextFile(directory, new File("textTwoNew.txt"));
        textFileTwo.renameFile(textFileThree);
        textFileOne.addFile("\n\nТекст.\nПервое предложение.");
        textFileOne.readFile();
        textFileOne.addFile("\nВторое предложение.");
        textFileOne.readFile();
        textFileThree.deleteFile();
    }
}
