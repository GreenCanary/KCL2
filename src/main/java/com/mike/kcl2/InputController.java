package com.mike.kcl2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

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
    @FXML private TextField redWaterTextField;
    @FXML private TextField techWaterTextField;

    @FXML private Label resultH2Ored;
    @FXML private Label resultH2Otech;

    @FXML private Label agentSumLabel;
    @FXML private Label vesovoyLabel;
    @FXML private Label rashodLabel;

    @FXML private Label calculatedAgentLabel;
    @FXML private Label calculatedRedWaterLabel;
    @FXML private Label correctionRedWaterLabel;
    @FXML private Label calculatedTechWaterLabel;
    @FXML private Label changeH2OLabel;
    @FXML private Label neededRashodLabel;


    public void initData(InputValuesPrecentages inputValues) {
        this.inputValues = inputValues;

    }

    public void initialize() {
        mKekTextField.setPromptText("140 т/ч");
        tempTextField.setPromptText("20, 25, или 30 t⁰C");
        densityTextField.setPromptText("1.20 т/м3");
        redWaterTextField.setPromptText("50 м3/ч");
        techWaterTextField.setPromptText("0 м3/ч");
    }

    @FXML
    private void SaveMenuItemClicked(ActionEvent event) {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);
        prefs.put("mKek", mKekTextField.getText());
        prefs.put("temp", tempTextField.getText());
        prefs.put("density", densityTextField.getText());
        prefs.put("red water", redWaterTextField.getText());
        prefs.put("tech water", techWaterTextField.getText());
    }
    @FXML
    public void LoadMenuItemClicked() {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);

        mKekTextField.setText(prefs.get("mKek", ""));
        tempTextField.setText(prefs.get("temp", ""));
        densityTextField.setText(prefs.get("density", ""));
        redWaterTextField.setText(prefs.get("red water", ""));
        techWaterTextField.setText(prefs.get("tech water", ""));
    }
    @FXML
    private void DeleteMenuItemClicked(ActionEvent event) {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);

        mKekTextField.clear();
        tempTextField.clear();
        densityTextField.clear();
        redWaterTextField.clear();
        techWaterTextField.clear();
    }

    @FXML
    private void ExitMenuItemClicked(ActionEvent event) {
        Preferences prefs = Preferences.userNodeForPackage(InputController.class);
        javafx.application.Platform.exit();
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


            double redWater1 = Double.parseDouble(redWaterTextField.getText().replace(',', '.'));
            double techWater1 = Double.parseDouble(techWaterTextField.getText().replace(',', '.'));
            double agent = (redWater1 + techWater1) * 1.04;
            int temp = Integer.parseInt(tempTextField.getText());
            double density = Double.parseDouble(densityTextField.getText().replace(',', '.'));
            double mKek1 = Double.parseDouble(mKekTextField.getText().replace(',', '.'));
            System.out.println("Agent : " + agent);
            System.out.println("mKek1 : " + mKek1);
            double mKek = mKek1;
            double moist = 0.055;
            double slRatio = 0.8;
            double mTotal = 396.0;


            double mLiquid = (mTotal * slRatio) / (slRatio + 1);
            double mSolid = mTotal - mLiquid;
            double s_KCl_p = 90.0;
            double s_NaCl_p = 7.0;
            double s_CaSO4_p = 3.0;

            if (temp != 20 && temp != 25 && temp != 30) {
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
            double waterPercentage = (100 - (naclPercentage + kclPercentage + caso4Percentage));
            double waterPercentageMass = 0;
            if (temp == 20) {
                waterPercentageMass = 70.58;
            }
            if (temp == 25) {
                waterPercentageMass = 70.21;
            }
            if (temp == 30) {
                waterPercentageMass = 69.51;
            }


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

            System.out.println("kek: " + mKek);

            floto.setL_KCl_p(12);
            floto.setL_NaCl_p(20);
            floto.setL_CaSO4_p(0.4);
            floto.setH2O_p(67.6);

            floto.setS_KCl_p(90);
            floto.setS_NaCl_p(7);
            floto.setS_CaSO4_p(3);

            floto.setS_Check_v(Double.parseDouble(String.format("%.2f", mKek * 1.15)));
            floto.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", (floto.getS_Check_v() / 100) * floto.getS_CaSO4_p())));
            floto.setS_NaCl_v(Double.parseDouble(String.format("%.2f", (floto.getS_Check_v() / 100) * floto.getS_NaCl_p())));
            floto.setS_KCl_v(Double.parseDouble(String.format("%.2f", (floto.getS_Check_v() / 100) * floto.getS_KCl_p())));

            System.out.println("floto SCaSO4: " + floto.getS_CaSO4_v());
            System.out.println("floto SNaCl: " + floto.getS_NaCl_v());
            System.out.println("floto SKCl: " + floto.getS_KCl_v());
            System.out.println("floto Scheck: " + floto.getS_Check_v());
            System.out.println(" ");

            floto.setL_Check_v(Double.parseDouble(String.format("%.2f", floto.getS_Check_v() * 0.8)));
            floto.setH2O_v(Double.parseDouble(String.format("%.2f", (floto.getL_Check_v() / 100) * floto.getH2O_p())));
            floto.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", (floto.getL_Check_v() / 100) * floto.getL_CaSO4_p())));
            floto.setL_NaCl_v(Double.parseDouble(String.format("%.2f", (floto.getL_Check_v() / 100) * floto.getL_NaCl_p())));
            floto.setL_KCl_v(Double.parseDouble(String.format("%.2f", (floto.getL_Check_v() / 100) * floto.getL_KCl_p())));

            System.out.println("floto H2O: " + floto.getH2O_v());
            System.out.println("floto LCaSO4: " + floto.getL_CaSO4_v());
            System.out.println("floto LNaCl: " + floto.getL_NaCl_v());
            System.out.println("floto LKCl: " + floto.getL_KCl_v());
            System.out.println("floto Lcheck: " + floto.getL_Check_v());
            System.out.println(" ");


            posleVish.setL_NaCl_p((Double.parseDouble(String.format("%.2f", naclPercentage))));  // Set NaCl percentage from lookup
            posleVish.setL_KCl_p((Double.parseDouble(String.format("%.2f", kclPercentage))));    // Set KCl percentage from lookup
            posleVish.setL_CaSO4_p(0.4);
            double waterPercentagePosleVish = 100 - (posleVish.getL_NaCl_p() + posleVish.getL_KCl_p() + 0.4);
            posleVish.setH2O_p((Double.parseDouble(String.format("%.2f", waterPercentagePosleVish))));
            posleVish.setL_Check_p(100);

            double waterTotal = floto.getH2O_v() + agent;
            double Na = naclPercentage * (waterTotal / waterPercentage);
            double onePercentWater = Na / 16.9;
            double waterTotalCalculated = onePercentWater * waterPercentageMass;
            double waterCorrection = waterTotalCalculated - waterTotal;
            double waterCorrectionCalculated = (agent + waterCorrection);


            posleVish.setH2O_v(Double.parseDouble(String.format("%.2f", floto.getH2O_v())));
            posleVish.setL_KCl_v(Double.parseDouble(String.format("%.2f", result.getL_KCl_p() * result.getH2O_v() / result.getH2O_p() + result.getS_NaCl_v())));
            posleVish.setL_NaCl_v(Double.parseDouble(String.format("%.2f", floto.getS_NaCl_v() + floto.getL_NaCl_v() + redWater.getL_NaCl_v() - result.getS_NaCl_v())));
            posleVish.setL_CaSO4_v(Double.parseDouble(String.format("%.2f", 0.4 * result.getH2O_v() / result.getH2O_p())));
            posleVish.setL_Check_v(Double.parseDouble(String.format("%.2f", posleVish.getH2O_v() + posleVish.getL_KCl_v() + posleVish.getL_NaCl_v() + posleVish.getL_CaSO4_v())));

            posleVish.setS_KCl_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_v() + floto.getL_KCl_v() + redWater.getL_KCl_v() - result.getL_KCl_v())));
            posleVish.setS_CaSO4_v(Double.parseDouble(String.format("%.2f", floto.getS_CaSO4_v() + floto.getL_CaSO4_v() + redWater.getL_CaSO4_v() - result.getL_CaSO4_v())));
            posleVish.setS_Check_v(Double.parseDouble(String.format("%.2f", result.getS_KCl_v() + result.getS_NaCl_v() + result.getS_CaSO4_v())));
            posleVish.setS_NaCl_v(Double.parseDouble(String.format("%.2f", floto.getS_KCl_v() / 100 * 0.68)));

            posleVish.setS_KCl_p(Double.parseDouble(String.format("%.2f", (result.getS_KCl_v() / result.getS_Check_v() * 100))));
            posleVish.setS_NaCl_p(Double.parseDouble(String.format("%.2f", (result.getS_NaCl_v() / result.getS_Check_v() * 100))));
            posleVish.setS_CaSO4_p(Double.parseDouble(String.format("%.2f", (result.getS_CaSO4_v() / result.getS_Check_v() * 100))));
            posleVish.setS_Check_p(100);


            System.out.println("KCl: " + posleVish.getL_KCl_p() + " %");
            System.out.println("NaCl: " + posleVish.getL_NaCl_p() + " %");
            System.out.println("NaCl: " + posleVish.getL_NaCl_v());


            System.out.println("na: " + Na);
            System.out.println("onePercentWater: " + onePercentWater);
            System.out.println("WaterPrecentage: " + waterPercentage);
            System.out.println("water total: " + waterTotal);
            System.out.println("water total calculated: " + waterTotalCalculated);
            System.out.println("water correction: " + waterCorrection);
            System.out.println("water correction calculated: " + waterCorrectionCalculated);

            double redWaterCorrectionCalculated = 0;
            double techWaterCorrectionCalculated = 0;
            double resultCorrection = agent + waterCorrection;

            if (resultCorrection / 1.04 > redWater1) {
                redWaterCorrectionCalculated = redWater1;
            } else {
                redWaterCorrectionCalculated = resultCorrection / 1.04;
            }

            techWaterCorrectionCalculated = (resultCorrection / 1.04) - redWaterCorrectionCalculated;
            setLabelValue(resultH2Ored, (Double.parseDouble(String.format("%.2f", redWaterCorrectionCalculated))));
            setLabelValue(resultH2Otech, (Double.parseDouble(String.format("%.2f", techWaterCorrectionCalculated))));

            setLabelValue(agentSumLabel, (Double.parseDouble(String.format("%.2f", agent / 1.04))));
            setLabelValue(vesovoyLabel, (Double.parseDouble(String.format("%.2f", mKek))));
            double rashod = agent / mKek;
            setLabelValue(rashodLabel, (Double.parseDouble(String.format("%.2f", rashod))));

            setLabelValue(calculatedAgentLabel, (Double.parseDouble(String.format("%.2f", waterCorrectionCalculated / 1.04))));
            setLabelValue(calculatedRedWaterLabel, (Double.parseDouble(String.format("%.2f", redWaterCorrectionCalculated))));
            setLabelValue(correctionRedWaterLabel, (Double.parseDouble(String.format("%.2f", redWaterCorrectionCalculated - redWater1))));
            setLabelValue(calculatedTechWaterLabel, (Double.parseDouble(String.format("%.2f", waterCorrectionCalculated / 1.04 - redWaterCorrectionCalculated))));
            setLabelValue(changeH2OLabel, (Double.parseDouble(String.format("%.2f", techWaterCorrectionCalculated - techWater1))));
            setLabelValue(neededRashodLabel, (Double.parseDouble(String.format("%.2f", (waterCorrectionCalculated / 1.04) / mKek))));


        } catch (NumberFormatException e) {
            System.err.println("Ошибка ввода: убедитесь, что все поля заполнены числами.");
            // Optional: show an alert dialog to the user
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ошибка ввода: убедитесь, что все поля заполнены числами.", ButtonType.OK);
            alert.setTitle("Ошибка ввода");
            alert.showAndWait();

        }

    }
}

