# Library Management System 

A simple **Library Management System** built with **Java** to manage books and borrowers efficiently.

---

###  Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Project Structure](#project-structure)
4. [How to Run](#how-to-run)

---

## Overview

The **Library Management System** allows administrators to manage books (both physical and electronic), register borrowers, and track the borrowing process. It provides a menu interface to perform various operations like adding books, borrowers, borrowing, returning books, and displaying history.

---

## Features

- **Add Books**: Add new books (physical or electronic).
- **Register Borrowers**: Add new borrowers to the library system.
- **Borrow & Return Books**: Track the borrowing and returning of books.
- **Display Books**: View a list of all books available in the library.
- **Display Borrowers**: View a list of all borrowers and the books they have borrowed.
- **Track Borrowing History**: View detailed history of book borrowings and returns.

---


## Project Structure

```
src/
├── Book.java             # Abstract base class for all book types
├── RealBook.java         # Physical book with pages and location
├── EBook.java            # Electronic book with format and size
├── Borrower.java         # Library member who can borrow books
├── BorrowingProcess.java # Record of a borrow/return transaction
├── Library.java          # Core class managing books, borrowers, and history
└── library_System.java   # Main class with console menu interface
```


## How to Run

### Requirements

- **Java JDK** (any version supporting Java 8 and above)
- Text editor/IDE (e.g., IntelliJ, Eclipse)

### Steps

1. Clone or download the project.
2. Open the terminal/command line and navigate to the project folder.
3. Compile all Java files:
   ```bash
   javac *.java

---
Name : Safouane Naceur
Groupe : Debt
---
