package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private static int nbBooks = 0;
    private List<String> authors = new ArrayList<>();

    public Book(){
        this.id = ++nbBooks;
    }

    public Book(String title, String category, float cost){
        super(title, category, cost);
        this.id = ++nbBooks;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if (this.authors.contains(authorName)){
            System.out.println("This author is already in");
            return;
        }
        this.authors.add(authorName);
        System.out.println("Added author successfully");
    }

    public void removeAuthor(String authorName){
        if (this.authors.contains(authorName)){
            System.out.println("Removed author successfully");
            this.authors.remove(authorName);
        } else {
            System.out.println("The author is not present");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }
}
