package com.mike.kcl2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static StackPane rootContainer;
    @Override
    public void start(Stage stage) throws IOException {
        rootContainer = new StackPane();

        try {
            Parent initialView = FXMLLoader.load(getClass().getResource("PopOutInput.fxml"));
            rootContainer.getChildren().setAll(initialView);
        } catch (IOException e) {
            e.printStackTrace(); // Show error if FXML fails to load
        }

        Scene scene = new Scene(rootContainer);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("esc чтобы закрыть программу");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                stage.close();   // closes the stage
                // OR Platform.exit();  // exits the whole application
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
    public static StackPane getRootContainer() {
        return rootContainer;
    }
}