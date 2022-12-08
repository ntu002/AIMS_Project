package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.Media;

public class Book extends Media {
    public Book(){
        super();
    }

    private List<String> author = new ArrayList<String>();

    public Book(String title, String category, float cost, List<String> author) {
        super(title, category, cost);
        for (String authorName: author) {
            this.author.add(authorName);
        }
    }

    public void addAuthor(String authorName) {
        if (this.author.isEmpty()) {
            System.out.println("Them thanh cong");
            this.author.add(authorName);
        }
         if (this.author.contains(authorName)) {
             System.out.println("Tac gia da co trong danh sach");
         } else {
             System.out.println("Them thanh cong");
             this.author.add(authorName);
         }
    }

    public void removeAuthor(String authorName) {
        if (this.author.isEmpty()) {
            System.out.println("Chua co tac gia nao trong danh sach");
        }

        if (this.author.contains(authorName)) {
            System.out.println("Xoa ten tac gia thanh cong");
            this.author.remove(authorName);
        } else {
            System.out.println("Khong co ten tac gia trong sach.");
        }
    }



//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public float getCost() {
//        return cost;
//    }
//    public void setCost(float cost) {
//        this.cost = cost;
//    }
//
//
//    private static int nbBook = 0;
//    private int id;
//    private String title;
//    private String category;
//    private float cost;
//    private List<String> author = new ArrayList<String>();
//
//    public Book(String title, String category, float cost, List<String> author) {
//        this.id = nbBook;
//        this.title = title;
//        this.category = category;
//        this.cost = cost;
//        for (String authorName: author) {
//            this.author.add(authorName);
//        }
//        nbBook++;
//    }
//
//    public void addAuthor(String authorName) {
//        if (this.author.isEmpty()) {
//            System.out.println("Them thanh cong");
//            this.author.add(authorName);
//        }
//         if (this.author.contains(authorName)) {
//             System.out.println("Tac gia da co trong danh sach");
//         } else {
//             System.out.println("Them thanh cong");
//             this.author.add(authorName);
//         }
//    }
//
//    public void removeAuthor(String authorName) {
//        if (this.author.isEmpty()) {
//            System.out.println("Chua co tac gia nao trong danh sach");
//        }
//
//        if (this.author.contains(authorName)) {
//            System.out.println("Xoa ten tac gia thanh cong");
//            this.author.remove(authorName);
//        } else {
//            System.out.println("Khong co ten tac gia trong sach.");
//        }
//    }

}
