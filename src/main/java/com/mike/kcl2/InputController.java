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
    @FXML private TextField mKekTextField2;
    @FXML private TextField tempTextField;
    @FXML private TextField densityTextField;
    @FXML private TextField redWaterTextField;
    @FXML private TextField techWaterTextField;
    @FXML private Label resultH2O;



    public void initData(InputValuesPrecentages inputValues) {
        this.inputValues = inputValues;

    }

    public void initialize() {
        mKekTextField.setPromptText("140 т/ч");
        mKekTextField2.setPromptText("0 т/ч");
        tempTextField.setPromptText("20, 25, или 30 t⁰C");
        densityTextField.setPromptText("1.20 т/м3");
        redWaterTextField.setPromptText("50 м3/ч");
        techWaterTextField.setPromptText("0 м3/ч");
    }

    @FXML
    private void SaveMenuItemClicked(ActionEvent event) {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);
        prefs.put("mKek", mKekTextField.getText());
        prefs.put("mKek2", mKekTextField2.getText());
        prefs.put("temp", tempTextField.getText());
        prefs.put("density", densityTextField.getText());
        prefs.put("red water", redWaterTextField.getText());
        prefs.put("tech water", techWaterTextField.getText());
    }
    @FXML
    public void LoadMenuItemClicked() {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);

        mKekTextField.setText(prefs.get("mKek", ""));
        mKekTextField2.setText(prefs.get("mKek2", ""));
        tempTextField.setText(prefs.get("temp", ""));
        densityTextField.setText(prefs.get("density", ""));
        redWaterTextField.setText(prefs.get("red water", ""));
        techWaterTextField.setText(prefs.get("tech water", ""));
    }
    @FXML
    private void DeleteMenuItemClicked(ActionEvent event) {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);

        mKekTextField.clear();
        mKekTextField2.clear();
        tempTextField.clear();
        densityTextField.clear();
        redWaterTextField.clear();
        techWaterTextField.clear();
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

            double redWater1 = Double.parseDouble(redWaterTextField.getText());
            double techWater1 = Double.parseDouble(techWaterTextField.getText());
            double agent = (redWater1 + techWater1) * 1.04;
            int temp = Integer.parseInt(tempTextField.getText());
            double density = Double.parseDouble(densityTextField.getText());
            double mKek1 = Double.parseDouble(mKekTextField.getText());
            double mKek2 = Double.parseDouble(mKekTextField2.getText());
            System.out.println("Agent : "+agent);
            System.out.println("mKek1 : "+mKek1);
            System.out.println("mKek2 : "+mKek2);
            double mKek = mKek1 +mKek2;
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


            DensityPercentageLookup.DensityData densityData = DensityPercentageLookup.findPercentages(temp, density);
            double naclPercentage = densityData.naclPercentage;
            double kclPercentage = densityData.kclPercentage;
            double caso4Percentage = 0.4;
            double waterPercentage = 100 - (naclPercentage + kclPercentage + caso4Percentage);


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

            System.out.println("kek: "+mKek);

            floto.setL_KCl_p(12);
            floto.setL_NaCl_p(20);
            floto.setL_CaSO4_p(0.4);
            floto.setH2O_p(67.6);

            floto.setS_KCl_p(90);
            floto.setS_NaCl_p(7);
            floto.setS_CaSO4_p(3);

            floto.setS_Check_v(Double.parseDouble(String.format("%.2f", mKek*1.15)));
            floto.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", (floto.getS_Check_v()/100)* floto.getS_CaSO4_p())));
            floto.setS_NaCl_v(Double.parseDouble(String.format("%.2f", (floto.getS_Check_v()/100)* floto.getS_NaCl_p())));
            floto.setS_KCl_v(Double.parseDouble(String.format("%.2f", (floto.getS_Check_v()/100)* floto.getS_KCl_p())));

            System.out.println("floto SCaSO4: "+floto.getS_CaSO4_v());
            System.out.println("floto SNaCl: "+floto.getS_NaCl_v());
            System.out.println("floto SKCl: "+floto.getS_KCl_v());
            System.out.println("floto Scheck: "+floto.getS_Check_v());
            System.out.println(" ");

            floto.setL_Check_v(Double.parseDouble(String.format("%.2f", floto.getS_Check_v()*0.8)));
            floto.setH2O_v(Double.parseDouble(String.format("%.2f", (floto.getL_Check_v()/100)* floto.getH2O_p())));
            floto.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", (floto.getL_Check_v()/100)* floto.getL_CaSO4_p())));
            floto.setL_NaCl_v(Double.parseDouble(String.format("%.2f", (floto.getL_Check_v()/100)* floto.getL_NaCl_p())));
            floto.setL_KCl_v(Double.parseDouble(String.format("%.2f", (floto.getL_Check_v()/100)* floto.getL_KCl_p())));

            System.out.println("floto H2O: "+floto.getH2O_v());
            System.out.println("floto LCaSO4: "+floto.getL_CaSO4_v());
            System.out.println("floto LNaCl: "+floto.getL_NaCl_v());
            System.out.println("floto LKCl: "+floto.getL_KCl_v());
            System.out.println("floto Lcheck: "+floto.getL_Check_v());
            System.out.println(" ");





            posleVish.setL_NaCl_p((Double.parseDouble(String.format("%.2f",18.0))));  // Set NaCl percentage from lookup
            posleVish.setL_KCl_p((Double.parseDouble(String.format("%.2f", 12.1))));    // Set KCl percentage from lookup
            posleVish.setL_CaSO4_p(0.4);
            double waterPercentagePosleVish = 100 - posleVish.getL_NaCl_p() - posleVish.getL_KCl_p() - 0.4;
            posleVish.setH2O_p((Double.parseDouble(String.format("%.2f",waterPercentagePosleVish))));
            posleVish.setL_Check_p(100);

            double waterTotal = floto.getH2O_v() + agent;
            double Na = naclPercentage* (waterTotal/waterPercentage);
            double waterTotalCalculated = (Na/16.6) *70.34;
            double waterCorrection = waterTotalCalculated - waterTotal;
            double waterCorrectionCalculated = (agent + waterCorrection);


            posleVish.setH2O_v(Double.parseDouble(String.format("%.2f", floto.getH2O_v())));
            posleVish.setL_KCl_v(Double.parseDouble(String.format("%.2f", result.getL_KCl_p()* result.getH2O_v()/ result.getH2O_p()+result.getS_NaCl_v())));
            posleVish.setL_NaCl_v(Double.parseDouble(String.format("%.2f", floto.getS_NaCl_v()+floto.getL_NaCl_v()+redWater.getL_NaCl_v()- result.getS_NaCl_v())));
            posleVish.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", 0.4 * result.getH2O_v()/result.getH2O_p())));
            posleVish.setL_Check_v(Double.parseDouble(String.format("%.2f", posleVish.getH2O_v() + posleVish.getL_KCl_v() + posleVish.getL_NaCl_v() + posleVish.getL_CaSO4_v())));

            posleVish.setS_KCl_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_v() + floto.getL_KCl_v() + redWater.getL_KCl_v() - result.getL_KCl_v())));
            posleVish.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", floto.getS_CaSO4_v() + floto.getL_CaSO4_v() + redWater.getL_CaSO4_v() - result.getL_CaSO4_v())));
            posleVish.setS_Check_v(Double.parseDouble(String.format("%.2f", result.getS_KCl_v() + result.getS_NaCl_v() + result.getS_CaSO4_v())));
            posleVish.setS_NaCl_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_v()/100 * 0.68)));

            posleVish.setS_KCl_p(Double.parseDouble(String.format("%.2f", (result.getS_KCl_v() / result.getS_Check_v() * 100))));
            posleVish.setS_NaCl_p(Double.parseDouble(String.format("%.2f", (result.getS_NaCl_v() / result.getS_Check_v() * 100))));
            posleVish.setS_CaSO4_p(Double.parseDouble(String.format("%.2f", (result.getS_CaSO4_v() / result.getS_Check_v() * 100))));
            posleVish.setS_Check_p(100);




            System.out.println("KCl: "+posleVish.getL_KCl_p()+" %");
            System.out.println("NaCl: "+posleVish.getL_NaCl_p()+" %");
            System.out.println("NaCl: " + posleVish.getL_NaCl_v());


            System.out.println("na: " + Na);
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

