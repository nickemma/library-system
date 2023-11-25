import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, Book> library = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
          // Display the main menu
            System.out.println("Welcome To Techie Emma's BookStore \n");
            System.out.println("Library System Menu:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. List All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

          // Get the user's choice
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                // Call the addBooks method
                    addBooks();
                    break;
                case 2:
                // Call the borrowBooks method
                    borrowBooks();
                    break;
                case 3:
                // Call the returnBooks method
                    returnBooks();
                    break;
                case 4:
                // Call the listAllBooks method
                    listAllBooks();
                    break;
                case 5:
                // Exit the program
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                // Invalid choice
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addBooks() {
      // Get user input for book details
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

      // Check if the book already exists in the library
        Book book = library.get(title);
        if (book != null) {
            // Book already exists, update quantity
            book.setQuantity(book.getQuantity() + quantity);
            System.out.println("Book updated successfully. \n");
        } else {
            // Add new book to the library
            library.put(title, new Book(title, author, quantity));
            System.out.println("Book added successfully. \n");
        }
    }

    private static void borrowBooks() {
      // Get user input for borrowing books
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the number of books to borrow: ");
        int quantityToBorrow = scanner.nextInt();
      
      // Check if the requested number of books is available
        Book book = library.get(title);
        if (book != null && book.getQuantity() >= quantityToBorrow) {
            // Sufficient books available, update quantity
            book.setQuantity(book.getQuantity() - quantityToBorrow);
            System.out.println("Borrow successful. Enjoy your reading! \n");
        } else {
            // Book not available or insufficient quantity
            System.out.println("Sorry, the requested books are not available. \n");
        }
    }

    private static void returnBooks() {
      // Get user input for returning books
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the number of books to return: ");
        int quantityToReturn = scanner.nextInt();
      // Check if the returned books belong to the library system
        Book book = library.get(title);
        if (book != null) {
            // Book belongs to the library, update quantity
            book.setQuantity(book.getQuantity() + quantityToReturn);
            System.out.println("Return successful. Thank you for returning the books! \n");
        } else {
            // Book not found in the library
            System.out.println("Error: The returned books do not belong to the library system. \n");
        }
    }

  private static void listAllBooks() {
    // Display all books in the library
      if (library.isEmpty()) {
          System.out.println("No books available. Please come back later.");
      } else {
          System.out.println("List of All Books in the Library: \n");
          for (Book book : library.values()) {
              System.out.println(book.getTitle() + " by " + book.getAuthor() + " => Quantity: " + book.getQuantity());
          }
      }
  }

    // Create a Book class
    private static class Book {
        private String title;
        private String author;
        private int quantity;

      // Constructor to initialize book details
        public Book(String title, String author, int quantity) {
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }
      // Getter methods
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getQuantity() {
            return quantity;
        }
      // Setter method
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
