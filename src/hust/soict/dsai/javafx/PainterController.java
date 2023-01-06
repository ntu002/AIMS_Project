package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;

public class PainterController {

    private Color colorToWrite = Color.BLACK;
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void onSwitchToPen(ActionEvent event){
        this.colorToWrite = Color.BLACK;
    }

    @FXML
    void onSwitchToEraser(ActionEvent event){
        this.colorToWrite = Color.WHITE;
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event){
        Circle newCirle = new Circle(
                event.getX(),
                event.getY(),
                4,
                this.colorToWrite
        );
        drawingAreaPane.getChildren().add(newCirle);
    }

    @FXML
    private RadioButton penBtn;

    @FXML
    private RadioButton eraserBtn;
}