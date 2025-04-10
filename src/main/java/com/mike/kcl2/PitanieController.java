package com.mike.kcl2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PitanieController {
    @FXML
    private Label label_s_KCl_p;

    public void setSolidKClPercentage(double value) {
        label_s_KCl_p.setText(value + " %");
    }
    public void MenuInputPopOut(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PopOutInput.fxml")); // your pop-up FXML
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Ввод данных");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
