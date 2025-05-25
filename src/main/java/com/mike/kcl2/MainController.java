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

    //obezvosh
    @FXML private Label label_s_KCl_p5;
    @FXML private Label label_s_NaCl_p5;
    @FXML private Label label_s_CaSO4_p5;
    @FXML private Label label_s_Check_p5;
    @FXML private Label label_s_KCl_v5;
    @FXML private Label label_s_NaCl_v5;
    @FXML private Label label_s_CaSO4_v5;
    @FXML private Label label_s_Check_v5;

    @FXML private Label label_l_KCl_p5;
    @FXML private Label label_l_NaCl_p5;
    @FXML private Label label_l_CaSO4_p5;
    @FXML private Label label_l_Check_p5;
    @FXML private Label label_l_KCl_v5;
    @FXML private Label label_l_NaCl_v5;
    @FXML private Label label_l_CaSO4_v5;
    @FXML private Label label_l_Check_v5;
    @FXML private Label label_H2O_p5;
    @FXML private Label label_H2O_v5;
    //Peski
    @FXML private Label label_s_KCl_p6;
    @FXML private Label label_s_NaCl_p6;
    @FXML private Label label_s_CaSO4_p6;
    @FXML private Label label_s_Check_p6;
    @FXML private Label label_s_KCl_v6;
    @FXML private Label label_s_NaCl_v6;
    @FXML private Label label_s_CaSO4_v6;
    @FXML private Label label_s_Check_v6;

    @FXML private Label label_l_KCl_p6;
    @FXML private Label label_l_NaCl_p6;
    @FXML private Label label_l_CaSO4_p6;
    @FXML private Label label_l_Check_p6;
    @FXML private Label label_l_KCl_v6;
    @FXML private Label label_l_NaCl_v6;
    @FXML private Label label_l_CaSO4_v6;
    @FXML private Label label_l_Check_v6;
    @FXML private Label label_H2O_p6;
    @FXML private Label label_H2O_v6;



    //Slivi
    @FXML private Label label_s_KCl_p7;
    @FXML private Label label_s_NaCl_p7;
    @FXML private Label label_s_CaSO4_p7;
    @FXML private Label label_s_Check_p7;
    @FXML private Label label_s_KCl_v7;
    @FXML private Label label_s_NaCl_v7;
    @FXML private Label label_s_CaSO4_v7;
    @FXML private Label label_s_Check_v7;

    @FXML private Label label_l_KCl_p7;
    @FXML private Label label_l_NaCl_p7;
    @FXML private Label label_l_CaSO4_p7;
    @FXML private Label label_l_Check_p7;
    @FXML private Label label_l_KCl_v7;
    @FXML private Label label_l_NaCl_v7;
    @FXML private Label label_l_CaSO4_v7;
    @FXML private Label label_l_Check_v7;
    @FXML private Label label_H2O_p7;
    @FXML private Label label_H2O_v7;

    //RedWater
    @FXML private Label label_s_KCl_p8;
    @FXML private Label label_s_NaCl_p8;
    @FXML private Label label_s_CaSO4_p8;
    @FXML private Label label_s_Check_p8;
    @FXML private Label label_s_KCl_v8;
    @FXML private Label label_s_NaCl_v8;
    @FXML private Label label_s_CaSO4_v8;
    @FXML private Label label_s_Check_v8;

    @FXML private Label label_l_KCl_p8;
    @FXML private Label label_l_NaCl_p8;
    @FXML private Label label_l_CaSO4_p8;
    @FXML private Label label_l_Check_p8;
    @FXML private Label label_l_KCl_v8;
    @FXML private Label label_l_NaCl_v8;
    @FXML private Label label_l_CaSO4_v8;
    @FXML private Label label_l_Check_v8;
    @FXML private Label label_H2O_p8;
    @FXML private Label label_H2O_v8;



    //PitanieC
    @FXML private Label label_s_KCl_p9;
    @FXML private Label label_s_NaCl_p9;
    @FXML private Label label_s_CaSO4_p9;
    @FXML private Label label_s_Check_p9;
    @FXML private Label label_s_KCl_v9;
    @FXML private Label label_s_NaCl_v9;
    @FXML private Label label_s_CaSO4_v9;
    @FXML private Label label_s_Check_v9;

    @FXML private Label label_l_KCl_p9;
    @FXML private Label label_l_NaCl_p9;
    @FXML private Label label_l_CaSO4_p9;
    @FXML private Label label_l_Check_p9;
    @FXML private Label label_l_KCl_v9;
    @FXML private Label label_l_NaCl_v9;
    @FXML private Label label_l_CaSO4_v9;
    @FXML private Label label_l_Check_v9;
    @FXML private Label label_H2O_p9;
    @FXML private Label label_H2O_v9;

    //Kek
    @FXML private Label label_s_KCl_p10;
    @FXML private Label label_s_NaCl_p10;
    @FXML private Label label_s_CaSO4_p10;
    @FXML private Label label_s_Check_p10;
    @FXML private Label label_s_KCl_v10;
    @FXML private Label label_s_NaCl_v10;
    @FXML private Label label_s_CaSO4_v10;
    @FXML private Label label_s_Check_v10;

    @FXML private Label label_l_KCl_p10;
    @FXML private Label label_l_NaCl_p10;
    @FXML private Label label_l_CaSO4_p10;
    @FXML private Label label_l_Check_p10;
    @FXML private Label label_l_KCl_v10;
    @FXML private Label label_l_NaCl_v10;
    @FXML private Label label_l_CaSO4_v10;
    @FXML private Label label_l_Check_v10;
    @FXML private Label label_H2O_p10;
    @FXML private Label label_H2O_v10;


    //Fugat
    @FXML private Label label_s_KCl_p11;
    @FXML private Label label_s_NaCl_p11;
    @FXML private Label label_s_CaSO4_p11;
    @FXML private Label label_s_Check_p11;
    @FXML private Label label_s_KCl_v11;
    @FXML private Label label_s_NaCl_v11;
    @FXML private Label label_s_CaSO4_v11;
    @FXML private Label label_s_Check_v11;

    @FXML private Label label_l_KCl_p11;
    @FXML private Label label_l_NaCl_p11;
    @FXML private Label label_l_CaSO4_p11;
    @FXML private Label label_l_Check_p11;
    @FXML private Label label_l_KCl_v11;
    @FXML private Label label_l_NaCl_v11;
    @FXML private Label label_l_CaSO4_v11;
    @FXML private Label label_l_Check_v11;
    @FXML private Label label_H2O_p11;
    @FXML private Label label_H2O_v11;

    //Result
    @FXML private Label label_s_KCl_p12;
    @FXML private Label label_s_NaCl_p12;
    @FXML private Label label_s_CaSO4_p12;
    @FXML private Label label_s_Check_p12;
    @FXML private Label label_s_KCl_v12;
    @FXML private Label label_s_NaCl_v12;
    @FXML private Label label_s_CaSO4_v12;
    @FXML private Label label_s_Check_v12;

    @FXML private Label label_l_KCl_p12;
    @FXML private Label label_l_NaCl_p12;
    @FXML private Label label_l_CaSO4_p12;
    @FXML private Label label_l_Check_p12;
    @FXML private Label label_l_KCl_v12;
    @FXML private Label label_l_NaCl_v12;
    @FXML private Label label_l_CaSO4_v12;
    @FXML private Label label_l_Check_v12;
    @FXML private Label label_H2O_p12;
    @FXML private Label label_H2O_v12;

    @FXML private Label extractionLabel;
    @FXML private Label moistLabel;


    //floto
    @FXML private PieChart PieChart;


    private Material floto;  // Declare floto object
    private Material filtrat;
    private Material posleVish;
    private Material penniy;
    private Material obezvozhivanie;
    private Material peski;
    private Material slivi;
    private Material redWater;
    private Material pitanieC;
    private Material kek;
    private Material fugat;
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


        setLabelPrecentage(label_s_KCl_p5, obezvozhivanie.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p5, obezvozhivanie.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p5, obezvozhivanie.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p5, obezvozhivanie.getS_Check_p());

        setLabelValue(label_s_KCl_v5, obezvozhivanie.getS_KCl_v());
        setLabelValue(label_s_NaCl_v5, obezvozhivanie.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v5, obezvozhivanie.getS_CaSO4_v());
        setLabelValue(label_s_Check_v5, obezvozhivanie.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p5, obezvozhivanie.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p5, obezvozhivanie.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p5, obezvozhivanie.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p5, obezvozhivanie.getL_Check_p());
        setLabelPrecentage(label_H2O_p5, obezvozhivanie.getH2O_p());

        setLabelValue(label_l_KCl_v5, obezvozhivanie.getL_KCl_v());
        setLabelValue(label_l_NaCl_v5, obezvozhivanie.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v5, obezvozhivanie.getL_CaSO4_v());
        setLabelValue(label_l_Check_v5, obezvozhivanie.getL_Check_v());
        setLabelValue(label_H2O_v5, obezvozhivanie.getH2O_v());


        setLabelPrecentage(label_s_KCl_p6, peski.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p6, peski.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p6, peski.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p6, peski.getS_Check_p());

        setLabelValue(label_s_KCl_v6, peski.getS_KCl_v());
        setLabelValue(label_s_NaCl_v6, peski.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v6, peski.getS_CaSO4_v());
        setLabelValue(label_s_Check_v6, peski.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p6, peski.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p6, peski.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p6, peski.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p6, peski.getL_Check_p());
        setLabelPrecentage(label_H2O_p6, peski.getH2O_p());

        setLabelValue(label_l_KCl_v6, peski.getL_KCl_v());
        setLabelValue(label_l_NaCl_v6, peski.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v6, peski.getL_CaSO4_v());
        setLabelValue(label_l_Check_v6, peski.getL_Check_v());
        setLabelValue(label_H2O_v6, peski.getH2O_v());


        setLabelPrecentage(label_s_KCl_p7, slivi.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p7, slivi.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p7, slivi.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p7, slivi.getS_Check_p());

        setLabelValue(label_s_KCl_v7, slivi.getS_KCl_v());
        setLabelValue(label_s_NaCl_v7, slivi.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v7, slivi.getS_CaSO4_v());
        setLabelValue(label_s_Check_v7, slivi.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p7, slivi.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p7, slivi.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p7, slivi.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p7, slivi.getL_Check_p());
        setLabelPrecentage(label_H2O_p7, slivi.getH2O_p());

        setLabelValue(label_l_KCl_v7, slivi.getL_KCl_v());
        setLabelValue(label_l_NaCl_v7, slivi.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v7, slivi.getL_CaSO4_v());
        setLabelValue(label_l_Check_v7, slivi.getL_Check_v());
        setLabelValue(label_H2O_v7, slivi.getH2O_v());


        setLabelPrecentage(label_s_KCl_p8, redWater.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p8, redWater.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p8, redWater.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p8, redWater.getS_Check_p());

        setLabelValue(label_s_KCl_v8, redWater.getS_KCl_v());
        setLabelValue(label_s_NaCl_v8, redWater.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v8, redWater.getS_CaSO4_v());
        setLabelValue(label_s_Check_v8, redWater.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p8, redWater.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p8, redWater.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p8, redWater.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p8, redWater.getL_Check_p());
        setLabelPrecentage(label_H2O_p8, redWater.getH2O_p());

        setLabelValue(label_l_KCl_v8, redWater.getL_KCl_v());
        setLabelValue(label_l_NaCl_v8, redWater.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v8, redWater.getL_CaSO4_v());
        setLabelValue(label_l_Check_v8, redWater.getL_Check_v());
        setLabelValue(label_H2O_v8, redWater.getH2O_v());


        //pitanieC
        setLabelPrecentage(label_s_KCl_p9, pitanieC.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p9, pitanieC.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p9, pitanieC.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p9, pitanieC.getS_Check_p());

        setLabelValue(label_s_KCl_v9, pitanieC.getS_KCl_v());
        setLabelValue(label_s_NaCl_v9, pitanieC.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v9, pitanieC.getS_CaSO4_v());
        setLabelValue(label_s_Check_v9, pitanieC.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p9, pitanieC.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p9, pitanieC.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p9, pitanieC.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p9, pitanieC.getL_Check_p());
        setLabelPrecentage(label_H2O_p9, pitanieC.getH2O_p());

        setLabelValue(label_l_KCl_v9, pitanieC.getL_KCl_v());
        setLabelValue(label_l_NaCl_v9, pitanieC.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v9, pitanieC.getL_CaSO4_v());
        setLabelValue(label_l_Check_v9, pitanieC.getL_Check_v());
        setLabelValue(label_H2O_v9, pitanieC.getH2O_v());


        //kek
        setLabelPrecentage(label_s_KCl_p10, kek.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p10, kek.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p10, kek.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p10, kek.getS_Check_p());

        setLabelValue(label_s_KCl_v10, kek.getS_KCl_v());
        setLabelValue(label_s_NaCl_v10, kek.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v10, kek.getS_CaSO4_v());
        setLabelValue(label_s_Check_v10, kek.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p10, kek.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p10, kek.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p10, kek.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p10, kek.getL_Check_p());
        setLabelPrecentage(label_H2O_p10, kek.getH2O_p());

        setLabelValue(label_l_KCl_v10, kek.getL_KCl_v());
        setLabelValue(label_l_NaCl_v10, kek.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v10, kek.getL_CaSO4_v());
        setLabelValue(label_l_Check_v10, kek.getL_Check_v());
        setLabelValue(label_H2O_v10, kek.getH2O_v());


        //fugat
        setLabelPrecentage(label_s_KCl_p11, fugat.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p11, fugat.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p11, fugat.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p11, fugat.getS_Check_p());

        setLabelValue(label_s_KCl_v11, fugat.getS_KCl_v());
        setLabelValue(label_s_NaCl_v11, fugat.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v11, fugat.getS_CaSO4_v());
        setLabelValue(label_s_Check_v11, fugat.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p11, fugat.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p11, fugat.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p11, fugat.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p11, fugat.getL_Check_p());
        setLabelPrecentage(label_H2O_p11, fugat.getH2O_p());

        setLabelValue(label_l_KCl_v11, fugat.getL_KCl_v());
        setLabelValue(label_l_NaCl_v11, fugat.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v11, fugat.getL_CaSO4_v());
        setLabelValue(label_l_Check_v11, fugat.getL_Check_v());
        setLabelValue(label_H2O_v11, fugat.getH2O_v());


        //result
        setLabelPrecentage(label_s_KCl_p12, result.getS_KCl_p());
        setLabelPrecentage(label_s_NaCl_p12, result.getS_NaCl_p());
        setLabelPrecentage(label_s_CaSO4_p12, result.getS_CaSO4_p());
        setLabelPrecentage(label_s_Check_p12, result.getS_Check_p());

        setLabelValue(label_s_KCl_v12, result.getS_KCl_v());
        setLabelValue(label_s_NaCl_v12, result.getS_NaCl_v());
        setLabelValue(label_s_CaSO4_v12, result.getS_CaSO4_v());
        setLabelValue(label_s_Check_v12, result.getS_Check_v());

        setLabelPrecentage(label_l_KCl_p12, result.getL_KCl_p());
        setLabelPrecentage(label_l_NaCl_p12, result.getL_NaCl_p());
        setLabelPrecentage(label_l_CaSO4_p12, result.getL_CaSO4_p());
        setLabelPrecentage(label_l_Check_p12, result.getL_Check_p());
        setLabelPrecentage(label_H2O_p12, result.getH2O_p());

        setLabelValue(label_l_KCl_v12, result.getL_KCl_v());
        setLabelValue(label_l_NaCl_v12, result.getL_NaCl_v());
        setLabelValue(label_l_CaSO4_v12, result.getL_CaSO4_v());
        setLabelValue(label_l_Check_v12, result.getL_Check_v());
        setLabelValue(label_H2O_v12, result.getH2O_v());

        setLabelPrecentage(extractionLabel, (result.getS_KCl_v()/floto.getS_KCl_v() * 100));
        setLabelPrecentage(moistLabel, (kek.getH2O_v()/kek.getS_Check_v()));


        PieChart.setTitle("Качество сухого продукта");
        PieChart.setStyle("-fx-font-size: 20px;"); // Affects title & legend

        ObservableList<PieChart.Data> PieChartData = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", result.getS_KCl_p()), result.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", result.getS_NaCl_p()), result.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", result.getS_CaSO4_p()), result.getS_CaSO4_p())
        );
        PieChart.setData(PieChartData);

// Apply CSS to increase label font size (after data is set)
        PieChart.lookupAll(".chart-pie-label").forEach(node ->
                node.setStyle("-fx-font-size: 20px;") // Adjust size as needed
        );





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

    public void setSlivi(Material slivi) {
        this.slivi = slivi;
    }

    public void setPeski(Material peski) {
        this.peski = peski;
    }

    public void setRedWater(Material redWater) {
        this.redWater = redWater;
    }

    public void setPitanieC(Material pitanieC) {
        this.pitanieC = pitanieC;
    }

    public void setFugat(Material fugat) {
        this.fugat = fugat;
    }

    public void setKek(Material kek) {
        this.kek = kek;
    }

    public void setResult(Material result) {
        this.result = result;
    }
}
