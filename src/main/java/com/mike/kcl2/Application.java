package com.mike.kcl2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("PopOutInput.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Внесите данные");
        stage.setScene(scene);
        stage.show();

        InputController controller = fxmlLoader.getController();

        InputValuesPrecentages inputValuesPrecentages = new InputValuesPrecentages();
        controller.initData(inputValuesPrecentages);


    }

    public static void main(String[] args) {
        launch();
    }
}