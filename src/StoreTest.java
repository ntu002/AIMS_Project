public class StoreTest {
    public static void main(String args[]){
        Store Pror1 = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The King Lion",
                "Animation","Roger Allers",87, 19.95f);
        Pror1.addStore(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction","George Lucas",87, 24.95f);
        Pror1.addStore(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        Pror1.addStore(dvd3);
        Pror1.showInfo();
        Pror1.removeStore(2);
        Pror1.showInfo();
    }
}
