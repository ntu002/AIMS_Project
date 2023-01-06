package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc  extends Disc implements Playable {
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("");
        } else {
            tracks.add(track);
            System.out.println(" ");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("da xoa thanh cong");
        } else {
            System.out.println("chua ton tai");
        }
    }

    public int getLength() {
        int sum = 0;
        for (Track t : tracks) {
            sum += t.getLength();
        }
        return sum;
    }

    public void play() {

    }

}
