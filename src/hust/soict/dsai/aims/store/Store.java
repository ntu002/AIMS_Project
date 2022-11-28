package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<DigitalVideoDisc> itemsInStore = new ArrayList<>();

    public Store() {

    }

    public void addDVD(DigitalVideoDisc disc) {
        this.itemsInStore.add(disc);
        System.out.println("Added item into the store successfully");
    }

    public void removeDVD(DigitalVideoDisc disc) {
        this.itemsInStore.remove(disc);
        System.out.println("Removed item from the store successfully");
    }
}
