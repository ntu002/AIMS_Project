package hust.soict.dsai.aims.media;

import java.lang.Object;

public class Media {
    private static int nbMedia = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Media(){

    }

    public Media(String title) {
        this.id = nbMedia;
        this.title = title;
        nbMedia++;
    }


    public Media(String title, String category, float cost) {
        this.id = nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
    }

    public static void main (String[] args) {

    }
}
