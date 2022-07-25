import java.util.Scanner;

public class Library {
    Scanner input = new Scanner(System.in);
    Student student;

    public Library(Student student) {
        this.student = student;
    }

    public void menu() {
        System.out.println("----------------------------------");
        System.out.println("* * * Menu Library * * *");
        int item;
        do {
            System.out.println("1.Borrowing book");
            System.out.println("2.Return books");
            System.out.println("3.List All Book");
            System.out.println("4.List of my borrowed books");
            System.out.println("5.Back");
            System.out.print("please choice a item :");
            item = input.nextInt();
        } while (item > 5 || item < 1);
        switch (item) {
            case 1 -> borrowingBook();
            case 2 -> returnBook();
            case 3 -> listAllBooks();
            case 4 -> ListMyBorrowedBook();
            default -> new Main();
        }
        menu();
    }

    public void ListMyBorrowedBook() {
        System.out.println("----------------------------------");
        System.out.println("* * * List Of My Borrowed Books * * *");
        int counter = 0, i = 1;
        for (BorrowedBook b : DataBase.borrowedBooks) {
            if (b.getStudentNumber().equals(student.getStdNumber())){
                Book book = DataBase.getBook(b.getCodeBook());
                if (book!=null)
                System.out.println((i + 1) + ". " + book.getTitle());
            }
            counter++;
        }
        if (counter == 0)
            System.out.println("Your borrowed book list is empty");
    }

    public void listAllBooks() {
        System.out.println("----------------------------------");
        System.out.println("* * * List All Books * * *");
        int i = 1;
        for (Book b : DataBase.books) {
            System.out.println((i++) + ". " + b);
        }
    }

    public void returnBook() {
        System.out.println("----------------------------------");
        System.out.println("* * * Return Book  * * *");
        Book book;
        while (true) {
            System.out.print("Enter code book for return : ");
            int code = input.nextInt();
            book = DataBase.getBook(code);
            if (book == null) {
                System.out.println("There is no book with this code.");
                System.out.print("enter y try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            }else {
                BorrowedBook borrowedBook = DataBase.getBorrowedBook(book.getCode());
                if (borrowedBook == null || !borrowedBook.getStudentNumber().equals(student.getStdNumber()))
                    System.out.println("This book is not available in your borrowed books list.");
                else {
                    DataBase.borrowedBooks.remove(borrowedBook);
                    book.setBorrowed(false);
                    System.out.println("book returned successfully");
                    break;
                }
            }
        }
    }

    public void borrowingBook() {
        System.out.println("----------------------------------");
        System.out.println("* * * Borrowing Book * * *");
        System.out.println("Menu Books : ");
        int i = 1;
        for (Book b : DataBase.books) {
            System.out.println((i + 1) + ". " + b);
        }
        Book book;
        while (true) {
            System.out.print("Enter code book for borrowing : ");
            int code = input.nextInt();
            book = DataBase.getBook(code);
            if (book == null) {
                System.out.println("There is no book with this code.");
                System.out.print("enter y try again : ");
                char ch = input.next().charAt(0);
                input.nextLine();
                if (ch != 'y')
                    menu();
            }else {
                if (book.isBorrowed()){
                    System.out.println("The desired book has been borrowed.");
                } else {
                    DataBase.borrowedBooks.add(new BorrowedBook(student.getStdNumber(),book.getCode()));
                    book.setBorrowed(true);
                    System.out.println("book borrowed successfully");
                    break;
                }
            }
        }
    }
}
