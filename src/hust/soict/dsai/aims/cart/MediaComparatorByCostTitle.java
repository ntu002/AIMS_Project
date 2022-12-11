package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media media1, Media media2) {
        int compareInt = Float.compare(media1.getCost(), media2.getCost());
        if (compareInt == 0)
            return String.CASE_INSENSITIVE_ORDER.compare(media1.getTitle(), media2.getTitle());
        else
            return compareInt;
    }
}
