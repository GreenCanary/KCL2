package com.mike.kcl2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class PitanieController {
    @FXML
    private Label label_s_KCl_p;

    public void setSolidKClPercentage(double value) {
        label_s_KCl_p.setText(value + " %");
    }
    public void MenuInputPopOut(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PopOutInput.fxml"));
            Parent root = fxmlLoader.load();

            // Get the current stage, this will work for various event sources
            Stage currentStage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();

            // Replace the scene in the current window
            currentStage.setScene(new Scene(root));
            currentStage.setTitle("Ввод данных");
            currentStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
