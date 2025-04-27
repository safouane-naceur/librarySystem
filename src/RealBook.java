public class RealBook extends Book {
    private int numberOfPages;
    private String location; // Shelf location in library

    public RealBook(String title, String author, int ISBN, int numberOfPages, String location) {
        super(title, author, ISBN);
        this.numberOfPages = numberOfPages;
        this.location = location;
    }

    // Getters
    public int getNumberOfPages() { return numberOfPages; }
    public String getLocation() { return location; }

    @Override
    public String getBookType() {
        return "Real Book";
    }
} 
