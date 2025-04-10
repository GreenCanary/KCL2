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

import java.io.IOException;

public class InputController {

    private InputValuesPrecentages inputValues;
    private PitanieController pitanieController;
    private Material floto;
    private Material filtrat;
    private Material posleVish;
    private Material penniyProduct;
    private Material obezvozhivanie;
    private Material slivi;
    private Material peski;
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
            double l_KCl_p = Double.parseDouble(KClRedWaterTextField.getText());
            double l_NaCl_p = Double.parseDouble(NaClRedWaterTextField.getText());
            double l_CaSO4_p = Double.parseDouble(CaSO4RedWaterTextField.getText());
            double H2O_p = Double.parseDouble(H2ORedWaterTextField.getText());


            // Print parsed values to check if they are correct
            System.out.println("Parsed Red Water values:");
            System.out.println("mRedWater: " + mRedWater);
            System.out.println("l_KCl_p: " + l_KCl_p);
            System.out.println("l_NaCl_p: " + l_NaCl_p);
            System.out.println("l_CaSO4_p: " + l_CaSO4_p);
            System.out.println("H2O_p: " + H2O_p);

            // Read and parse solid input fields and store in the corresponding properties
            double slRatio = Double.parseDouble(slRatioTextField.getText());
            double mTotal = Double.parseDouble(mTotalTextField.getText());

            double mSolid = mTotal * slRatio;
            double mLiquid = mTotal - mSolid;
            double s_KCL_p = Double.parseDouble(KClSolidTextField.getText());
            double s_NaCl_p = Double.parseDouble(NaClSolidTextField.getText());
            double s_CaSO4_p = Double.parseDouble(CaSO4SolidTextField.getText());


//             Print parsed solid values to check if they are correct
            System.out.println("Parsed Solid values:");
            System.out.println("mTotal: " + mTotal);
            System.out.println("s_KCL_p: " + s_KCL_p);
            System.out.println("s_NaCl_p: " + s_NaCl_p);
            System.out.println("s_CaSO4_p: " + s_CaSO4_p);
            System.out.println("slRatio: " + slRatio);

            double sumLiquidPercentages = l_KCl_p + l_NaCl_p + l_CaSO4_p + H2O_p;
            if (sumLiquidPercentages != 100) {
                // Create an alert to show the error message
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Ошибка: Процентные значения для жидкой фазы не равны 100%. Сумма: " + sumLiquidPercentages,
                        ButtonType.OK);
                alert.setTitle("Ошибка ввода");
                alert.showAndWait();
                return; // Exit the method if the check fails
            }
            double sumSolidPercentages = s_KCL_p + s_NaCl_p + s_CaSO4_p;
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

            // Set the values
            inputValues.setmRedWater(mRedWater);
            inputValues.setL_KCl_p(l_KCl_p);
            inputValues.setL_NaCl_p(l_NaCl_p);
            inputValues.setL_CaSO4_p(l_CaSO4_p);
            inputValues.setH2O_p(H2O_p);

            inputValues.setmTotal(mTotal);
            inputValues.setS_KCL_p(s_KCL_p);
            inputValues.setS_NaCl_p(s_NaCl_p);
            inputValues.setS_CaSO4_p(s_CaSO4_p);
            inputValues.setSlRatio(slRatio);

            // Print values after they are set in inputValues to check if they are correctly assigned
            System.out.println("Values after being set in InputValuesPrecentages object:");
            System.out.println("mRedWater: " + inputValues.getmRedWater());
            System.out.println("l_KCl_p: " + inputValues.getL_KCL_p());
            System.out.println("l_NaCl_p: " + inputValues.getL_NaCl_p());
            System.out.println("l_CaSO4_p: " + inputValues.getL_CaSO4_p());
            System.out.println("H2O_p: " + inputValues.getH2O_p());

            System.out.println("mTotal: " + inputValues.getmTotal());
            System.out.println("s_KCL_p: " + inputValues.getS_KCL_p());
            System.out.println("s_NaCl_p: " + inputValues.getS_NaCl_p());
            System.out.println("s_CaSO4_p: " + inputValues.getS_CaSO4_p());
            System.out.println("slRatio: " + inputValues.getSlRatio());

            // floto time

            floto.setmSolid(mSolid);
            floto.setS_KCl_p(s_KCL_p);
            floto.setS_NaCl_p(s_NaCl_p);
            floto.setS_CaSO4_p(s_CaSO4_p);
            floto.setSlRatio(slRatio);

            floto.setmLiquid(mLiquid);
            floto.setL_KCl_p(12);
            floto.setL_NaCl_p(20);
            floto.setL_CaSO4_p(0.4);
            floto.setH2O_p(67.6);

            floto.setS_KCl_v(s_KCL_p * mSolid/100);
            floto.setS_NaCl_v(s_NaCl_p * mSolid/100);
            floto.setS_CaSO4_v(s_CaSO4_p * mSolid/100);

            floto.setL_KCl_v(12 * mLiquid/100);
            floto.setL_NaCl_v(20 * mLiquid/100);
            floto.setL_CaSO4_v(0.4 * mLiquid/100);
            floto.setH2O_v(67.6 * mLiquid/100);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pitanie.fxml"));
            Parent root = loader.load();

            // Optionally pass values to PitanieController
            PitanieController pitanieController = loader.getController();
            pitanieController.setSolidKClPercentage(floto.getS_KCl_p());

            // Get the current stage and set the new scene
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Питание"); // Optional: change window title
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

