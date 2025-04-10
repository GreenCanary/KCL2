package com.mike.kcl2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class PitanieController {
    @FXML private Label label_s_KCl_p;
    @FXML private Label label_s_NaCl_p;
    @FXML private Label label_s_CaSO4_p;
    @FXML private Label label_s_Check_p;
    @FXML private Label label_s_KCl_v;
    @FXML private Label label_s_NaCl_v;
    @FXML private Label label_s_CaSO4_v;
    @FXML private Label label_s_Check_v;
    @FXML private Label label_l_KCl_p;
    @FXML private Label label_l_NaCl_p;
    @FXML private Label label_l_CaSO4_p;
    @FXML private Label label_l_Check_p;
    @FXML private Label label_l_KCl_v;
    @FXML private Label label_l_NaCl_v;
    @FXML private Label label_l_CaSO4_v;
    @FXML private Label label_l_Check_v;
    @FXML private Label label_H2O_p;
    @FXML private Label label_H2O_v;

    @FXML private Label label_s_KCl_p2;
    @FXML private Label label_s_NaCl_p2;
    @FXML private Label label_s_CaSO4_p2;
    @FXML private Label label_s_Check_p2;
    @FXML private Label label_s_KCl_v2;
    @FXML private Label label_s_NaCl_v2;
    @FXML private Label label_s_CaSO4_v2;
    @FXML private Label label_s_Check_v2;
    @FXML private Label label_l_KCl_p2;
    @FXML private Label label_l_NaCl_p2;
    @FXML private Label label_l_CaSO4_p2;
    @FXML private Label label_l_Check_p2;
    @FXML private Label label_l_KCl_v2;
    @FXML private Label label_l_NaCl_v2;
    @FXML private Label label_l_CaSO4_v2;
    @FXML private Label label_l_Check_v2;
    @FXML private Label label_H2O_p2;
    @FXML private Label label_H2O_v2;
    private Material floto;  // Declare floto object
    private Material filtrat;
    // Add a setter method for floto
    public void setFloto(Material floto) {
        this.floto = floto;
    }
    public void setFiltrat(Material filtrat) {
        this.filtrat = filtrat;
    }


    public void setLabelPrecentage(Label label, double value) {
        label.setText(value + " %");
    }
    public void setLabelValue(Label label, double value) {
        label.setText(value+ "");
    }
    public void updateAllLabels() {
        setLabelPrecentage(label_s_KCl_p, floto.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p, floto.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p, floto.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p, floto.getS_Check_p());

        setLabelValue(label_s_KCl_v, floto.getS_KCl_v());
        setLabelValue(label_s_NaCl_v, floto.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v, floto.getS_CaSO4_v());
        setLabelValue(label_s_Check_v, floto.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p, floto.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p, floto.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p, floto.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p, floto.getL_Check_p());
        setLabelPrecentage(label_H2O_p, floto.getH2O_p());


        setLabelValue(label_l_KCl_v, floto.getL_KCl_v());
        setLabelValue(label_l_NaCl_v, floto.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v, floto.getL_CaSO4_v());
        setLabelValue(label_l_Check_v, floto.getL_Check_v());
        setLabelPrecentage(label_H2O_v, floto.getH2O_v());




        setLabelPrecentage(label_s_KCl_p2, filtrat.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p2, filtrat.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p2, filtrat.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p2, filtrat.getS_Check_p());

        setLabelValue(label_s_KCl_v2, filtrat.getS_KCl_v());
        setLabelValue(label_s_NaCl_v2, filtrat.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v2, filtrat.getS_CaSO4_v());
        setLabelValue(label_s_Check_v2, filtrat.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p2, filtrat.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p2, filtrat.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p2, filtrat.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p2, filtrat.getL_Check_p());
        setLabelPrecentage(label_H2O_p2, filtrat.getH2O_p());

        setLabelValue(label_l_KCl_v2, filtrat.getL_KCl_v());
        setLabelValue(label_l_NaCl_v2, filtrat.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v2, filtrat.getL_CaSO4_v());
        setLabelValue(label_l_Check_v2, filtrat.getL_Check_v());
        setLabelPrecentage(label_H2O_v2, filtrat.getH2O_v());
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
