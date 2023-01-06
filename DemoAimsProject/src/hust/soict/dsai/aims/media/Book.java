package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book() {

    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Da ton tai");
        } else {
            authors.add(authorName);
            System.out.println("them thanh cong");
        }
    }

    public void removeAuthor(String authorName) {
        if(authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Xoa thanh cong");
        } else {
            System.out.println("Tac gia chua co trong");
        }
    }





}
