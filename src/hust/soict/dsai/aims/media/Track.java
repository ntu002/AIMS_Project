package hust.soict.dsai.aims.media;

public class Track {

    public Track() {}

    private String title;
    private int length;

    public void Track(String title) {
        this.title = title;
    }

    public void Track(int length) {
        this.length = length;
    }

    public void Track(String title, int length) {
        this.length = length;
        this.title = title;
    }
}
