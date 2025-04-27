import java.util.Date;

public class BorrowingProcess {
     private Book borrowedBook;
     private Borrower borrower;
     private Date borrowDate;
     private Date returnDate;
 
     // Creates a new borrowing process record when a book is borrowed
  
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
     
     // Records the return of the book
   
     public void recordReturn() {
         this.returnDate = new Date();
     }
 
     
     public boolean isReturned() {
         return returnDate != null;
     }
 
 }
