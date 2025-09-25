import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

public class Task3_LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Enter Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Author: ");
                String author = sc.nextLine();
                books.add(new Book(id, title, author));
                System.out.println("Book added!");
            } 
            else if (choice == 2) {
                if (books.isEmpty()) System.out.println("No books found!");
                else {
                    for (Book b : books) {
                        System.out.println("ID: " + b.id + " | " + b.title + " by " + b.author +
                                (b.isIssued ? " [Issued]" : " [Available]"));
                    }
                }
            } 
            else if (choice == 3) {
                System.out.print("Enter Book ID to issue: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Book b : books) {
                    if (b.id == id && !b.isIssued) {
                        b.isIssued = true;
                        System.out.println("Book issued!");
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Book not available!");
            } 
            else if (choice == 4) {
                System.out.print("Enter Book ID to return: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Book b : books) {
                    if (b.id == id && b.isIssued) {
                        b.isIssued = false;
                        System.out.println("Book returned!");
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Book not issued or not found!");
            } 
            else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
