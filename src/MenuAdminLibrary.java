import java.util.Scanner;

public class MenuAdminLibrary {
    Scanner input = new Scanner(System.in);
    Admin admin;

    public MenuAdminLibrary(Admin admin) {
        this.admin = admin;
        menu();
    }

    public void menu() {
        System.out.println("----------------------------------");
        System.out.println("* * * Menu Admin Library  * * *");
        int item;
        do {
            System.out.println("1.Add Book");
            System.out.println("2.Remove Book");
            System.out.println("3.List All books");
            System.out.println("4.Loaned books");
            System.out.println("5.Back");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 8 || item < 1);
        switch (item) {
            case 1 -> addBook();
            case 2 -> removeBook();
            case 3 -> listAllBook();
            case 4 -> listLoanedBook();
            default -> new Main();
        }
        menu();
    }

    public void addBook() {
        System.out.println("----------------------------------");
        System.out.println("* * * Add Book  * * *");
        DataBase.books.add(new Book(input));
        System.out.println("New book added successfully");
        menu();
    }

    public void removeBook() {
        System.out.println("----------------------------------");
        System.out.println("* * * Remove Book  * * *");
        Book book;
        while (true) {
            System.out.print("Enter code book for remove : ");
            int code = input.nextInt();
            book = DataBase.getBook(code);
            if (book == null) {
                System.out.println("There is no book with this code.");
                System.out.print("enter y try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            } else if (book.isBorrowed()) {
                System.out.println("The desired book is on loan and it is not possible to remove it from the library.");
                menu();
            } else
                break;
        }
        DataBase.books.remove(book);
        System.out.println("Book removed successfully");
        menu();
    }

    public void listAllBook() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Book * * *");
        int i = 1;
        for (Book b : DataBase.books) {
            System.out.println((i++) + ". " + b);
        }
    }

    public void listLoanedBook() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Book * * *");
        if (DataBase.borrowedBooks.size() == 0)
            System.out.println("List is empty.");
        else {
            int i = 1;
            for (BorrowedBook b : DataBase.borrowedBooks) {
                System.out.println((i++) + ". " + b);
            }
        }
    }
}
