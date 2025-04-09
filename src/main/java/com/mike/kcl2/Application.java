package com.mike.kcl2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Pitanie.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("KCL");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        MainController controller = fxmlLoader.getController();

        InputValuesPrecentages inputValuesPrecentages = new InputValuesPrecentages();
        controller.initData(inputValuesPrecentages);
        Material floto = new Material();

    }

    public static void main(String[] args) {
        launch();
    }
}