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
            double slRatio = 0.8;
            double mTotal = 396.0;

            double mLiquid = (mTotal * slRatio)/(slRatio + 1);
            double mSolid = mTotal - mLiquid;
            double s_KCl_p = 90.0;
            double s_NaCl_p = 7.0;
            double s_CaSO4_p = 3.0;


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

