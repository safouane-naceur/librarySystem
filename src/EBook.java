public class EBook extends Book {
    private String fileFormat;
    private double fileSize; // in MB

    public EBook(String title, String author, int ISBN, String fileFormat, double fileSize) {
        super(title, author, ISBN);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }

    // Getters for EBook specific attributes
    public String getFileFormat() { return fileFormat; }
    public double getFileSize() { return fileSize; }

    @Override
    public String getBookType() {
        return "E-Book";
    }
} 
