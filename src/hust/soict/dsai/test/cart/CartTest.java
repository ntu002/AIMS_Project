package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String args[]){
        //Create a new cart
        Cart anOdered = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The King Lion",
                "Animation","Roger Allers",87, 19.95f);
        anOdered.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction","George Lucas",87, 24.95f);
        anOdered.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","George Lucas", 88, 18.99f);

        anOdered.addDigitalVideoDisc(dvd1);
        anOdered.addDigitalVideoDisc(dvd2);
        anOdered.addDigitalVideoDisc(dvd3);

        anOdered.printCart();


    }
}
