package hust.soict.dsai.aims.media;

public class Disc  extends Media {

    protected String diretor;
    protected int length;

    public int getLength(){
        return length;
    }
    public String getDiretor(){
        return diretor;
    }

    public Disc(){

    }


    public Disc(int length) {
        this.length = length;
    }

    public Disc(String diretor) {
        this.diretor = diretor;
    }

    public Disc(int length, String diretor) {
        this.diretor = diretor;
        this.length = length;
    }
}
