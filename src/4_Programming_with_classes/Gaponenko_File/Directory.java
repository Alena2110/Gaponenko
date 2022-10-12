public class Directory extends java.io.File {
    private String nameDirectory;

    Directory(String nameDirectory) {
        super(nameDirectory);
        this.nameDirectory = nameDirectory;
    }

    public String getNameDirectory() {
        return nameDirectory;
    }
}