package hust.soict.dsai.aims.media;

public class Disc {

    public Disc() {}

    private String diretor;
    private int length;

    public Disc(int length) {
        this.length = length;
    }

    public Disc(String diretor) {
        this.diretor = diretor;
    }

    public Disc(String diretor, int length) {
        this.diretor = diretor;
        this.length = length;
    }
}
