package com.mike.kcl2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainController {

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


    //floto
    @FXML private PieChart solidPie1;
    @FXML private PieChart liquidPie1;
    //filtrat
    @FXML private PieChart solidPie2;
    @FXML private PieChart liquidPie2;
    //poslevish
    @FXML private PieChart solidPie3;
    @FXML private PieChart liquidPie3;
    //penniy
    @FXML private PieChart solidPie4;
    @FXML private PieChart liquidPie4;


    private Material floto;  // Declare floto object
    private Material filtrat;
    private Material posleVish;
    private Material penniy;
    private Material obezvozhivanie;

    // Add a setter method for floto
    public void setFloto(Material floto) {
        this.floto = floto;
    }
    public void setFiltrat(Material filtrat) {
        this.filtrat = filtrat;
    }
    public void setPosleVish(Material posleVish) {
        this.posleVish = posleVish;
    }

    public void setPenniy(Material penniy) {
        this.penniy = penniy;
    }
    public void setObezvozhivanie(Material obezvozhivanie) {
        this.obezvozhivanie = obezvozhivanie;
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
        setLabelValue(label_H2O_v, floto.getH2O_v());





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
        setLabelValue(label_H2O_v2, filtrat.getH2O_v());





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




        setLabelPrecentage(label_s_KCl_p4, penniy.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p4, penniy.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p4, penniy.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p4, penniy.getS_Check_p());

        setLabelValue(label_s_KCl_v4, penniy.getS_KCl_v());
        setLabelValue(label_s_NaCl_v4, penniy.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v4, penniy.getS_CaSO4_v());
        setLabelValue(label_s_Check_v4, penniy.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p4, penniy.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p4, penniy.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p4, penniy.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p4, penniy.getL_Check_p());
        setLabelPrecentage(label_H2O_p4, penniy.getH2O_p());

        setLabelValue(label_l_KCl_v4, penniy.getL_KCl_v());
        setLabelValue(label_l_NaCl_v4, penniy.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v4, penniy.getL_CaSO4_v());
        setLabelValue(label_l_Check_v4, penniy.getL_Check_v());
        setLabelValue(label_H2O_v4, penniy.getH2O_v());





        solidPie1.setTitle("Флотоконцетрат (Твердая фаза)");
        solidPie1.setStyle("-fx-font-size: 12px;");
        liquidPie1.setTitle("Флотоконцетрат (Жидкая фаза)");
        liquidPie1.setStyle("-fx-font-size: 12px;");
        ObservableList<PieChart.Data> solidPieChartData1 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", floto.getS_KCl_p()), floto.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", floto.getS_NaCl_p()), floto.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", floto.getS_CaSO4_p()), floto.getS_CaSO4_p())
        );
        solidPie1.setData(solidPieChartData1);

        ObservableList<PieChart.Data> liquidPieChartData1 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", floto.getL_KCl_p()), floto.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", floto.getL_NaCl_p()), floto.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", floto.getL_CaSO4_p()), floto.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", floto.getH2O_p()), floto.getH2O_p())
        );
        liquidPie1.setData(liquidPieChartData1);


        solidPie2.setTitle("Фугат + Фильтрат (Твердая фаза)");
        solidPie2.setStyle("-fx-font-size: 12px;");
        liquidPie2.setTitle("Фугат + Фильтрат (Жидкая фаза)");
        liquidPie2.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData2 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", filtrat.getS_KCl_p()), filtrat.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", filtrat.getS_NaCl_p()), filtrat.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", filtrat.getS_CaSO4_p()), filtrat.getS_CaSO4_p())
        );
        solidPie2.setData(solidPieChartData2);

        ObservableList<PieChart.Data> liquidPieChartData2 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", filtrat.getL_KCl_p()), filtrat.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", filtrat.getL_NaCl_p()), filtrat.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", filtrat.getL_CaSO4_p()), filtrat.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", filtrat.getH2O_p()), filtrat.getH2O_p())
        );
        liquidPie2.setData(liquidPieChartData2);



        solidPie3.setTitle("После выщелачивания (Твердая фаза)");
        solidPie3.setStyle("-fx-font-size: 12px;");
        liquidPie3.setTitle("После выщелачивания (Жидкая фаза)");
        liquidPie3.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData3 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", posleVish.getS_KCl_p()), posleVish.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", posleVish.getS_NaCl_p()), posleVish.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", posleVish.getS_CaSO4_p()), posleVish.getS_CaSO4_p())
        );
        solidPie3.setData(solidPieChartData3);

        ObservableList<PieChart.Data> liquidPieChartData3 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", posleVish.getL_KCl_p()), posleVish.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", posleVish.getL_NaCl_p()), posleVish.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", posleVish.getL_CaSO4_p()), posleVish.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", posleVish.getH2O_p()), posleVish.getH2O_p())
        );
        liquidPie3.setData(liquidPieChartData3);


        solidPie4.setTitle("Пенный продукт (Твердая фаза)");
        solidPie4.setStyle("-fx-font-size: 12px;");
        liquidPie4.setTitle("Пенный продукт (Жидкая фаза)");
        liquidPie4.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData4 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", penniy.getS_KCl_p()), penniy.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", penniy.getS_NaCl_p()), penniy.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", penniy.getS_CaSO4_p()), penniy.getS_CaSO4_p())
        );
        solidPie4.setData(solidPieChartData4);

        ObservableList<PieChart.Data> liquidPieChartData4 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", penniy.getL_KCl_p()), penniy.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", posleVish.getL_NaCl_p()), penniy.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", penniy.getL_CaSO4_p()), penniy.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", penniy.getH2O_p()), penniy.getH2O_p())
        );
        liquidPie4.setData(liquidPieChartData4);

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
