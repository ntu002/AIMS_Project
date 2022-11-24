
public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "Jujutsu Kaisen",
                "Anime",
                "Unknown",
                15,
                100.0f
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Blue Lock",
                "Anime",
                "Unknown",
                50,
                5000.5f
        );

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Spy x Family",
                "Anime",
                "Kazuhiro Furuhashi",
                100,
                1000.5f
        );

        DigitalVideoDisc dvd4 = new DigitalVideoDisc(
                "Transformer",
                "Science Fiction",
                "Michael Bay",
                1000,
                1000.55f
        );

        DigitalVideoDisc [] dvdList = {dvd1, dvd2, dvd3, dvd4};

//        anOrder.addDigitalVideoDisc(dvd1);
//        anOrder.addDigitalVideoDisc(dvd2);
//        anOrder.addDigitalVideoDisc(dvd3);
//        anOrder.addDigitalVideoDisc(dvd4);
        anOrder.addDigitalVideoDisc(dvdList);

        System.out.print("Total cost (full added cart) is: " + anOrder.totalCost() + ".\n");

        anOrder.removeDigitalVideoDisc(dvd4);

        System.out.print("Total cost (after removed dvd4) is: " + anOrder.totalCost() + ".\n");
    }
}