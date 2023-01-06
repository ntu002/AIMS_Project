package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super();
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(director);
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(length, director);
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc{" +
                "length=" + length +
                ", director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }

    public void play() throws PlayerException{
        if(this.getLength() > 0){
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            JFrame f = new JFrame();
            f.setSize(400,200);
            JDialog d = new JDialog(f, "Playing disc...");

        }
        else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
