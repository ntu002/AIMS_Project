package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private static int nbCompactDiscs = 0;
    private String artist;
    List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(){
        this.id = ++nbCompactDiscs;
    }

    public CompactDisc(String title, String director, String artist) {
        super(director);
        this.id = ++nbCompactDiscs;
        this.title = title;
        this.artist = artist;
    }



    public CompactDisc(String title, int length, String director, String artist) {
        super(length, director);
        this.title = title;
        this.id = ++nbCompactDiscs;
        this.artist = artist;
    }

    public void addTrack(Track track){
        if (tracks.contains(track)){
            System.out.println("This tracks is already in");
        } else {
            tracks.add(track);
            System.out.println("Added track successfully");
        }
    }

    public void removeTrack(Track track){
        if (tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Removed track successfully");
        } else {
            System.out.println("Track not found");
        }
    }

    public void play(){
        tracks.forEach((track -> {track.play();}));
    }

    public int getLength(){
        int sum = 0;
        for (Track track: tracks){
            sum += track.getLength();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "CompactDisc{" +
                "artist='" + artist + '\'' +
                ", tracks=" + tracks +
                ", length=" + length +
                ", director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }

}
