package com.mike.kcl2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.prefs.Preferences;

import java.io.IOException;

public class InputController {

    private InputValuesPrecentages inputValues;
    private MainController mainController;
    private Material floto;
    private Material filtrat;
    private Material posleVish;
    private Material penniy;
    private Material obezvozhivanie;
    private Material peski;
    private Material slivi;
    private Material redWater;
    private Material pitanieC;
    private Material fugat;
    private Material kek;
    private Material result;


    @FXML private TextField mRedWaterTextField;
    @FXML private TextField KClRedWaterTextField;
    @FXML private TextField NaClRedWaterTextField;
    @FXML private TextField CaSO4RedWaterTextField;
    @FXML private TextField H2ORedWaterTextField;

    @FXML private TextField mTotalTextField;
    @FXML private TextField KClSolidTextField;
    @FXML private TextField NaClSolidTextField;
    @FXML private TextField CaSO4SolidTextField;
    @FXML private TextField slRatioTextField;




    public void initData(InputValuesPrecentages inputValues) {
        this.inputValues = inputValues;
    }

    @FXML
    private void SaveMenuItemClicked(ActionEvent event) {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);

        prefs.put("mRedWater", mRedWaterTextField.getText());
        prefs.put("KClRedWater", KClRedWaterTextField.getText());
        prefs.put("NaClRedWater", NaClRedWaterTextField.getText());
        prefs.put("CaSO4RedWater", CaSO4RedWaterTextField.getText());
        prefs.put("H2ORedWater", H2ORedWaterTextField.getText());
        prefs.put("mTotal", mTotalTextField.getText());
        prefs.put("KClSolid", KClSolidTextField.getText());
        prefs.put("NaClSolid", NaClSolidTextField.getText());
        prefs.put("CaSO4Solid", CaSO4SolidTextField.getText());
        prefs.put("slRatio", slRatioTextField.getText());
    }
    @FXML
    public void LoadMenuItemClicked() {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);

        mRedWaterTextField.setText(prefs.get("mRedWater", ""));
        KClRedWaterTextField.setText(prefs.get("KClRedWater", ""));
        NaClRedWaterTextField.setText(prefs.get("NaClRedWater", ""));
        CaSO4RedWaterTextField.setText(prefs.get("CaSO4RedWater", ""));
        H2ORedWaterTextField.setText(prefs.get("H2ORedWater", ""));
        mTotalTextField.setText(prefs.get("mTotal", ""));
        KClSolidTextField.setText(prefs.get("KClSolid", ""));
        NaClSolidTextField.setText(prefs.get("NaClSolid", ""));
        CaSO4SolidTextField.setText(prefs.get("CaSO4Solid", ""));
        slRatioTextField.setText(prefs.get("slRatio", ""));
    }
    @FXML
    private void DeleteMenuItemClicked(ActionEvent event) {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);

        // Clear preferences
        prefs.remove("mRedWater");
        prefs.remove("KClRedWater");
        prefs.remove("NaClRedWater");
        prefs.remove("CaSO4RedWater");
        prefs.remove("H2ORedWater");

        prefs.remove("mTotal");
        prefs.remove("KClSolid");
        prefs.remove("NaClSolid");
        prefs.remove("CaSO4Solid");
        prefs.remove("slRatio");

        // Clear text fields
        mRedWaterTextField.clear();
        KClRedWaterTextField.clear();
        NaClRedWaterTextField.clear();
        CaSO4RedWaterTextField.clear();
        H2ORedWaterTextField.clear();

        mTotalTextField.clear();
        KClSolidTextField.clear();
        NaClSolidTextField.clear();
        CaSO4SolidTextField.clear();
        slRatioTextField.clear();
    }


    public void handleOpenWindow(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PopupWindow.fxml")); // your pop-up FXML
            Parent root = fxmlLoader.load();


            Stage stage = new Stage();
            stage.setTitle("Pop-up Window");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void InputClickedStartCalculations(MouseEvent mouseEvent) {
        try {
            // Read and parse red water input fields and store in the corresponding properties
            double mRedWater = Double.parseDouble(mRedWaterTextField.getText());
            double red_KCl_p = Double.parseDouble(KClRedWaterTextField.getText());
            double red_NaCl_p = Double.parseDouble(NaClRedWaterTextField.getText());
            double red_CaSO4_p = Double.parseDouble(CaSO4RedWaterTextField.getText());
            double red_H2O_p = Double.parseDouble(H2ORedWaterTextField.getText());

            // Read and parse solid input fields and store in the corresponding properties
            double slRatio = Double.parseDouble(slRatioTextField.getText());
            double mTotal = Double.parseDouble(mTotalTextField.getText());

            double mLiquid = (mTotal * slRatio)/(slRatio + 1);
            double mSolid = mTotal - mLiquid;
            double s_KCl_p = Double.parseDouble(KClSolidTextField.getText());
            double s_NaCl_p = Double.parseDouble(NaClSolidTextField.getText());
            double s_CaSO4_p = Double.parseDouble(CaSO4SolidTextField.getText());


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
            filtrat = new Material();
            posleVish = new Material();
            penniy = new Material();
            obezvozhivanie = new Material();
            peski = new Material();
            slivi = new Material();
            redWater = new Material();

            // Set the values
            inputValues.setmRedWater(mRedWater);
            inputValues.setL_KCl_p(red_KCl_p);
            inputValues.setRed_NaCl_p(red_NaCl_p);
            inputValues.setRed_CaSO4_p(red_CaSO4_p);
            inputValues.setRed_H2O_p(red_H2O_p);

            inputValues.setmTotal(mTotal);
            inputValues.setS_KCl_p(s_KCl_p);
            inputValues.setS_NaCl_p(s_NaCl_p);
            inputValues.setS_CaSO4_p(s_CaSO4_p);
            inputValues.setSlRatio(slRatio);




            // floto time

            floto.setmSolid(mSolid);
            floto.setS_KCl_p(s_KCl_p);
            floto.setS_NaCl_p(s_NaCl_p);
            floto.setS_CaSO4_p(s_CaSO4_p);
            floto.setS_Check_p(s_KCl_p + s_NaCl_p +s_CaSO4_p);
            floto.setSlRatio(slRatio);

            floto.setmLiquid(mLiquid);
            floto.setL_KCl_p(12);
            floto.setL_NaCl_p(20);
            floto.setL_CaSO4_p(0.4);
            floto.setH2O_p(67.6);
            floto.setL_Check_p(100);

// Format the values with 2 decimal places
            floto.setS_KCl_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_p() * mSolid / 100)));
            floto.setS_NaCl_v(Double.parseDouble(String.format("%.2f", floto.getS_NaCl_p() * mSolid / 100)));
            floto.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", floto.getS_CaSO4_p() * mSolid / 100)));
            floto.setS_Check_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_v() + floto.getS_NaCl_v()+ floto.getS_CaSO4_v())));

            floto.setL_KCl_v(Double.parseDouble(String.format("%.2f", 12 * mLiquid / 100)));
            floto.setL_NaCl_v(Double.parseDouble(String.format("%.2f", 20 * mLiquid / 100)));
            floto.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", 0.4 * mLiquid / 100)));
            floto.setH2O_v(Double.parseDouble(String.format("%.2f", 67.6 * mLiquid / 100)));
            floto.setL_Check_v(Double.parseDouble(String.format("%.2f", floto.getL_KCl_v() + floto.getL_NaCl_v()+ floto.getL_CaSO4_v()+ floto.getH2O_v())));



            filtrat.setmSolid(mSolid);
            filtrat.setS_KCl_p(96.74);
            filtrat.setS_NaCl_p(0.51);
            filtrat.setS_CaSO4_p(2.75);
            filtrat.setS_Check_p(100);

            filtrat.setSlRatio(slRatio);
            filtrat.setmLiquid(mLiquid);
            filtrat.setL_KCl_p(17.2);
            filtrat.setL_NaCl_p(10);
            filtrat.setL_CaSO4_p(0.4);
            filtrat.setH2O_p(72.4);
            filtrat.setL_Check_p(100);

// Format the values with 2 decimal places
            double H2OFiltrat = 1.1 * floto.getH2O_p() / floto.getL_NaCl_p() * floto.getS_NaCl_v() * (1 + (filtrat.getL_NaCl_p() / filtrat.getH2O_p() * floto.getH2O_p() / floto.getL_NaCl_p()));
            filtrat.setH2O_v(Double.parseDouble(String.format("%.2f", H2OFiltrat)));
            filtrat.setL_KCl_v(Double.parseDouble(String.format("%.2f",filtrat.getH2O_v()/ filtrat.getH2O_p()*filtrat.getL_KCl_p())));
            filtrat.setL_NaCl_v(Double.parseDouble(String.format("%.2f", filtrat.getH2O_v()/ filtrat.getH2O_p() * filtrat.getL_NaCl_p())));
            filtrat.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", filtrat.getH2O_v()/ filtrat.getH2O_p()* filtrat.getL_CaSO4_p())));
            filtrat.setL_Check_v(Double.parseDouble(String.format("%.2f", filtrat.getL_KCl_v() + filtrat.getL_NaCl_v()+ filtrat.getL_CaSO4_v()+ filtrat.getH2O_v())));


            filtrat.setS_Check_v(Double.parseDouble(String.format("%.2f", filtrat.getL_Check_v()/101.3902)));
            filtrat.setS_KCl_v(Double.parseDouble(String.format("%.2f", filtrat.getS_Check_v()*filtrat.getS_KCl_p()/100)));
            filtrat.setS_NaCl_v(Double.parseDouble(String.format("%.2f",filtrat.getS_Check_v()*filtrat.getS_NaCl_p()/100)));
            filtrat.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", filtrat.getS_Check_v()*filtrat.getS_CaSO4_p()/100)));




            //PosleVish section

            posleVish.setH2O_v(Double.parseDouble(String.format("%.2f", floto.getH2O_v() + filtrat.getH2O_v())));
            posleVish.setL_KCl_v(Double.parseDouble(String.format("%.2f",floto.getL_KCl_v() + 14.9090)));
            posleVish.setL_NaCl_v(Double.parseDouble(String.format("%.2f", floto.getL_NaCl_v() + 24.8484)));
            posleVish.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", floto.getL_CaSO4_v() + 0.496969)));
            posleVish.setL_Check_v(Double.parseDouble(String.format("%.2f", posleVish.getH2O_v() + posleVish.getL_KCl_v() + posleVish.getL_NaCl_v() + posleVish.getL_CaSO4_v())));


            posleVish.setS_KCl_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_v() + filtrat.getS_KCl_v() + filtrat.getL_KCl_v() - 14.9090)));
            posleVish.setS_NaCl_v(Double.parseDouble(String.format("%.2f",floto.getS_NaCl_v() + filtrat.getS_NaCl_v() + filtrat.getL_NaCl_v() - 24.8484)));
            posleVish.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", floto.getS_CaSO4_v() + filtrat.getS_CaSO4_v() + filtrat.getL_CaSO4_v() - 0.496969)));
            posleVish.setS_Check_v(Double.parseDouble(String.format("%.2f", posleVish.getS_KCl_v()+ posleVish.getS_NaCl_v() + posleVish.getS_CaSO4_v())));


            posleVish.setmSolid(mSolid);
            posleVish.setS_KCl_p(Double.parseDouble(String.format("%.2f",(posleVish.getS_KCl_v()/ posleVish.getS_Check_v() * 100))));
            posleVish.setS_NaCl_p(Double.parseDouble(String.format("%.2f",(posleVish.getS_NaCl_v()/ posleVish.getS_Check_v() * 100))));
            posleVish.setS_CaSO4_p(Double.parseDouble(String.format("%.2f",(posleVish.getS_CaSO4_v()/ posleVish.getS_Check_v() * 100))));
            posleVish.setS_Check_p(100);

            posleVish.setSlRatio(slRatio);
            posleVish.setmLiquid(mLiquid);

            posleVish.setL_KCl_p(Double.parseDouble(String.format("%.2f",(posleVish.getL_KCl_v()/ posleVish.getL_Check_v() * 100))));
            posleVish.setL_NaCl_p(Double.parseDouble(String.format("%.2f",(posleVish.getL_NaCl_v()/ posleVish.getL_Check_v() * 100))));
            posleVish.setL_CaSO4_p(Double.parseDouble(String.format("%.2f",(posleVish.getL_CaSO4_v()/ posleVish.getL_Check_v() * 100))));
            posleVish.setH2O_p(Double.parseDouble(String.format("%.2f",(posleVish.getH2O_v()/ posleVish.getL_Check_v() * 100 ))));
            posleVish.setL_Check_p(100);

            //Penniy
            penniy.setH2O_v(Double.parseDouble(String.format("%.2f", 13.29)));
            penniy.setL_KCl_v(Double.parseDouble(String.format("%.2f", 2.57)));
            penniy.setL_NaCl_v(Double.parseDouble(String.format("%.2f", 3.36)));
            penniy.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", 0.08)));
            penniy.setL_Check_v(Double.parseDouble(String.format("%.2f", penniy.getH2O_v() + penniy.getL_KCl_v() + penniy.getL_NaCl_v() + penniy.getL_CaSO4_v())));


            penniy.setS_KCl_v(Double.parseDouble(String.format("%.2f", 14.66)));
            penniy.setS_NaCl_v(Double.parseDouble(String.format("%.2f",0.12)));
            penniy.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", 0.43)));
            penniy.setS_Check_v(Double.parseDouble(String.format("%.2f", penniy.getS_KCl_v()+ penniy.getS_NaCl_v() + penniy.getS_CaSO4_v())));


            penniy.setmSolid(mSolid);
            penniy.setS_KCl_p(Double.parseDouble(String.format("%.2f",(penniy.getS_KCl_v()/ penniy.getS_Check_v() * 100))));
            penniy.setS_NaCl_p(Double.parseDouble(String.format("%.2f",(penniy.getS_NaCl_v()/ penniy.getS_Check_v() * 100))));
            penniy.setS_CaSO4_p(Double.parseDouble(String.format("%.2f",(penniy.getS_CaSO4_v()/ penniy.getS_Check_v() * 100))));
            penniy.setS_Check_p(100);

            penniy.setSlRatio(slRatio);
            penniy.setmLiquid(mLiquid);

            penniy.setL_KCl_p(Double.parseDouble(String.format("%.2f",(penniy.getL_KCl_v()/ penniy.getL_Check_v() * 100))));
            penniy.setL_NaCl_p(Double.parseDouble(String.format("%.2f",(penniy.getL_NaCl_v()/ penniy.getL_Check_v() * 100))));
            penniy.setL_CaSO4_p(Double.parseDouble(String.format("%.2f",(penniy.getL_CaSO4_v()/ penniy.getL_Check_v() * 100))));
            penniy.setH2O_p(Double.parseDouble(String.format("%.2f",(penniy.getH2O_v()/ penniy.getL_Check_v() * 100 ))));
            penniy.setL_Check_p(100);

            //Obezvosh
            obezvozhivanie.setL_KCl_v(Double.parseDouble(String.format("%.2f", posleVish.getL_KCl_v()+ 2.3591)));
            obezvozhivanie.setL_NaCl_v(Double.parseDouble(String.format("%.2f", posleVish.getL_NaCl_v() + 3.9319)));
            obezvozhivanie.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", posleVish.getL_CaSO4_v() + 0.4969)));
            obezvozhivanie.setH2O_v(Double.parseDouble(String.format("%.2f", posleVish.getH2O_v() + 13.29)));
            obezvozhivanie.setL_Check_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getH2O_v() + obezvozhivanie.getL_KCl_v() + obezvozhivanie.getL_NaCl_v() + obezvozhivanie.getL_CaSO4_v())));

            obezvozhivanie.setL_KCl_p(Double.parseDouble(String.format("%.2f",(12.00))));
            obezvozhivanie.setL_NaCl_p(Double.parseDouble(String.format("%.2f",(20.00))));
            obezvozhivanie.setL_CaSO4_p(Double.parseDouble(String.format("%.2f",(0.40))));
            obezvozhivanie.setH2O_p(Double.parseDouble(String.format("%.2f",(67.60))));
            obezvozhivanie.setL_Check_p(100);

            obezvozhivanie.setS_KCl_v(Double.parseDouble(String.format("%.2f", posleVish.getS_KCl_v() + posleVish.getL_KCl_v() + penniy.getS_KCl_v() + penniy.getL_KCl_v() - obezvozhivanie.getL_KCl_v())));
            obezvozhivanie.setS_NaCl_v(Double.parseDouble(String.format("%.2f",posleVish.getS_NaCl_v() + posleVish.getL_NaCl_v() + penniy.getS_NaCl_v() + penniy.getL_NaCl_v() - obezvozhivanie.getL_NaCl_v())));
            obezvozhivanie.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", posleVish.getS_CaSO4_v() + posleVish.getL_CaSO4_v() + penniy.getS_CaSO4_v() + penniy.getL_CaSO4_v() - obezvozhivanie.getL_CaSO4_v())));
            obezvozhivanie.setS_Check_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getS_KCl_v()+ obezvozhivanie.getS_NaCl_v() + obezvozhivanie.getS_CaSO4_v())));

            obezvozhivanie.setS_KCl_p(Double.parseDouble(String.format("%.2f",(obezvozhivanie.getS_KCl_v()/ obezvozhivanie.getS_Check_v() * 100))));
            obezvozhivanie.setS_NaCl_p(Double.parseDouble(String.format("%.2f",(obezvozhivanie.getS_NaCl_v()/ obezvozhivanie.getS_Check_v() * 100))));
            obezvozhivanie.setS_CaSO4_p(Double.parseDouble(String.format("%.2f",(obezvozhivanie.getS_CaSO4_v()/ obezvozhivanie.getS_Check_v() * 100))));
            obezvozhivanie.setS_Check_p(100);


            //Peski
            peski.setS_KCl_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getS_KCl_v() * 0.9337)));
            peski.setS_NaCl_v(Double.parseDouble(String.format("%.2f",obezvozhivanie.getS_NaCl_v() * 0.9254)));
            peski.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getS_CaSO4_v() * 0.8498)));
            peski.setS_Check_v(Double.parseDouble(String.format("%.2f", peski.getS_KCl_v()+ peski.getS_NaCl_v() + peski.getS_CaSO4_v())));

            peski.setS_KCl_p(Double.parseDouble(String.format("%.2f",(peski.getS_KCl_v()/ peski.getS_Check_v() * 100))));
            peski.setS_NaCl_p(Double.parseDouble(String.format("%.2f",(peski.getS_NaCl_v()/ peski.getS_Check_v() * 100))));
            peski.setS_CaSO4_p(Double.parseDouble(String.format("%.2f",(peski.getS_CaSO4_v()/ peski.getS_Check_v() * 100))));
            peski.setS_Check_p(100);

            peski.setL_KCl_p(Double.parseDouble(String.format("%.2f",(12.00))));
            peski.setL_NaCl_p(Double.parseDouble(String.format("%.2f",(20.00))));
            peski.setL_CaSO4_p(Double.parseDouble(String.format("%.2f",(0.40))));
            peski.setH2O_p(Double.parseDouble(String.format("%.2f",(67.60))));
            peski.setL_Check_p(100);

            peski.setL_Check_v(Double.parseDouble(String.format("%.2f", peski.getS_Check_v() * 0.5)));
            peski.setL_KCl_v(Double.parseDouble(String.format("%.2f", peski.getL_Check_v() * peski.getL_KCl_p() / 100)));
            peski.setL_NaCl_v(Double.parseDouble(String.format("%.2f", peski.getL_Check_v() * peski.getL_NaCl_p() / 100)));
            peski.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", peski.getL_Check_v() * peski.getL_CaSO4_p() / 100)));
            peski.setH2O_v(Double.parseDouble(String.format("%.2f", peski.getL_Check_v() * peski.getH2O_p() / 100)));






            //Slivi
            slivi.setS_KCl_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getS_KCl_v() - peski.getS_KCl_v())));
            slivi.setS_NaCl_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getS_NaCl_v() - peski.getS_NaCl_v())));
            slivi.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getS_CaSO4_v() - peski.getS_CaSO4_v())));
            slivi.setS_Check_v(Double.parseDouble(String.format("%.2f", slivi.getS_KCl_v()+ slivi.getS_NaCl_v() + slivi.getS_CaSO4_v())));

            slivi.setS_KCl_p(Double.parseDouble(String.format("%.2f",(slivi.getS_KCl_v()/ slivi.getS_Check_v() * 100))));
            slivi.setS_NaCl_p(Double.parseDouble(String.format("%.2f",(slivi.getS_NaCl_v()/ slivi.getS_Check_v() * 100))));
            slivi.setS_CaSO4_p(Double.parseDouble(String.format("%.2f",(slivi.getS_CaSO4_v()/ slivi.getS_Check_v() * 100))));
            slivi.setS_Check_p(100);

            slivi.setL_KCl_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getL_KCl_v() - peski.getL_KCl_v())));
            slivi.setL_NaCl_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getL_NaCl_v() - peski.getL_NaCl_v())));
            slivi.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getL_CaSO4_v() - peski.getL_CaSO4_v())));
            slivi.setH2O_v(Double.parseDouble(String.format("%.2f", obezvozhivanie.getH2O_v() - peski.getH2O_v())));
            slivi.setL_Check_v(Double.parseDouble(String.format("%.2f", slivi.getH2O_v() + slivi.getL_KCl_v() + slivi.getL_NaCl_v() + slivi.getL_CaSO4_v())));

            slivi.setL_KCl_p(Double.parseDouble(String.format("%.2f",(12.00))));
            slivi.setL_NaCl_p(Double.parseDouble(String.format("%.2f",(20.00))));
            slivi.setL_CaSO4_p(Double.parseDouble(String.format("%.2f",(0.40))));
            slivi.setH2O_p(Double.parseDouble(String.format("%.2f",(67.60))));
            slivi.setL_Check_p(100);






            //Loading first sheet
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root = loader.load();

            // Optionally pass values to MainController
            MainController mainController = loader.getController();
            mainController.setFloto(floto);
            mainController.setFiltrat(filtrat);
            mainController.setPosleVish(posleVish);
            mainController.setPenniy(penniy);
            mainController.setObezvozhivanie(obezvozhivanie);
            mainController.setPeski(peski);
            mainController.setSlivi(slivi);
            mainController.setRedWater(redWater);
            mainController.updateAllLabels();


            // Get the current stage and set the new scene
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("KCL"); // Optional: change window title
            stage.show();


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

