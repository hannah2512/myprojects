import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static class Book {
        String title;
        String author;
        boolean isAvailable;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        void borrowBook() {
            if (isAvailable) {
                isAvailable = false;
                System.out.println("You have borrowed: " + title);
            } else {
                System.out.println("Sorry, this book is not available.");
            }
        }

        void returnBook() {
            if (!isAvailable) {
                isAvailable = true;
                System.out.println("You have returned: " + title);
            } else {
                System.out.println("This book was not borrowed.");
            }
        }

        @Override
        public String toString() {
            return (isAvailable ? "[Available] " : "[Borrowed] ") + title + " by " + author;
        }
    }

    static class Library {
        private ArrayList<Book> books;

        Library() {
            books = new ArrayList<>();
        }

        void addBook(String title, String author) {
            books.add(new Book(title, author));
            System.out.println("Book added: " + title);
        }

        void viewBooks() {
            if (books.isEmpty()) {
                System.out.println("No books available in the library.");
            } else {
                for (int i = 0; i < books.size(); i++) {
                    System.out.println((i + 1) + ". " + books.get(i));
                }
            }
        }

        void borrowBook(int index) {
            if (index >= 0 && index < books.size()) {
                books.get(index).borrowBook();
            } else {
                System.out.println("Invalid book index.");
            }
        }

        void returnBook(int index) {
            if (index >= 0 && index < books.size()) {
                books.get(index).returnBook();
            } else {
                System.out.println("Invalid book index.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        while (true) {
            System.out.println("\n----- Library Management System -----");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character after int input

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter book index to borrow: ");
                    int borrowIndex = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    library.borrowBook(borrowIndex);
                    break;

                case 4:
                    System.out.print("Enter book index to return: ");
                    int returnIndex = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    library.returnBook(returnIndex);
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

