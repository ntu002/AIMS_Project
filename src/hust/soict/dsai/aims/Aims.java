package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {

    public static Store store = new Store();
    public static Cart cart = new Cart();

    public static boolean hasPlacedOrder = false;

    public static Scanner input = new Scanner(System.in);

    public static void showMenu() {
        while ( !hasPlacedOrder ) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            int command = input.nextInt();
            if (command == 0){
                return;
            } else if(command == 1){
                //display all the items in the store, and a menu as following
                store.printStore();
                storeMenu();
            } else if(command == 2){
//                Add a media or remove a media from the store
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Add a media to the store");
                System.out.println("2. Remove a media from the store");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2");
                command = input.nextInt();
                if(command == 0) { return; }
                else if (command == 1) {
                    System.out.println("Enter the title of the item you want to add: ");
                }
            } else if(command == 3){
                //display the information of the current cart and a menu below
                cart.printCart();
                cartMenu();
            }
        }
    }


    public static void storeMenu() {
        while( !hasPlacedOrder ){
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int command = input.nextInt();
            if (command == 0){
                return;
            } else if(command == 1){
                System.out.println("Enter the title of a media: ");
                String targetTitle = input.next();
                Media foundMedia = store.searchStore(targetTitle);
                if (foundMedia != null){
                    mediaDetailsMenu(foundMedia);
                }else {
                    System.out.println("Media not found");
                }

            } else if(command == 2){
                //Ask the user to enter the title o the media that he/she sees on the screen
                //add the media to cart
                //check the validity of the title
                //after adding a DVD to cart, display the number of DVDs in the currents cart
                System.out.println("Enter the title of a media: ");
                String targetTitle = input.next();
                Media foundMedia = store.searchStore(targetTitle);
                if (foundMedia != null){
                    cart.addMedia(foundMedia);
                    System.out.println("Number of items in current cart: " + cart.getNumberOfItemsOrder());
                } else {
                    System.out.println("Media not found");
                }
            } else if(command == 3){
                //ask the same input from the user as option 2.
                //play
                System.out.println("Enter the title of a media: ");
                String targetTitle = input.next();
                Media foundMedia = store.searchStore(targetTitle);
                if (foundMedia != null){
                    if (foundMedia instanceof CompactDisc){
                        CompactDisc cd = (CompactDisc) foundMedia;
                        cd.play();
                    } else if (foundMedia instanceof DigitalVideoDisc){
                        DigitalVideoDisc dvd = (DigitalVideoDisc) foundMedia;
                        dvd.play();
                    }
                } else {
                    System.out.println("Media not found");
                }
            } else if(command == 4){
                cart.printCart();
                cartMenu();
            }
        }
    }

    public static void mediaDetailsMenu(Media media) {
        while( !hasPlacedOrder ){
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int command = input.nextInt();
            if (command == 0){
                return;
            } else if(command == 1){
                cart.addMedia(media);
            } else if(command == 2) {
                if (media instanceof CompactDisc){
                    CompactDisc cd = (CompactDisc) media;
                    cd.play();
                } else if (media instanceof DigitalVideoDisc){
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    dvd.play();
                }
            }
        }
    }

    public static void cartMenu() {
        while (!hasPlacedOrder) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            int command = input.nextInt();
            if (command == 0){
                return;
            } else if(command == 1){
                System.out.println("Options: ");
                System.out.println("1. Filter by id");
                System.out.println("2. Filter by title");
                System.out.println("0. Back");
                command = input.nextInt();
                if (command == 1){
                    System.out.println("Enter id:");
                    command = input.nextInt();
                    cart.searchCart(command);
                } else if (command == 2) {
                    System.out.println("Enter title:");
                    String targetTitle = input.next();
                    cart.searchCart(targetTitle);
                }
            } else if(command == 2){
                System.out.println("Choose whether to sort by TitleCost or CostTitle");
                System.out.println("1. Sort by TitleCost");
                System.out.println("2. Sort by CostTitle");

                command = input.nextInt();
                if (command == 1){
                    cart.sortByTitleCost();
                } else if (command == 2){
                    cart.sortByCostTitle();
                }
            } else if(command == 3){
                System.out.println("Enter the title of media to remove: ");
                String targetTitle = input.next();
                Media foundMedia = cart.getMedia(targetTitle);
                cart.removeMedia(foundMedia);
            } else if(command == 4){
                System.out.println("Enter the title of media to play: ");
                String targetTitle = input.next();
                Media foundMedia = cart.getMedia(targetTitle);
                if (foundMedia != null){
                    if (foundMedia instanceof CompactDisc){
                        CompactDisc cd = (CompactDisc) foundMedia;
                        cd.play();
                    } else if (foundMedia instanceof DigitalVideoDisc){
                        DigitalVideoDisc dvd = (DigitalVideoDisc) foundMedia;
                        dvd.play();
                    }
                } else {
                    System.out.println("Media not found");
                }
            } else if(command == 5){
                hasPlacedOrder = true;
                cart.emptyCart();
                System.out.println("An order has been created");
            }
        }
    }
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Alllers",
                87,
                19.95f
        );
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                87,
                24.95f
        );
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladin",
                "Animation",
                18.99f
        );
        Book book = new Book(
                "Sun Tzu: Art of War",
                "Strategy",
                14.95f
        );
        CompactDisc cd = new CompactDisc(
                "Vo Tac Thien",
                50,
                "Loc",
                "Loc"
        );
        store.addMedia(dvd1, dvd2, dvd3, book, cd);

        showMenu();
    }
}