package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;

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

    @Override
    public boolean equals(Object obj) {
        return this.title.equals(((Track)obj).getTitle()) && this.length == ((Track)obj).getLength();
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0){
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            JFrame f = new JFrame();
            f.setSize(400, 400);
            JDialog d = new JDialog(f, "Playing disc...");
            d.setLayout(new FlowLayout());
            d.add(new JLabel("Playing DVD: " + this.getTitle()));
            d.add(new JLabel("DVD length: " + this.getLength()));
        }
        else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
