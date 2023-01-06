package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
    //private List<Media> itemsInStore = new ArrayList<>();
    private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();

    public Store() {

    }

    public ObservableList<Media> getItemsInStore() {
        return this.itemsInStore;
    }

    public boolean contains(Media media){
        return this.itemsInStore.contains(media);
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
