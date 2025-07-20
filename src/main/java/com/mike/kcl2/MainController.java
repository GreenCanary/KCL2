package com.mike.kcl2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;

public class MainController {

    @FXML private Label label_res_temp;
    @FXML private Label label_res_plot;
    //Flato
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

    // Filtrat
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

    //Posle vish
    @FXML private Label label_s_KCl_p3;
    @FXML private Label label_s_NaCl_p3;
    @FXML private Label label_s_CaSO4_p3;
    @FXML private Label label_s_Check_p3;
    @FXML private Label label_s_KCl_v3;
    @FXML private Label label_s_NaCl_v3;
    @FXML private Label label_s_CaSO4_v3;
    @FXML private Label label_s_Check_v3;

    @FXML private Label label_l_KCl_p3;
    @FXML private Label label_l_NaCl_p3;
    @FXML private Label label_l_CaSO4_p3;
    @FXML private Label label_l_Check_p3;
    @FXML private Label label_l_KCl_v3;
    @FXML private Label label_l_NaCl_v3;
    @FXML private Label label_l_CaSO4_v3;
    @FXML private Label label_l_Check_v3;
    @FXML private Label label_H2O_p3;
    @FXML private Label label_H2O_v3;

    //Penniy
    @FXML private Label label_s_KCl_p4;
    @FXML private Label label_s_NaCl_p4;
    @FXML private Label label_s_CaSO4_p4;
    @FXML private Label label_s_Check_p4;
    @FXML private Label label_s_KCl_v4;
    @FXML private Label label_s_NaCl_v4;
    @FXML private Label label_s_CaSO4_v4;
    @FXML private Label label_s_Check_v4;

    @FXML private Label label_l_KCl_p4;
    @FXML private Label label_l_NaCl_p4;
    @FXML private Label label_l_CaSO4_p4;
    @FXML private Label label_l_Check_p4;
    @FXML private Label label_l_KCl_v4;
    @FXML private Label label_l_NaCl_v4;
    @FXML private Label label_l_CaSO4_v4;
    @FXML private Label label_l_Check_v4;
    @FXML private Label label_H2O_p4;
    @FXML private Label label_H2O_v4;

    @FXML private Label extractionLabel;



    //floto
    @FXML private PieChart PieChart;


    private Material floto;  // Declare floto object
    private Material redWater;
    private Material posleVish;

    private Material result;


    // Add a setter method for floto


    public void setLabelPrecentage(Label label, double value) {
        String formattedValue = String.format("%.2f %%", value); // Multiply by 100 for percentage
        label.setText(formattedValue);
    }
    public void setLabelValue(Label label, double value) {
        label.setText(value+ "");
    }
    public void updateAllLabels() {
        setLabelValue(label_s_KCl_v, floto.getS_KCl_v());

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
        setLabelValue(label_H2O_v, floto.getH2O_v());


        setLabelPrecentage(label_s_KCl_p2, redWater.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p2, redWater.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p2, redWater.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p2, redWater.getS_Check_p());

        setLabelValue(label_s_KCl_v2, redWater.getS_KCl_v());
        setLabelValue(label_s_NaCl_v2, redWater.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v2, redWater.getS_CaSO4_v());
        setLabelValue(label_s_Check_v2, redWater.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p2, redWater.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p2, redWater.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p2, redWater.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p2, redWater.getL_Check_p());
        setLabelPrecentage(label_H2O_p2, redWater.getH2O_p());

        setLabelValue(label_l_KCl_v2, redWater.getL_KCl_v());
        setLabelValue(label_l_NaCl_v2, redWater.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v2, redWater.getL_CaSO4_v());
        setLabelValue(label_l_Check_v2, redWater.getL_Check_v());
        setLabelValue(label_H2O_v2, redWater.getH2O_v());


        setLabelPrecentage(label_s_KCl_p3, posleVish.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p3, posleVish.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p3, posleVish.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p3, posleVish.getS_Check_p());

        setLabelValue(label_s_KCl_v3, posleVish.getS_KCl_v());
        setLabelValue(label_s_NaCl_v3, posleVish.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v3, posleVish.getS_CaSO4_v());
        setLabelValue(label_s_Check_v3, posleVish.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p3, posleVish.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p3, posleVish.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p3, posleVish.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p3, posleVish.getL_Check_p());
        setLabelPrecentage(label_H2O_p3, posleVish.getH2O_p());

        setLabelValue(label_l_KCl_v3, posleVish.getL_KCl_v());
        setLabelValue(label_l_NaCl_v3, posleVish.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v3, posleVish.getL_CaSO4_v());
        setLabelValue(label_l_Check_v3, posleVish.getL_Check_v());
        setLabelValue(label_H2O_v3, posleVish.getH2O_v());

        //result
        setLabelPrecentage(label_s_KCl_p4, result.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p4, result.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p4, result.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p4, result.getS_Check_p());

        setLabelValue(label_s_KCl_v4, result.getS_KCl_v());
        setLabelValue(label_s_NaCl_v4, result.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v4, result.getS_CaSO4_v());
        setLabelValue(label_s_Check_v4, result.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p4, result.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p4, result.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p4, result.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p4, result.getL_Check_p());
        setLabelPrecentage(label_H2O_p4, result.getH2O_p());

        setLabelValue(label_l_KCl_v4, result.getL_KCl_v());
        setLabelValue(label_l_NaCl_v4, result.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v4, result.getL_CaSO4_v());
        setLabelValue(label_l_Check_v4, result.getL_Check_v());
        setLabelValue(label_H2O_v4, result.getH2O_v());


//        PieChart.setTitle("Качество сухого продукта");
//        PieChart.setStyle("-fx-font-size: 20px;"); // Affects title & legend
//
//        ObservableList<PieChart.Data> PieChartData = FXCollections.observableArrayList(
//                new PieChart.Data(String.format("KCl - %.2f%%", result.getS_KCl_p()), result.getS_KCl_p()),
//                new PieChart.Data(String.format("NaCl - %.2f%%", result.getS_NaCl_p()), result.getS_NaCl_p()),
//                new PieChart.Data(String.format("CaSO₄ - %.2f%%", result.getS_CaSO4_p()), result.getS_CaSO4_p())
//        );
//        PieChart.setData(PieChartData);
//
//// Apply CSS to increase label font size (after data is set)
//        PieChart.lookupAll(".chart-pie-label").forEach(node ->
//                node.setStyle("-fx-font-size: 20px;") // Adjust size as needed
//        );





    }

    public void MenuInputPopOut(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/mike/kcl2/PopOutInput.fxml")); // Adjust if needed
            Parent root = fxmlLoader.load();


            InputController controller = fxmlLoader.getController();
            Application.getRootContainer().getChildren().setAll(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFloto(Material floto) {
        this.floto = floto;
    }
    public void setPosleVish(Material posleVish) {
        this.posleVish = posleVish;
    }


    public void setRedWater(Material redWater) {
        this.redWater = redWater;
    }

    public void setResult(Material result) {
        this.result = result;
    }
}
