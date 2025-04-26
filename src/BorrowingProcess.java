import java.util.Date;

public class BorrowingProcess {
    private Book borrowedBook;
    private Borrower borrower;
    private Date borrowDate;
    private Date returnDate;

    public BorrowingProcess(Book borrowedBook, Borrower borrower) {
        this.borrowedBook = borrowedBook;
        this.borrower = borrower;
        this.borrowDate = new Date(); // Current date
        this.returnDate = null; // Will be set when book is returned
    }

    // Getters
    public Book getBorrowedBook() { return borrowedBook; }
    public Borrower getBorrower() { return borrower; }
    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }

    // Method to return the book
    public void returnBook() {
        this.returnDate = new Date();
        this.borrowedBook.setBorrowed(false);
    }

    // Method to check if book is returned
    public boolean isReturned() {
        return returnDate != null;
    }
} 
