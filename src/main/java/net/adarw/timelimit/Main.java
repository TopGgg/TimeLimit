package net.adarw.timelimit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application {

    public boolean development = true;

    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED); //remove window control buttons

        double width = stage.getMaxWidth();
        double height = stage.getMaxHeight();
        Scene scene = new Scene(new FXMLLoader(Main.class.getResource("main-view.fxml")).load(), width, height);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setAlwaysOnTop(true);
        stage.setTitle("Time Limit");
        //handle keyboard "shortcuts".
        Platform.setImplicitExit(false);
        stage.setOnCloseRequest(Event::consume);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.isShiftDown() && event.isAltDown() && event.isControlDown() && event.getCode().equals(KeyCode.F9) && development) {
                System.exit(1000);
            }else if(event.getCode().equals(KeyCode.ESCAPE)){
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("");
            }
        });
        stage.setScene(scene);
        //show the scene
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}