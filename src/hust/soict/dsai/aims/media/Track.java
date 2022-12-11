package hust.soict.dsai.aims.media;

public class Track implements Playable  {

    private String title;
    private int length;

    public String getTitle(){
        return title;
    }

    public int getLength(){
        return length;
    }

    public Track() {}

    public void Track(String title, int length) {
        this.length = length;
        this.title = title;
    }
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        return this.title.equals(((Track)obj).getTitle()) && this.length == ((Track)obj).getLength();
    }
}
