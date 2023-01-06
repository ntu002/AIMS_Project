package hust.soict.dsai.aims.media;

public class Disc  extends Media {

    protected String director;
    protected int length;

    public int getLength(){

        return length;
    }
    public String getDirector(){
        return director;
    }

    public Disc(){

    }


    public Disc(int length) {

        this.length = length;
    }

    public Disc(String director) {

        this.director = director;
    }

    public Disc(int length, String director) {
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, float cost, int length, String director){
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, float cost, String director){
        super(title, category, cost);
        this.director = director;
    }

}
