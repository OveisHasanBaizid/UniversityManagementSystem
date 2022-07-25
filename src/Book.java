import java.util.Scanner;

public class Book {
    private int code;
    private String title;
    private int numberPage;
    private String author;
    private boolean borrowed;

    public Book(int code, String title, int numberPage, String author, boolean borrowed) {
        this.code = code;
        this.title = title;
        this.numberPage = numberPage;
        this.author = author;
        this.borrowed = borrowed;
    }
    public Book(Scanner input) {
        System.out.print("Code book : ");
        this.code = input.nextInt();
        System.out.print("Title : ");
        this.title = input.nextLine();
        System.out.print("Number Page : ");
        this.numberPage = input.nextInt();
        System.out.print("Author : ");
        this.author = input.nextLine();
        this.borrowed = false;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean loaned) {
        this.borrowed = loaned;
    }

    @Override
    public String toString() {
        return "Code : " + code + "\tTitle : " + title + "\tNumber Page : " + numberPage + "\tAuthor : "
                + author + "\tLoaned : " + borrowed;
    }
}
