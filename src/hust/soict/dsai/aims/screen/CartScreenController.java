package hust.soict.dsai.aims.screen;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class CartScreenController {
    private Cart cart;

    private Frame storeScreen;
    private Frame currentScreen;
    private Frame addBookScreen;
    private Frame addCDScreen;
    private Frame addDVDScreen;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, String> colMediaCost;

    @FXML
    void onClickPlayBtn(ActionEvent event){
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable){
            try {
                ((Playable) selectedMedia).play();
            } catch (PlayerException exception){
                exception.printStackTrace();
            }
        }
    }

    public CartScreenController(Cart cart){
        super();
        this.cart = cart;
        for (Frame frame : Frame.getFrames()){
            if (frame.getTitle().equals("Add Book Screen"))
                addBookScreen = frame;
            else if (frame.getTitle().equals("Add CD Screen"))
                addCDScreen = frame;
            else if (frame.getTitle().equals("Add DVD Screen"))
                addDVDScreen = frame;
            else if (frame.getTitle().equals("Store"))
                storeScreen = frame;
            else if (frame.getTitle().equals("Cart"))
                currentScreen = frame;
        }
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title")
        );
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, String>("cost")
        );
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        tblMedia.getItems().addListener(
                new ListChangeListener<Media>() {
                    @Override
                    public void onChanged(Change<? extends Media> change) {
                        updateTotalCost();
                    }
                }
        );
    }

    void updateTotalCost(){
        Platform.runLater(
                new Runnable() {
                    @Override
                    public void run() {
                        totalCostLabel.setText(String.format("%.2f", cart.totalCost())+ " $");
                    }
                }
        );
    }

    void showFilteredMedia(String string){
        if (radioBtnFilterId.isSelected()){
            tblMedia.setItems(this.cart.searchCart(Integer.parseInt(string)));
        } else if (radioBtnFilterTitle.isSelected()){
            tblMedia.setItems(this.cart.searchCart(string));
        }
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void onPlaceOrder(ActionEvent event){
        JOptionPane.showMessageDialog(null, "An Order is created", "Cart", JOptionPane.INFORMATION_MESSAGE);
        cart.emptyCart();
    }

    @FXML
    private Label totalCostLabel;

    @FXML
    void onClickAddBook(){
        currentScreen.setVisible(false);
        addBookScreen.setVisible(true);
    }

    @FXML
    void onClickAddCD(){
        currentScreen.setVisible(false);
        addCDScreen.setVisible(true);
    }

    @FXML
    void onClickAddDVD(){
        currentScreen.setVisible(false);
        addDVDScreen.setVisible(true);
    }

    @FXML
    void onClickViewStore(){
        currentScreen.setVisible(false);
        storeScreen.setVisible(true);
    }

    @FXML
    void onClickViewCart(){
        //do nothing
    }
}
