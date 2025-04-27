import java.util.ArrayList;
import java.util.List;

/**
  Library class manages a collection of books and borrowers.
  It provides functionality for adding books and borrowers,
  borrowing and returning books, and displaying library information.
 */
public class Library {
    // Lists to store books and borrowers
    private List<Book> books;
    private List<Borrower> borrowers;
    private List<BorrowingProcess> borrowingHistory;

    public Library() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
        borrowingHistory = new ArrayList<>();
    }

    // Adds a new book to the library

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Adds a new borrower to the library
 
    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
        System.out.println("Borrower added: " + borrower.getName());
    }

    // Finds a book by its ISBN

    public Book findBookByISBN(int ISBN) {
        for (Book book : books) {
            if (book.getISBN() == ISBN) return book;
        }
        return null;
    }

    //  Finds a borrower by their university ID

    public Borrower findBorrowerByID(int univId) {
        for (Borrower borrower : borrowers) {
            if (borrower.getUnivId() == univId) return borrower;
        }
        return null;
    }

    // Handles the process of borrowing a book
     
    public void borrowBook(int ISBN, int univId) {
        Book book = findBookByISBN(ISBN);
        Borrower borrower = findBorrowerByID(univId);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }
        if (borrower == null) {
            System.out.println("Borrower not registered");
            return;
        }
        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed");
            return;
        }

        borrower.borrowBook(book);
        // Create and store the borrowing process
        BorrowingProcess process = new BorrowingProcess(book, borrower);
        borrowingHistory.add(process);
        System.out.println("Book '" + book.getTitle() + "' borrowed by " + borrower.getName());
    }

    public void returnBook(int ISBN, int univId) {
        Book book = findBookByISBN(ISBN);
        Borrower borrower = findBorrowerByID(univId);

        if (book == null || borrower == null || !book.isBorrowed()) {
            System.out.println("Unable to return the book");
            return;
        }

        borrower.returnBook(book);
        // Find and update the borrowing process
        for (BorrowingProcess process : borrowingHistory) {
            if (process.getBorrowedBook() == book && process.getBorrower() == borrower && !process.isReturned()) {
                process.recordReturn();
                break;
            }
        }
        System.out.println("Book '" + book.getTitle() + "' returned by " + borrower.getName());
    }

    // Add a new method to display borrowing history
    public void displayBorrowingHistory() {
        System.out.println("\nBorrowing History:");
        for (BorrowingProcess process : borrowingHistory) {
            System.out.println("Book: " + process.getBorrowedBook().getTitle() +
                             ", Borrower: " + process.getBorrower().getName() +
                             ", Borrowed: " + process.getBorrowDate() +
                             ", Returned: " + (process.isReturned() ? process.getReturnDate() : "Not returned yet"));
        }
    }

    
     // Displays information about all books in the library
     
    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + 
                             ", Author: " + book.getAuthor() + 
                             ", ISBN: " + book.getISBN() + 
                             ", Type: " + book.getBookType() +
                             ", Status: " + (book.isBorrowed() ? "Borrowed" : "Available"));
        }
    }

    
    //  Displays information about all borrowers in the library
    
    public void displayBorrowers() {
        System.out.println("\nBorrowers List:");
        for (Borrower borrower : borrowers) {
            System.out.println("Name: " + borrower.getName() + 
                             ", University ID: " + borrower.getUnivId() + 
                             ", Borrowed Books: " + borrower.getBorrowedBooks().size());
        }
    }
}
