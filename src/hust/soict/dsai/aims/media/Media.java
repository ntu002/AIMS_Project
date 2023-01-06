package hust.soict.dsai.aims.media;

import java.lang.Object;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

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

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Media(){
    }

    public Media(String title, String category, float cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public boolean isMatch(String title) {
        return this.title.equals(title);
    }

    public boolean isMatch(int id) {
        return (this.id == id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media)
            try {
                String title = ((Media) obj).getTitle();
                if (this.isMatch(title))
                    return true;
            } catch (NullPointerException e){
                e.printStackTrace();
            } catch (ClassCastException e){
                e.printStackTrace();
            }
        return false;
    }
}
