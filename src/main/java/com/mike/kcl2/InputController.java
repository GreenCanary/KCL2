package com.mike.kcl2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.Console;
import java.util.prefs.Preferences;

import java.io.IOException;

public class InputController {

    private InputValuesPrecentages inputValues;
    private Material floto;
    private Material redWater;
    private Material posleVish;
    private Material result;
    private Material kek;
    private Material pitanieC;
    private Material fugat;
    private Material slivi;
    private Material pitanieGz;
    private Material penniy;
    private Material posleVish0;



    @FXML private TextField mKekTextField;
    @FXML private TextField tempTextField;
    @FXML private TextField densityTextField;
    @FXML private TextField agentTextField;
    @FXML private Label resultH2O;



    public void initData(InputValuesPrecentages inputValues) {
        this.inputValues = inputValues;

    }

    public void initialize() {
        mKekTextField.setPromptText("200 т/ч");
        tempTextField.setPromptText("20, 25, или 30 t⁰C");
        densityTextField.setPromptText("1.20 т/м3");
        agentTextField.setPromptText("157.52 т/ч");
    }

    @FXML
    private void SaveMenuItemClicked(ActionEvent event) {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);
        prefs.put("mKek", mKekTextField.getText());
        prefs.put("temp", tempTextField.getText());
        prefs.put("density", densityTextField.getText());
        prefs.put("agent", agentTextField.getText());
    }
    @FXML
    public void LoadMenuItemClicked() {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);

        mKekTextField.setText(prefs.get("mKek", ""));
        tempTextField.setText(prefs.get("temp", ""));
        densityTextField.setText(prefs.get("density", ""));
        agentTextField.setText(prefs.get("agent", ""));
    }
    @FXML
    private void DeleteMenuItemClicked(ActionEvent event) {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);

        mKekTextField.clear();
        tempTextField.clear();
        densityTextField.clear();
        agentTextField.clear();
    }



    public void setLabelValue(Label label, double value) {
        label.setText(value+ "");
    }


    public void InputClickedStartCalculations(MouseEvent mouseEvent) {
        try {
            // Read and parse red water input fields and store in the corresponding properties
            double red_KCl_p = 0.0;
            double red_NaCl_p = 0.0;
            double red_CaSO4_p = 0.0;
            double red_H2O_p = 100.0;

            // Read and parse solid input fields and store in the corresponding properties
            double agent = Double.parseDouble(agentTextField.getText());
            int temp = Integer.parseInt(tempTextField.getText());
            double density = Double.parseDouble(densityTextField.getText());
            double mKek =  Double.parseDouble(mKekTextField.getText());
            double moist = 0.055;
            double slRatio = 0.8;
            double mTotal = 396.0;

            double mLiquid = (mTotal * slRatio)/(slRatio + 1);
            double mSolid = mTotal - mLiquid;
            double s_KCl_p = 90.0;
            double s_NaCl_p = 7.0;
            double s_CaSO4_p = 3.0;

            if (temp != 20 && temp !=25 && temp !=30) {
                // Create an alert to show the error message
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Ошибка: введена неверная температура! Допустимые значения: 20, 25, 30.",
                        ButtonType.OK);
                alert.setTitle("Ошибка ввода");
                alert.showAndWait();
                return; // Exit the method if the check fails
            }

            double sumLiquidPercentages = red_KCl_p + red_NaCl_p + red_CaSO4_p + red_H2O_p;
            if (sumLiquidPercentages != 100) {
                // Create an alert to show the error message
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Ошибка: Процентные значения для жидкой фазы не равны 100%. Сумма: " + sumLiquidPercentages,
                        ButtonType.OK);
                alert.setTitle("Ошибка ввода");
                alert.showAndWait();
                return; // Exit the method if the check fails
            }
            double sumSolidPercentages = s_KCl_p + s_NaCl_p + s_CaSO4_p;
            if (sumSolidPercentages != 100) {
                // Create an alert to show the error message
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Ошибка: Процентные значения для твердых веществ не равны 100%. Сумма: " + sumSolidPercentages,
                        ButtonType.OK);
                alert.setTitle("Ошибка ввода");
                alert.showAndWait();
                return; // Exit the method if the check fails
            }




            // Store in InputValuesPrecentages object
            inputValues = new InputValuesPrecentages();
            floto = new Material();
            posleVish = new Material();
            redWater = new Material();
            result = new Material();
            kek = new Material();
            pitanieC = new Material();
            fugat = new Material();
            slivi = new Material();
            pitanieGz = new Material();
            penniy = new Material();
            posleVish0 = new Material();

            // Set the values
            inputValues.setL_KCl_p(red_KCl_p);
            inputValues.setRed_NaCl_p(red_NaCl_p);
            inputValues.setRed_CaSO4_p(red_CaSO4_p);
            inputValues.setRed_H2O_p(red_H2O_p);

            inputValues.setmTotal(mTotal);
            inputValues.setS_KCl_p(s_KCl_p);
            inputValues.setS_NaCl_p(s_NaCl_p);
            inputValues.setS_CaSO4_p(s_CaSO4_p);
            inputValues.setSlRatio(slRatio);

            inputValues.setDensity(density);
            inputValues.setTemperature(temp);





            kek.setS_KCl_p(95.98);
            kek.setS_NaCl_p(0.7);
            kek.setS_CaSO4_p(3.32);

            kek.setL_KCl_p(15.2);
            kek.setL_NaCl_p(12.80);
            kek.setL_CaSO4_p(0.4);
            kek.setH2O_p(71.6);

            kek.setH2O_v(Double.parseDouble(String.format("%.2f", mKek/(1+1/moist))));
            kek.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", kek.getL_CaSO4_p() *kek.getH2O_v()/kek.getH2O_p())));
            kek.setL_NaCl_v(Double.parseDouble(String.format("%.2f",  kek.getL_NaCl_p() *kek.getH2O_v()/kek.getH2O_p())));
            kek.setL_KCl_v(Double.parseDouble(String.format("%.2f",  kek.getL_KCl_p() *kek.getH2O_v()/kek.getH2O_p())));
            kek.setL_Check_v(Double.parseDouble(String.format("%.2f", kek.getL_KCl_v() + kek.getL_NaCl_v()+ kek.getL_CaSO4_v()+ kek.getH2O_v())));

            System.out.println("kek H2O: "+ kek.getH2O_v());
            System.out.println("kek LCaSO4: "+kek.getL_CaSO4_v());
            System.out.println("kek LNaCl: "+kek.getL_NaCl_v());
            System.out.println("kek LKCl: "+kek.getL_KCl_v());
            System.out.println("kek Lcheck: "+kek.getL_Check_v());
            System.out.println(" ");

            kek.setS_Check_v(Double.parseDouble(String.format("%.2f", (kek.getH2O_v() / moist) * (1 - (moist / kek.getH2O_p()) * (kek.getL_KCl_p() + kek.getL_NaCl_p() + kek.getL_CaSO4_p())))));
            kek.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", kek.getS_Check_v()/100 *kek.getS_CaSO4_p())));
            kek.setS_NaCl_v(Double.parseDouble(String.format("%.2f", kek.getS_Check_v()/100 *kek.getS_NaCl_p())));
            kek.setS_KCl_v(Double.parseDouble(String.format("%.2f", kek.getS_Check_v()/100 *kek.getS_KCl_p())));

            System.out.println("kek SCaSO4: "+kek.getS_CaSO4_v());
            System.out.println("kek SNaCl: "+kek.getS_NaCl_v());
            System.out.println("kek SKCl: "+kek.getS_KCl_v());
            System.out.println("kek Scheck: "+kek.getS_Check_v());
            System.out.println(" ");




            pitanieC.setS_KCl_p(95.98);
            pitanieC.setS_NaCl_p(0.7);
            pitanieC.setS_CaSO4_p(3.32);

            pitanieC.setL_KCl_p(15.2);
            pitanieC.setL_NaCl_p(12.80);
            pitanieC.setL_CaSO4_p(0.4);
            pitanieC.setH2O_p(71.6);

            pitanieC.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", kek.getS_CaSO4_v()/0.991)));
            pitanieC.setS_NaCl_v(Double.parseDouble(String.format("%.2f", kek.getS_NaCl_v()/0.99275)));
            pitanieC.setS_KCl_v(Double.parseDouble(String.format("%.2f", kek.getS_KCl_v()/0.9902)));
            pitanieC.setS_Check_v(Double.parseDouble(String.format("%.2f", pitanieC.getS_CaSO4_v() + pitanieC.getS_NaCl_v() +pitanieC.getS_KCl_v())));

            System.out.println("pitanieC SCaSO4: "+pitanieC.getS_CaSO4_v());
            System.out.println("pitanieC SNaCl: "+pitanieC.getS_NaCl_v());
            System.out.println("pitanieC SKCl: "+pitanieC.getS_KCl_v());
            System.out.println("pitanieC Scheck: "+pitanieC.getS_Check_v());
            System.out.println(" ");

            pitanieC.setL_Check_v(Double.parseDouble(String.format("%.2f", pitanieC.getS_Check_v())));
            pitanieC.setH2O_v(Double.parseDouble(String.format("%.2f", (pitanieC.getL_Check_v()/100) * pitanieC.getH2O_p())));
            pitanieC.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", (pitanieC.getL_Check_v()/100) * pitanieC.getL_CaSO4_p())));
            pitanieC.setL_NaCl_v(Double.parseDouble(String.format("%.2f",  (pitanieC.getL_Check_v()/100) * pitanieC.getL_NaCl_p())));
            pitanieC.setL_KCl_v(Double.parseDouble(String.format("%.2f",  (pitanieC.getL_Check_v()/100) * pitanieC.getL_KCl_p())));

            System.out.println("pitanieC H2O: "+ pitanieC.getH2O_v());
            System.out.println("pitanieC LCaSO4: "+pitanieC.getL_CaSO4_v());
            System.out.println("pitanieC LNaCl: "+pitanieC.getL_NaCl_v());
            System.out.println("pitanieC LKCl: "+pitanieC.getL_KCl_v());
            System.out.println("pitanieC Lcheck: "+pitanieC.getL_Check_v());
            System.out.println(" ");






            fugat.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", pitanieC.getS_CaSO4_v() - kek.getS_CaSO4_v())));
            fugat.setS_NaCl_v(Double.parseDouble(String.format("%.2f", pitanieC.getS_NaCl_v() - kek.getS_NaCl_v())));
            fugat.setS_KCl_v(Double.parseDouble(String.format("%.2f", pitanieC.getS_KCl_v() - kek.getS_KCl_v())));
            fugat.setS_Check_v(Double.parseDouble(String.format("%.2f", fugat.getS_CaSO4_v() + fugat.getS_NaCl_v() +fugat.getS_KCl_v())));

            System.out.println("fugat SCaSO4: "+fugat.getS_CaSO4_v());
            System.out.println("fugat SNaCl: "+fugat.getS_NaCl_v());
            System.out.println("fugat SKCl: "+fugat.getS_KCl_v());
            System.out.println("fugat Scheck: "+fugat.getS_Check_v());
            System.out.println(" ");

            fugat.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", pitanieC.getL_CaSO4_v() - kek.getL_CaSO4_v())));
            fugat.setL_NaCl_v(Double.parseDouble(String.format("%.2f", pitanieC.getL_NaCl_v() - kek.getL_NaCl_v())));
            fugat.setL_KCl_v(Double.parseDouble(String.format("%.2f", pitanieC.getL_KCl_v() - kek.getL_KCl_v())));
            fugat.setH2O_v(Double.parseDouble(String.format("%.2f", pitanieC.getH2O_v())));
            fugat.setL_Check_v(Double.parseDouble(String.format("%.2f", fugat.getL_CaSO4_v() + fugat.getL_NaCl_v() +fugat.getL_KCl_v() + fugat.getH2O_v())));

            System.out.println("fugat LCaSO4: "+fugat.getL_CaSO4_v());
            System.out.println("fugat LNaCl: "+fugat.getL_NaCl_v());
            System.out.println("fugat LKCl: "+fugat.getL_KCl_v());
            System.out.println("fugat Lcheck: "+fugat.getL_Check_v());
            System.out.println(" ");


            pitanieGz.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", pitanieC.getS_CaSO4_v()/0.84983)));
            pitanieGz.setS_NaCl_v(Double.parseDouble(String.format("%.2f", pitanieC.getS_NaCl_v()/0.92547)));
            pitanieGz.setS_KCl_v(Double.parseDouble(String.format("%.2f", pitanieC.getS_KCl_v()/0.93372)));
            pitanieGz.setS_Check_v(Double.parseDouble(String.format("%.2f", pitanieGz.getS_CaSO4_v() + pitanieGz.getS_NaCl_v() +pitanieGz.getS_KCl_v())));

            pitanieGz.setS_KCl_p(Double.parseDouble(String.format("%.2f",pitanieGz.getS_KCl_v()/ pitanieGz.getS_Check_v())));
            pitanieGz.setS_NaCl_p(Double.parseDouble(String.format("%.2f", pitanieGz.getS_NaCl_v()/ pitanieGz.getS_Check_v())));
            pitanieGz.setS_CaSO4_p(Double.parseDouble(String.format("%.2f", pitanieGz.getS_CaSO4_v()/ pitanieGz.getS_Check_v())));

            pitanieGz.setL_KCl_p(15.2);
            pitanieGz.setL_NaCl_p(12.80);
            pitanieGz.setL_CaSO4_p(0.4);
            pitanieGz.setH2O_p(71.6);

            System.out.println("pitanieGz SCaSO4: "+pitanieGz.getS_CaSO4_v());
            System.out.println("pitanieGz SNaCl: "+pitanieGz.getS_NaCl_v());
            System.out.println("pitanieGz SKCl: "+pitanieGz.getS_KCl_v());
            System.out.println("pitanieGz Scheck: "+pitanieGz.getS_Check_v());
            System.out.println(" ");

            pitanieGz.setL_Check_v(Double.parseDouble(String.format("%.2f", pitanieC.getS_Check_v()*2.6632)));
            pitanieGz.setH2O_v(Double.parseDouble(String.format("%.2f", (pitanieGz.getL_Check_v()/100) * pitanieGz.getH2O_p())));
            pitanieGz.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", (pitanieGz.getL_Check_v()/100) * pitanieGz.getL_CaSO4_p())));
            pitanieGz.setL_NaCl_v(Double.parseDouble(String.format("%.2f",  (pitanieGz.getL_Check_v()/100) * pitanieGz.getL_NaCl_p())));
            pitanieGz.setL_KCl_v(Double.parseDouble(String.format("%.2f",  (pitanieGz.getL_Check_v()/100) * pitanieGz.getL_KCl_p())));

            System.out.println("pitanieGz H2O: "+ pitanieGz.getH2O_v());
            System.out.println("pitanieGz LCaSO4: "+pitanieGz.getL_CaSO4_v());
            System.out.println("pitanieGz LNaCl: "+pitanieGz.getL_NaCl_v());
            System.out.println("pitanieGz LKCl: "+pitanieGz.getL_KCl_v());
            System.out.println("pitanieGz Lcheck: "+pitanieGz.getL_Check_v());
            System.out.println(" ");



            slivi.setL_KCl_p(15.2);
            slivi.setL_NaCl_p(12.80);
            slivi.setL_CaSO4_p(0.4);
            slivi.setH2O_p(71.6);

            slivi.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", pitanieGz.getS_CaSO4_v() - pitanieC.getS_CaSO4_v())));
            slivi.setS_NaCl_v(Double.parseDouble(String.format("%.2f", pitanieGz.getS_NaCl_v() - pitanieC.getS_NaCl_v())));
            slivi.setS_KCl_v(Double.parseDouble(String.format("%.2f", pitanieGz.getS_KCl_v() - pitanieC.getS_KCl_v())));
            slivi.setS_Check_v(Double.parseDouble(String.format("%.2f", slivi.getS_CaSO4_v() + slivi.getS_NaCl_v() +slivi.getS_KCl_v())));

            System.out.println("slivi SCaSO4: "+slivi.getS_CaSO4_v());
            System.out.println("slivi SNaCl: "+slivi.getS_NaCl_v());
            System.out.println("slivi SKCl: "+slivi.getS_KCl_v());
            System.out.println("slivi Scheck: "+slivi.getS_Check_v());
            System.out.println(" ");

            slivi.setL_Check_v(Double.parseDouble(String.format("%.2f", slivi.getS_Check_v()*20)));
            slivi.setH2O_v(Double.parseDouble(String.format("%.2f", slivi.getL_Check_v()/100 * slivi.getH2O_p())));
            slivi.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", slivi.getL_Check_v()/100 * slivi.getL_CaSO4_p())));
            slivi.setL_NaCl_v(Double.parseDouble(String.format("%.2f", slivi.getL_Check_v()/100 * slivi.getL_NaCl_p())));
            slivi.setL_KCl_v(Double.parseDouble(String.format("%.2f", slivi.getL_Check_v()/100 * slivi.getL_KCl_p())));

            System.out.println("slivi H2O: "+slivi.getH2O_v());
            System.out.println("slivi LCaSO4: "+slivi.getL_CaSO4_v());
            System.out.println("slivi LNaCl: "+slivi.getL_NaCl_v());
            System.out.println("slivi LKCl: "+slivi.getL_KCl_v());
            System.out.println("slivi Lcheck: "+slivi.getL_Check_v());
            System.out.println(" ");



            penniy.setS_KCl_v(Double.parseDouble(String.format("%.2f", (fugat.getS_KCl_v() +slivi.getS_KCl_v()) /1.05)));
            penniy.setS_NaCl_v(Double.parseDouble(String.format("%.2f", fugat.getS_NaCl_v() +slivi.getS_NaCl_v())));
            penniy.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", (fugat.getS_CaSO4_v() +slivi.getS_CaSO4_v()) /2.2642)));
            penniy.setS_Check_v(Double.parseDouble(String.format("%.2f", penniy.getS_CaSO4_v() + penniy.getS_NaCl_v() + penniy.getS_KCl_v())));

            penniy.setS_KCl_p(Double.parseDouble(String.format("%.2f",penniy.getS_KCl_v()/ penniy.getS_Check_v())));
            penniy.setS_NaCl_p(Double.parseDouble(String.format("%.2f", penniy.getS_NaCl_v()/ penniy.getS_Check_v())));
            penniy.setS_CaSO4_p(Double.parseDouble(String.format("%.2f", penniy.getS_CaSO4_v()/ penniy.getS_Check_v())));

            penniy.setL_KCl_p(15.2);
            penniy.setL_NaCl_p(12.80);
            penniy.setL_CaSO4_p(0.4);
            penniy.setH2O_p(71.6);

            System.out.println("penniy SCaSO4: "+penniy.getS_CaSO4_v());
            System.out.println("penniy SNaCl: "+penniy.getS_NaCl_v());
            System.out.println("penniy SKCl: "+penniy.getS_KCl_v());
            System.out.println("penniy Scheck: "+penniy.getS_Check_v());
            System.out.println(" ");


            penniy.setH2O_v(Double.parseDouble(String.format("%.2f", (fugat.getH2O_v() +slivi.getH2O_v()) /23.02)));
            penniy.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", (fugat.getL_CaSO4_v() +slivi.getL_CaSO4_v()) /23.02)));
            penniy.setL_NaCl_v(Double.parseDouble(String.format("%.2f",  (fugat.getL_NaCl_v() +slivi.getL_NaCl_v()) /23.02)));
            penniy.setL_KCl_v(Double.parseDouble(String.format("%.2f",  (fugat.getL_KCl_v() +slivi.getL_KCl_v()) /23.02)));
            penniy.setL_Check_v(Double.parseDouble(String.format("%.2f", penniy.getL_CaSO4_v() + penniy.getL_NaCl_v() +penniy.getL_KCl_v() + penniy.getH2O_v())));

            System.out.println("penniy H2O: "+ penniy.getH2O_v());
            System.out.println("penniy LCaSO4: "+penniy.getL_CaSO4_v());
            System.out.println("penniy LNaCl: "+penniy.getL_NaCl_v());
            System.out.println("penniy LKCl: "+penniy.getL_KCl_v());
            System.out.println("penniy Lcheck: "+penniy.getL_Check_v());
            System.out.println(" ");



            posleVish0.setL_KCl_p(15.2);
            posleVish0.setL_NaCl_p(12.80);
            posleVish0.setL_CaSO4_p(0.4);
            posleVish0.setH2O_p(71.6);

            posleVish0.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", pitanieGz.getS_CaSO4_v() - penniy.getS_CaSO4_v())));
            posleVish0.setS_NaCl_v(Double.parseDouble(String.format("%.2f", pitanieGz.getS_NaCl_v() - penniy.getS_NaCl_v())));
            posleVish0.setS_KCl_v(Double.parseDouble(String.format("%.2f", pitanieGz.getS_KCl_v() - penniy.getS_KCl_v())));
            posleVish0.setS_Check_v(Double.parseDouble(String.format("%.2f", posleVish0.getS_CaSO4_v() + posleVish0.getS_NaCl_v() +posleVish0.getS_KCl_v())));

            System.out.println("posleVish0 SCaSO4: "+posleVish0.getS_CaSO4_v());
            System.out.println("posleVish0 SNaCl: "+posleVish0.getS_NaCl_v());
            System.out.println("posleVish0 SKCl: "+posleVish0.getS_KCl_v());
            System.out.println("posleVish0 Scheck: "+posleVish0.getS_Check_v());
            System.out.println(" ");


            posleVish0.setH2O_v(Double.parseDouble(String.format("%.2f", pitanieGz.getH2O_v() - penniy.getH2O_v())));
            posleVish0.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", pitanieGz.getL_CaSO4_v() - penniy.getL_CaSO4_v())));
            posleVish0.setL_NaCl_v(Double.parseDouble(String.format("%.2f", pitanieGz.getL_NaCl_v() - penniy.getL_NaCl_v())));
            posleVish0.setL_KCl_v(Double.parseDouble(String.format("%.2f", pitanieGz.getL_KCl_v() - penniy.getL_KCl_v())));
            posleVish0.setL_Check_v(Double.parseDouble(String.format("%.2f", posleVish0.getH2O_v() + posleVish0.getL_CaSO4_v()+ posleVish0.getL_NaCl_v()+posleVish0.getL_KCl_v())));

            System.out.println("posleVish0 H2O: "+posleVish0.getH2O_v());
            System.out.println("posleVish0 LCaSO4: "+posleVish0.getL_CaSO4_v());
            System.out.println("posleVish0 LNaCl: "+posleVish0.getL_NaCl_v());
            System.out.println("posleVish0 LKCl: "+posleVish0.getL_KCl_v());
            System.out.println("posleVish0 Lcheck: "+posleVish0.getL_Check_v());
            System.out.println(" ");






            //RedWater
            redWater.setS_KCl_v(Double.parseDouble(String.format("%.2f", 0.00)));
            redWater.setS_NaCl_v(Double.parseDouble(String.format("%.2f", 0.00)));
            redWater.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", 0.00)));
            redWater.setS_Check_v(Double.parseDouble(String.format("%.2f", 0.00)));

            redWater.setS_KCl_p(Double.parseDouble(String.format("%.2f", 0.00)));
            redWater.setS_NaCl_p(Double.parseDouble(String.format("%.2f", 0.00)));
            redWater.setS_CaSO4_p(Double.parseDouble(String.format("%.2f", 0.00)));
            redWater.setS_Check_p(0.00);


            redWater.setL_KCl_p(Double.parseDouble(String.format("%.2f", (inputValues.getRed_KCL_p()))));
            redWater.setL_NaCl_p(Double.parseDouble(String.format("%.2f", (inputValues.getRed_NaCl_p()))));
            redWater.setL_CaSO4_p(Double.parseDouble(String.format("%.2f", (inputValues.getRed_CaSO4_p()))));
            redWater.setH2O_p(Double.parseDouble(String.format("%.2f", (inputValues.getRed_H2O_p()))));
            redWater.setL_Check_p(100);

            redWater.setL_Check_v(Double.parseDouble(String.format("%.2f", agent)));
            redWater.setL_KCl_v((Double.parseDouble(String.format("%.2f",agent * redWater.getL_KCl_p()/100))));
            redWater.setL_NaCl_v((Double.parseDouble(String.format("%.2f",agent * redWater.getL_NaCl_p()/100))));
            redWater.setL_CaSO4_v((Double.parseDouble(String.format("%.2f",agent * redWater.getL_CaSO4_p()/100))));
            redWater.setH2O_v((Double.parseDouble(String.format("%.2f",agent * redWater.getH2O_p()/100))));

            System.out.println("water H2O: "+redWater.getH2O_v());
            System.out.println("water Lcheck: "+redWater.getL_Check_v());
            System.out.println(" ");





            floto.setL_KCl_p(12);
            floto.setL_NaCl_p(20);
            floto.setL_CaSO4_p(0.4);
            floto.setH2O_p(67.6);


            floto.setH2O_v(Double.parseDouble(String.format("%.2f", posleVish0.getH2O_v() - redWater.getH2O_v())));
            floto.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", (floto.getH2O_v()/floto.getH2O_p()) *floto.getL_CaSO4_p())));
            floto.setL_NaCl_v(Double.parseDouble(String.format("%.2f", (floto.getH2O_v()/floto.getH2O_p()) *floto.getL_NaCl_p())));
            floto.setL_KCl_v(Double.parseDouble(String.format("%.2f", (floto.getH2O_v()/floto.getH2O_p()) *floto.getL_KCl_p())));
            floto.setL_Check_v(Double.parseDouble(String.format("%.2f", floto.getH2O_v() + floto.getL_CaSO4_v()+ floto.getL_NaCl_v()+floto.getL_KCl_v())));

            System.out.println("floto H2O: "+floto.getH2O_v());
            System.out.println("floto LCaSO4: "+floto.getL_CaSO4_v());
            System.out.println("floto LNaCl: "+floto.getL_NaCl_v());
            System.out.println("floto LKCl: "+floto.getL_KCl_v());
            System.out.println("floto Lcheck: "+floto.getL_Check_v());
            System.out.println(" ");

            floto.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", posleVish0.getS_CaSO4_v()+posleVish0.getL_CaSO4_v()- floto.getL_CaSO4_v())));
            floto.setS_NaCl_v(Double.parseDouble(String.format("%.2f", posleVish0.getS_NaCl_v()+posleVish0.getL_NaCl_v() - floto.getL_NaCl_v())));
            floto.setS_KCl_v(Double.parseDouble(String.format("%.2f", posleVish0.getS_KCl_v()+posleVish0.getL_KCl_v()- floto.getL_KCl_v())));
            floto.setS_Check_v(Double.parseDouble(String.format("%.2f", floto.getS_CaSO4_v() + floto.getS_NaCl_v() +floto.getS_KCl_v())));

            System.out.println("floto SCaSO4: "+floto.getS_CaSO4_v());
            System.out.println("floto SNaCl: "+floto.getS_NaCl_v());
            System.out.println("floto SKCl: "+floto.getS_KCl_v());
            System.out.println("floto Scheck: "+floto.getS_Check_v());
            System.out.println(" ");






            DensityPercentageLookup.DensityData densityData = DensityPercentageLookup.findPercentages(temp, density);
            double naclPercentage = densityData.naclPercentage;
            double kclPercentage = densityData.kclPercentage;

            // Now use these percentages in your calculations
            // For example, you can set them in your floto material:
            posleVish.setL_NaCl_p((Double.parseDouble(String.format("%.2f",naclPercentage))));  // Set NaCl percentage from lookup
            posleVish.setL_KCl_p((Double.parseDouble(String.format("%.2f", kclPercentage))));    // Set KCl percentage from lookup
            posleVish.setL_CaSO4_p(0.4);

            // Calculate water percentage to make total 100%
            double waterPercentage = 100 - naclPercentage - kclPercentage - 0.4;
            posleVish.setH2O_p((Double.parseDouble(String.format("%.2f",waterPercentage))));
            posleVish.setL_Check_p(100);

            posleVish.setH2O_v(Double.parseDouble(String.format("%.2f", floto.getH2O_v() +  redWater.getH2O_v())));
                posleVish.setL_KCl_v(Double.parseDouble(String.format("%.2f", posleVish.getL_KCl_p()* posleVish.getH2O_v()/ posleVish.getH2O_p())));
                posleVish.setL_NaCl_v(Double.parseDouble(String.format("%.2f", posleVish.getL_NaCl_p()* posleVish.getH2O_v()/ posleVish.getH2O_p())));
                posleVish.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", posleVish.getL_CaSO4_p() * posleVish.getH2O_v()/ posleVish.getH2O_p())));
                posleVish.setL_Check_v(Double.parseDouble(String.format("%.2f", posleVish.getH2O_v() + posleVish.getL_KCl_v() + posleVish.getL_NaCl_v() + posleVish.getL_CaSO4_v())));


                posleVish.setS_KCl_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_v() + floto.getL_KCl_v() + redWater.getL_KCl_v() - posleVish.getL_KCl_v())));
                posleVish.setS_NaCl_v(Double.parseDouble(String.format("%.2f", floto.getS_NaCl_v() + floto.getL_NaCl_v() + redWater.getL_NaCl_v() - posleVish.getL_NaCl_v())));
                posleVish.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", floto.getS_CaSO4_v() + floto.getL_CaSO4_v() + redWater.getL_CaSO4_v() - posleVish.getL_CaSO4_v())));
                posleVish.setS_Check_v(Double.parseDouble(String.format("%.2f", posleVish.getS_KCl_v() + posleVish.getS_NaCl_v() + posleVish.getS_CaSO4_v())));


                posleVish.setmSolid(mSolid);
                posleVish.setS_KCl_p(Double.parseDouble(String.format("%.2f", (posleVish.getS_KCl_v() / posleVish.getS_Check_v() * 100))));
                posleVish.setS_NaCl_p(Double.parseDouble(String.format("%.2f", (posleVish.getS_NaCl_v() / posleVish.getS_Check_v() * 100))));
                posleVish.setS_CaSO4_p(Double.parseDouble(String.format("%.2f", (posleVish.getS_CaSO4_v() / posleVish.getS_Check_v() * 100))));
                posleVish.setS_Check_p(100);

                posleVish.setSlRatio(slRatio);
                posleVish.setmLiquid(mLiquid);



            result.setL_NaCl_p((Double.parseDouble(String.format("%.2f",17.6))));  // Set NaCl percentage from lookup
            result.setL_KCl_p((Double.parseDouble(String.format("%.2f", 12.09))));    // Set KCl percentage from lookup
            result.setL_CaSO4_p(0.4);
            result.setH2O_v((Double.parseDouble(String.format("%.2f",(redWater.getL_Check_v()+ floto.getH2O_v()) + (posleVish.getL_NaCl_v()/20 * 1.15*67.6) - (floto.getH2O_v() + redWater.getL_Check_v())))));

            // Calculate water percentage to make total 100%
            double waterPercentage2 = 100 - result.getL_NaCl_p() - result.getL_KCl_p() - 0.4;
            result.setH2O_p((Double.parseDouble(String.format("%.2f",waterPercentage2))));
            result.setL_Check_p(100);

            result.setS_NaCl_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_v()/100 * 0.68)));

            result.setL_KCl_v(Double.parseDouble(String.format("%.2f", result.getL_KCl_p()* result.getH2O_v()/ result.getH2O_p()+result.getS_NaCl_v())));
            result.setL_NaCl_v(Double.parseDouble(String.format("%.2f", floto.getS_NaCl_v()+floto.getL_NaCl_v()+redWater.getL_NaCl_v()- result.getS_NaCl_v())));
            result.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", 0.4 * result.getH2O_v()/result.getH2O_p())));
            result.setL_Check_v(Double.parseDouble(String.format("%.2f", result.getH2O_v() + result.getL_KCl_v() + result.getL_NaCl_v() + result.getL_CaSO4_v())));

            result.setS_KCl_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_v() + floto.getL_KCl_v() + redWater.getL_KCl_v() - result.getL_KCl_v())));
            result.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", floto.getS_CaSO4_v() + floto.getL_CaSO4_v() + redWater.getL_CaSO4_v() - result.getL_CaSO4_v())));
            result.setS_Check_v(Double.parseDouble(String.format("%.2f", result.getS_KCl_v() + result.getS_NaCl_v() + result.getS_CaSO4_v())));

            result.setS_KCl_p(Double.parseDouble(String.format("%.2f", (result.getS_KCl_v() / result.getS_Check_v() * 100))));
            result.setS_NaCl_p(Double.parseDouble(String.format("%.2f", (result.getS_NaCl_v() / result.getS_Check_v() * 100))));
            result.setS_CaSO4_p(Double.parseDouble(String.format("%.2f", (result.getS_CaSO4_v() / result.getS_Check_v() * 100))));
            result.setS_Check_p(100);


            double waterTotal = floto.getH2O_v() + redWater.getL_Check_v();
            double waterTotalCalculated = posleVish.getL_NaCl_v()/result.getL_NaCl_p() * 1.15*result.getH2O_p();
            double waterCorrection = waterTotalCalculated - waterTotal;
            double waterCorrectionCalculated = redWater.getL_Check_v() + waterCorrection;

            System.out.println("KCl: "+posleVish.getL_KCl_p()+" %");
            System.out.println("NaCl: "+posleVish.getL_NaCl_p()+" %");
            System.out.println("NaCl: " + posleVish.getL_NaCl_v());


            System.out.println("water total: " + waterTotal);
            System.out.println("water total calculated: " + waterTotalCalculated);
            System.out.println("water correction: " + waterCorrection);
            System.out.println("water correction calculated: " + waterCorrectionCalculated);

            setLabelValue(resultH2O, (Double.parseDouble(String.format("%.2f",waterCorrectionCalculated))));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mike/kcl2/Main.fxml")); // Adjust path to match your project structure
            Parent root = loader.load();

            // Get the controller and pass the data
            Application.getRootContainer().getChildren().setAll(root);



        } catch (NumberFormatException e) {
            System.err.println("Ошибка ввода: убедитесь, что все поля заполнены числами.");
            // Optional: show an alert dialog to the user
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ошибка ввода: убедитесь, что все поля заполнены числами.", ButtonType.OK);
            alert.setTitle("Ошибка ввода");
            alert.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

