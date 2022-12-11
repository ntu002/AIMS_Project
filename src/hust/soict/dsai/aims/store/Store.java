package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();

    public Store() {

    }

    public void addMedia(Media media) {
        if (this.itemsInStore.contains(media)){

        }else {
            this.itemsInStore.add(media);
            System.out.println("Added item into the store successfully");
        }
    }

    public void addMedia(Media ...mediaList) {
        for (Media media : mediaList){
            this.addMedia(media);
        }
    }

    public void removeMedia(Media media) {
        if (this.itemsInStore.contains(media)){
            this.itemsInStore.remove(media);
            System.out.println("Removed item from the store successfully");
        } else {
            System.out.println("Item not found");
        }
    }

    public void printStore(){
        for(Media media : itemsInStore){
            System.out.println(media);
        }
    }

    public Media searchStore(String title){
        for (Media media : itemsInStore){
            if (media.isMatch(title))
                return media;
        }
        return null;
    }

}
