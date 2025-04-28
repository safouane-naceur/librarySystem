import java.util.Scanner;

public class library_System {
    public static void main(String[] args) {
        // Create a library instance
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        // Menu interface
        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Borrower");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Display All Borrowers");
            System.out.println("7. Display Borrowing History");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1: // Add a Book
                    System.out.println("\n--- Add a Book ---");
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    int isbn = 0;
                    boolean validIsbn = false;
                    while (!validIsbn) {
                        try {
                            isbn = Integer.parseInt(scanner.nextLine());
                            validIsbn = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for ISBN.");
                        }
                    }
                    
                    System.out.println("Select book type:");
                    System.out.println("1. E-Book");
                    System.out.println("2. Physical Book");
                    System.out.print("Enter choice: ");
                    int bookType = 0;
                    boolean validBookType = false;
                    while (!validBookType) {
                        try {
                            bookType = Integer.parseInt(scanner.nextLine());
                            if (bookType == 1 || bookType == 2) {
                                validBookType = true;
                            } else {
                                System.out.println("Invalid choice. Please enter 1 for E-Book or 2 for Physical Book.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }
                    
                    if (bookType == 1) {
                        System.out.print("Enter file format (PDF, EPUB, etc.): ");
                        String format = scanner.nextLine();
                        System.out.print("Enter file size (MB): ");
                        double size = 0;
                        boolean validSize = false;
                        while (!validSize) {
                            try {
                                size = Double.parseDouble(scanner.nextLine());
                                if (size > 0) {
                                    validSize = true;
                                } else {
                                    System.out.println("File size must be greater than 0.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number for file size.");
                            }
                        }
                        
                        EBook ebook = new EBook(title, author, isbn, format, size);
                        library.addBook(ebook);
                    } else {
                        System.out.print("Enter number of pages: ");
                        int pages = 0;
                        boolean validPages = false;
                        while (!validPages) {
                            try {
                                pages = Integer.parseInt(scanner.nextLine());
                                if (pages > 0) {
                                    validPages = true;
                                } else {
                                    System.out.println("Number of pages must be greater than 0.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number for pages.");
                            }
                        }
                        System.out.print("Enter shelf location: ");
                        String location = scanner.nextLine();
                        
                        RealBook realBook = new RealBook(title, author, isbn, pages, location);
                        library.addBook(realBook);
                    }
                    break;
                    
                case 2: // Add a Borrower
                    System.out.println("\n--- Add a Borrower ---");
                    System.out.print("Enter borrower name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter university ID: ");
                    int univId = 0;
                    boolean validUnivId = false;
                    while (!validUnivId) {
                        try {
                            univId = Integer.parseInt(scanner.nextLine());
                            if (univId > 0) {
                                validUnivId = true;
                            } else {
                                System.out.println("University ID must be greater than 0.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for university ID.");
                        }
                    }
                    
                    Borrower borrower = new Borrower(name, univId);
                    library.addBorrower(borrower);
                    break;
                    
                case 3: // Borrow a Book
                    System.out.println("\n--- Borrow a Book ---");
                    System.out.print("Enter book ISBN: ");
                    int borrowIsbn = 0;
                    boolean validBorrowIsbn = false;
                    while (!validBorrowIsbn) {
                        try {
                            borrowIsbn = Integer.parseInt(scanner.nextLine());
                            if (borrowIsbn > 0) {
                                validBorrowIsbn = true;
                            } else {
                                System.out.println("ISBN must be greater than 0.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for ISBN.");
                        }
                    }
                    
                    System.out.print("Enter university ID: ");
                    int borrowUnivId = 0;
                    boolean validBorrowUnivId = false;
                    while (!validBorrowUnivId) {
                        try {
                            borrowUnivId = Integer.parseInt(scanner.nextLine());
                            if (borrowUnivId > 0) {
                                validBorrowUnivId = true;
                            } else {
                                System.out.println("University ID must be greater than 0.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for university ID.");
                        }
                    }
                    
                    library.borrowBook(borrowIsbn, borrowUnivId);
                    break;
                    
                case 4: // Return a Book
                    System.out.println("\n--- Return a Book ---");
                    System.out.print("Enter book ISBN: ");
                    int returnIsbn = 0;
                    boolean validReturnIsbn = false;
                    while (!validReturnIsbn) {
                        try {
                            returnIsbn = Integer.parseInt(scanner.nextLine());
                            if (returnIsbn > 0) {
                                validReturnIsbn = true;
                            } else {
                                System.out.println("ISBN must be greater than 0.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for ISBN.");
                        }
                    }
                    
                    System.out.print("Enter university ID: ");
                    int returnUnivId = 0;
                    boolean validReturnUnivId = false;
                    while (!validReturnUnivId) {
                        try {
                            returnUnivId = Integer.parseInt(scanner.nextLine());
                            if (returnUnivId > 0) {
                                validReturnUnivId = true;
                            } else {
                                System.out.println("University ID must be greater than 0.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for university ID.");
                        }
                    }
                    
                    library.returnBook(returnIsbn, returnUnivId);
                    break;
                    
                case 5: // Display All Books
                    System.out.println("\n--- All Books ---");
                    library.displayBooks();
                    break;
                    
                case 6: // Display All Borrowers
                    System.out.println("\n--- All Borrowers ---");
                    library.displayBorrowers();
                    break;
                    
                case 7: // Display Borrowing History
                    System.out.println("\n--- Borrowing History ---");
                    library.displayBorrowingHistory();
                    break;
                    
                case 8: // Exit
                    System.out.println("Thank you for using the Library Management System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
