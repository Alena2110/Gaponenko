
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class TextFile extends java.io.File {
    File file;
    Directory directory;

    TextFile(Directory directory, File file) {
        super(directory, file.getNameFile());
        this.file = file;
        this.directory = directory;
    }

    public void createTextFile() {//создание текстового файла
        if (directory.exists()) {
            System.out.println("Директория " + directory.getNameDirectory() + " была создана ранее.");
        } else {
            boolean createDirectory = directory.mkdir();
            if (createDirectory) {
                System.out.println("Директория " + directory.getNameDirectory() + " создана.");
            } else {
                System.out.println("Директория " + directory.getNameDirectory() + " не создана.");
            }
        }
        if (!this.exists()) {
            if (file.getNameFile().endsWith(".txt")) {
                try {
                    boolean createFile = this.createNewFile();
                    if (createFile) {
                        System.out.println("Файл " + file.getNameFile() + " создан.");
                    } else {
                        System.out.println("Файл " + file.getNameFile() + " не создан.");
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else System.out.println("Файл не создан, т.к. не является текстовым");
        } else {
            System.out.println("Файл " + file.getNameFile() + " уже создан.");
        }
    }

    public void renameFile(TextFile textFile) {//переименование текстового файла
        this.renameTo(textFile);
    }

    public void addFile(String text) {//добавление текста в файл
        try (FileWriter writer = new FileWriter(this, true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readFile() {//чтение файла
        try (FileReader reader = new FileReader(this)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteFile() {//удаление файла
        boolean deleted = this.delete();
        if (deleted) {
            System.out.println("\n\nФайл " + this.file.getNameFile() + " удален");
        }
    }
}

