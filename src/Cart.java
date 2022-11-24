

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("This order is full!");
        } else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Disc " + disc.getTitle() + " has been added.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (int i = 0; i < dvdList.length; ++i) {
            addDigitalVideoDisc(dvdList[i]);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int check = 0, index = 0;
        if (this.qtyOrdered == 0) {
            System.out.println("Your cart is empty! Nothing to delete.");
        } else {
            for (int i = 0; i < this.qtyOrdered; ++i) {
                if (itemsOrdered[i] == disc) {
                    index = i;
                    check = 1;
                    break;
                }
            }

            if (check == 0) {
                System.out.println("The item you want to delete is not found!");
            } else {
                for (int i = index; i < this.qtyOrdered; ++i) {
                    itemsOrdered[i] = itemsOrdered[i + 1];
                }
                qtyOrdered--;
                System.out.println("Disc " + disc.getTitle() + " has been delete.");
            }
        }
    }

    public float totalCost() {
        float total = 0.0f;
        if (this.qtyOrdered == 0) {
            System.out.println("Your cart is empty!");
        } else {
            for (int i = 0; i < this.qtyOrdered; ++i) {
                total += itemsOrdered[i].getCost();
            }
        }
        return total;
    }

    public void sortDVDByTitle() {
        for (int i = 0; i < this.qtyOrdered; ++i) {
            String a = itemsOrdered[i].getTitle();
            for (int j = i + 1; j < this.qtyOrdered; ++j) {
                String b = itemsOrdered[j].getTitle();
                int compareValue = a.compareTo(b);
                if (compareValue > 0) {
                    DigitalVideoDisc temp = itemsOrdered[i];
                    itemsOrdered[i] = itemsOrdered[j];
                    itemsOrdered[j] = temp;
                } else if (compareValue == 0) {
                    if (itemsOrdered[j].getCost() > itemsOrdered[i].getCost()) {
                        DigitalVideoDisc temp = itemsOrdered[i];
                        itemsOrdered[i] = itemsOrdered[j];
                        itemsOrdered[j] = temp;
                    }
                }
            }
        }
    }

    public void sortDVDByCost() {
        for (int i = 0; i < this.qtyOrdered; ++i) {
            for (int j = i + 1; j < this.qtyOrdered; ++j) {
                float costI = itemsOrdered[i].getCost();
                float costJ = itemsOrdered[j].getCost();
                if (costJ > costI) {
                    DigitalVideoDisc temp = itemsOrdered[i];
                    itemsOrdered[i] = itemsOrdered[j];
                    itemsOrdered[j] = temp;
                } else if (costI == costJ) {
                    String a = itemsOrdered[i].getTitle();
                    String b = itemsOrdered[j].getTitle();
                    int compareValue = a.compareTo(b);
                    if (compareValue > 0) {
                        DigitalVideoDisc temp = itemsOrdered[i];
                        itemsOrdered[i] = itemsOrdered[j];
                        itemsOrdered[j] = temp;
                    }
                }
            }
        }
    }

    public void filterDVDID() {

    }

    public void filterDVDTitle() {

    }
}
