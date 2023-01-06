package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private List<Media> itemOrdered = new ArrayList<Media>();
    public Cart() {

    }

    public void addMedia(Media disc) {
        if (itemOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        } else {
            itemOrdered.add(disc);
            System.out.println("The disc has been added");
        }
    }

    public void addMedia(Media listDisc[]) {
        if(itemOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        } else {
            for (Media i : listDisc) {
                addMedia(i);
            }
        }
    }

//    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
//        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
//            System.out.println("The cart is almost full");
//        } else {
//            addDigitalVideoDisc(dvd1);
//            addDigitalVideoDisc(dvd2);
//        }
//    }

    public void removeMedia(Media disc) {
        if (itemOrdered.isEmpty()) {
            System.out.println("Chua co disc nao");
        } else {
            if (itemOrdered.contains(disc)) {
                System.out.println("The disc has been removed");
                itemOrdered.remove(disc);
            }
        }
    }

    public float totalCost(){
        float sum = 0;
        for(Media i : itemOrdered) {
            sum += i.getCost();
        }
        return sum;
    }

    public void print() {

        for(Media i : itemOrdered) {
            System.out.println(i.toString());
        }
    }


}
