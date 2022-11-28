package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDisc = 0;
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // getter
    public DigitalVideoDisc(String title) {
        this.id = nbDigitalVideoDisc;
        this.title = title;
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.id = nbDigitalVideoDisc;
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.id = nbDigitalVideoDisc;
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.id = nbDigitalVideoDisc;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc() {

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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    public String toString() {
        return this.id + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

    public boolean isMatch(String title) {
        if (this.title.equals(title)) return true;
        return false;
    }

    public boolean isMatch(int id) {
        if  (this.id == id) return true;
        return false;
    }
}
