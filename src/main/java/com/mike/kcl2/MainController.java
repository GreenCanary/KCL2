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

    @FXML private Label label_Izvlechenie;

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
    //obesvosh
    @FXML private PieChart solidPie5;
    @FXML private PieChart liquidPie5;
    //Peski
    @FXML private PieChart solidPie6;
    @FXML private PieChart liquidPie6;
    //Slivi
    @FXML private PieChart solidPie7;
    @FXML private PieChart liquidPie7;
    //RedWater
    @FXML private PieChart solidPie8;
    @FXML private PieChart liquidPie8;
    //RedWater
    @FXML private PieChart solidPie9;
    @FXML private PieChart liquidPie9;
    //Kek
    @FXML private PieChart solidPie10;
    @FXML private PieChart liquidPie10;
    //Fugat
    @FXML private PieChart solidPie11;
    @FXML private PieChart liquidPie11;
    //Fugat
    @FXML private PieChart solidPie12;
    @FXML private PieChart liquidPie12;

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

        setLabelValue(label_Izvlechenie, result.getS_KCl_v()/floto.getS_KCl_v());



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
                new PieChart.Data(String.format("NaCl - %.2f%%", penniy.getL_NaCl_p()), penniy.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", penniy.getL_CaSO4_p()), penniy.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", penniy.getH2O_p()), penniy.getH2O_p())
        );
        liquidPie4.setData(liquidPieChartData4);




        solidPie5.setTitle("Обезвоживание (Твердая фаза)");
        solidPie5.setStyle("-fx-font-size: 12px;");
        liquidPie5.setTitle("Обезвоживание (Жидкая фаза)");
        liquidPie5.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData5 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", obezvozhivanie.getS_KCl_p()), obezvozhivanie.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", obezvozhivanie.getS_NaCl_p()), obezvozhivanie.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", obezvozhivanie.getS_CaSO4_p()), obezvozhivanie.getS_CaSO4_p())
        );
        solidPie5.setData(solidPieChartData5);

        ObservableList<PieChart.Data> liquidPieChartData5 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", obezvozhivanie.getL_KCl_p()), obezvozhivanie.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", obezvozhivanie.getL_NaCl_p()), obezvozhivanie.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", obezvozhivanie.getL_CaSO4_p()), obezvozhivanie.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", obezvozhivanie.getH2O_p()), obezvozhivanie.getH2O_p())
        );
        liquidPie5.setData(liquidPieChartData5);

        solidPie6.setTitle("Пески гидроциклонов (Твердая фаза)");
        solidPie6.setStyle("-fx-font-size: 12px;");
        liquidPie6.setTitle("Пески гидроциклонов (Жидкая фаза)");
        liquidPie6.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData6 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", peski.getS_KCl_p()), peski.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", peski.getS_NaCl_p()), peski.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", peski.getS_CaSO4_p()), peski.getS_CaSO4_p())
        );
        solidPie6.setData(solidPieChartData6);

        ObservableList<PieChart.Data> liquidPieChartData6 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", peski.getL_KCl_p()), peski.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", peski.getL_NaCl_p()), peski.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", peski.getL_CaSO4_p()), peski.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", peski.getH2O_p()), peski.getH2O_p())
        );
        liquidPie6.setData(liquidPieChartData6);


        solidPie7.setTitle("Сливы гидроциклонов (Твердая фаза)");
        solidPie7.setStyle("-fx-font-size: 12px;");
        liquidPie7.setTitle("Сливы гидроциклонов (Жидкая фаза)");
        liquidPie7.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData7 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", slivi.getS_KCl_p()), slivi.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", slivi.getS_NaCl_p()), slivi.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", slivi.getS_CaSO4_p()), slivi.getS_CaSO4_p())
        );
        solidPie7.setData(solidPieChartData7);

        ObservableList<PieChart.Data> liquidPieChartData7 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", slivi.getL_KCl_p()), slivi.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", slivi.getL_NaCl_p()), slivi.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", slivi.getL_CaSO4_p()), slivi.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", slivi.getH2O_p()), slivi.getH2O_p())
        );
        liquidPie7.setData(liquidPieChartData7);



        solidPie8.setTitle("Красная вода (Твердая фаза)");
        solidPie8.setStyle("-fx-font-size: 12px;");
        liquidPie8.setTitle("Красная вода (Жидкая фаза)");
        liquidPie8.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData8 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", redWater.getS_KCl_p()), redWater.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", redWater.getS_NaCl_p()), redWater.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", redWater.getS_CaSO4_p()), redWater.getS_CaSO4_p())
        );
        solidPie8.setData(solidPieChartData8);

        ObservableList<PieChart.Data> liquidPieChartData8 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", redWater.getL_KCl_p()), redWater.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", redWater.getL_NaCl_p()), redWater.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", redWater.getL_CaSO4_p()), redWater.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", redWater.getH2O_p()), redWater.getH2O_p())
        );
        liquidPie8.setData(liquidPieChartData8);



        solidPie9.setTitle("Питание центрифуг (Твердая фаза)");
        solidPie9.setStyle("-fx-font-size: 12px;");
        liquidPie9.setTitle("Питание центрифуг (Жидкая фаза)");
        liquidPie9.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData9 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", pitanieC.getS_KCl_p()), pitanieC.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", pitanieC.getS_NaCl_p()), pitanieC.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", pitanieC.getS_CaSO4_p()), pitanieC.getS_CaSO4_p())
        );
        solidPie9.setData(solidPieChartData9);

        ObservableList<PieChart.Data> liquidPieChartData9 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", pitanieC.getL_KCl_p()), pitanieC.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", pitanieC.getL_NaCl_p()), pitanieC.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", pitanieC.getL_CaSO4_p()), pitanieC.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", pitanieC.getH2O_p()), pitanieC.getH2O_p())
        );
        liquidPie9.setData(liquidPieChartData9);



        solidPie10.setTitle("Кек (Твердая фаза)");
        solidPie10.setStyle("-fx-font-size: 12px;");
        liquidPie10.setTitle("Кек (Жидкая фаза)");
        liquidPie10.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData10 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", kek.getS_KCl_p()), kek.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", kek.getS_NaCl_p()), kek.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", kek.getS_CaSO4_p()), kek.getS_CaSO4_p())
        );
        solidPie10.setData(solidPieChartData10);

        ObservableList<PieChart.Data> liquidPieChartData10 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", kek.getL_KCl_p()), kek.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", kek.getL_NaCl_p()), kek.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", kek.getL_CaSO4_p()), kek.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", kek.getH2O_p()), kek.getH2O_p())
        );
        liquidPie10.setData(liquidPieChartData10);





        solidPie11.setTitle("Фугат (Твердая фаза)");
        solidPie11.setStyle("-fx-font-size: 12px;");
        liquidPie11.setTitle("Фугат (Жидкая фаза)");
        liquidPie11.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData11 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", fugat.getS_KCl_p()), fugat.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", fugat.getS_NaCl_p()), fugat.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", fugat.getS_CaSO4_p()), fugat.getS_CaSO4_p())
        );
        solidPie11.setData(solidPieChartData11);

        ObservableList<PieChart.Data> liquidPieChartData11 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", fugat.getL_KCl_p()), fugat.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", fugat.getL_NaCl_p()), fugat.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", fugat.getL_CaSO4_p()), fugat.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", fugat.getH2O_p()), fugat.getH2O_p())
        );
        liquidPie11.setData(liquidPieChartData11);


        solidPie12.setTitle("Сухие соли (Твердая фаза)");
        solidPie12.setStyle("-fx-font-size: 12px;");
        liquidPie12.setTitle("Сухие соли (Жидкая фаза)");
        liquidPie12.setStyle("-fx-font-size: 12px;");

        ObservableList<PieChart.Data> solidPieChartData12 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", result.getS_KCl_p()), result.getS_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", result.getS_NaCl_p()), result.getS_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", result.getS_CaSO4_p()), result.getS_CaSO4_p())
        );
        solidPie12.setData(solidPieChartData12);

        ObservableList<PieChart.Data> liquidPieChartData12 = FXCollections.observableArrayList(
                new PieChart.Data(String.format("KCl - %.2f%%", result.getL_KCl_p()), result.getL_KCl_p()),
                new PieChart.Data(String.format("NaCl - %.2f%%", result.getL_NaCl_p()), result.getL_NaCl_p()),
                new PieChart.Data(String.format("CaSO₄ - %.2f%%", result.getL_CaSO4_p()), result.getL_CaSO4_p()),
                new PieChart.Data(String.format("H₂O - %.2f%%", result.getH2O_p()), result.getH2O_p())
        );
        liquidPie12.setData(liquidPieChartData12);
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
