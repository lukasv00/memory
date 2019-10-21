package Memory;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Memory extends Application {
    private final BoardScene boardScener = new BoardScene();

    public Memory() throws IOException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Image imagebackIntro = new Image("ROMPER_Entry.jpg");
        BackgroundSize backgroundSizeIntro = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImageIntro = new BackgroundImage(imagebackIntro, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeIntro);
        Background backgroundIntro = new Background(backgroundImageIntro);

        //DIFFICULTY
        GridPane difficultyGrid = getGridPane(backgroundIntro);

        FlowPane buttonEasy = getFlowPaneButton(boardScener.boardScene(1000), primaryStage, "EASY");
        FlowPane buttonMedium = getFlowPaneButton(boardScener.boardScene(400), primaryStage, "MEDIUM");
        FlowPane buttonHard = getFlowPaneButton(boardScener.boardScene(100), primaryStage, "HARD");

        difficultyGrid.add(buttonEasy, 35, 50, 1, 1);
        difficultyGrid.add(buttonMedium, 35, 55, 1, 1);
        difficultyGrid.add(buttonHard, 35, 60, 1, 1);

        Scene difficultyScene = new Scene(difficultyGrid, 1400, 900, Color.BLACK);


        //INTRO
        GridPane introGrid = getGridPane(backgroundIntro);

        FlowPane buttonStart = getFlowPaneButton(difficultyScene, primaryStage, "START");

        introGrid.add(buttonStart, 35, 65, 1, 1);

        Scene introScene = new Scene(introGrid, 1400, 900, Color.BLACK);

        primaryStage.setScene(introScene);
        primaryStage.setTitle("Romper");
        primaryStage.show();

    }

    private GridPane getGridPane(Background backgroundIntro) {
        GridPane difficultyGrid = new GridPane();
        difficultyGrid.setBackground(backgroundIntro);
        difficultyGrid.setAlignment(Pos.TOP_LEFT);
        difficultyGrid.setPadding(new Insets(11.5, 12.5, 13.5, 300));
        difficultyGrid.setHgap(10);
        difficultyGrid.setVgap(10);
        return difficultyGrid;
    }

    private FlowPane getFlowPaneButton(Scene scene, Stage primaryStage, String buttonText) { //nowa klasa (stat metody) - buttons + setScene
        FlowPane buttonPane = new FlowPane(Orientation.HORIZONTAL);
        Button button = new Button(buttonText);
        button.setPrefSize(100, 50);
        button.setPrefSize(100, 50);
        button.setFont(new Font("Arial", 18));
        button.setTextFill(Color.BLACK);
        button.setOnAction((e) -> primaryStage.setScene(scene));
        buttonPane.getChildren().add(button);
        return buttonPane;
    }

}

