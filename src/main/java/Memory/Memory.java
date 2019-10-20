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
    int time = 0;
    private final BoardScene boardScener = new BoardScene();
    private final Board board = new Board();
    private final Scoreboard scoreboard = new Scoreboard();

    public Memory() throws IOException {
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image imagebackIntro = new Image("ROMPER_Entry.jpg");
        BackgroundSize backgroundSizeIntro = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImageIntro = new BackgroundImage(imagebackIntro, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeIntro);
        Background backgroundIntro = new Background(backgroundImageIntro);

        //DIFFICULTY
        GridPane difficultyGrid = new GridPane();
        difficultyGrid.setBackground(backgroundIntro);
        difficultyGrid.setAlignment(Pos.TOP_LEFT);
        difficultyGrid.setPadding(new Insets(11.5, 12.5, 13.5, 550));
        difficultyGrid.setHgap(10);
        difficultyGrid.setVgap(10);

        //Easy button
        FlowPane buttonEasy = new FlowPane(Orientation.HORIZONTAL);
        Button easy = new Button("EASY");
        easy.setPrefSize(100, 50);
        easy.setPrefSize(100, 50);
        easy.setFont(new Font("Arial", 18));
        easy.setTextFill(Color.BLACK);
        easy.setOnAction((e) -> primaryStage.setScene(boardScener.boardScene(1000)));
        buttonEasy.getChildren().add(easy);

        //Medium button
        FlowPane buttonMedium = new FlowPane(Orientation.HORIZONTAL);
        Button medium = new Button("MEDIUM");
        medium.setPrefSize(100, 50);
        medium.setPrefSize(100, 50);
        medium.setFont(new Font("Arial", 18));
        medium.setTextFill(Color.BLACK);
        medium.setOnAction((e) -> primaryStage.setScene(boardScener.boardScene(500)));
        buttonMedium.getChildren().add(medium);

        //Hard button
        FlowPane buttonHard = new FlowPane(Orientation.HORIZONTAL);
        Button hard = new Button("HARD");
        hard.setPrefSize(100, 50);
        hard.setPrefSize(100, 50);
        hard.setFont(new Font("Arial", 18));
        hard.setTextFill(Color.BLACK);
        hard.setOnAction((e) -> primaryStage.setScene(boardScener.boardScene(200)));
        buttonHard.getChildren().add(hard);

        difficultyGrid.add(buttonEasy, 10, 50, 1, 1);
        difficultyGrid.add(buttonMedium, 10, 55, 1, 1);
        difficultyGrid.add(buttonHard, 10, 60, 1, 1);

        Scene difficultyScene = new Scene(difficultyGrid, 1400, 900, Color.BLACK);


        //INTRO
        GridPane introGrid = new GridPane();
        introGrid.setBackground(backgroundIntro);
        introGrid.setAlignment(Pos.TOP_LEFT);
        introGrid.setPadding(new Insets(11.5, 12.5, 13.5, 300));
        introGrid.setHgap(10);
        introGrid.setVgap(10);

        //Exit button
        FlowPane buttonExit = new FlowPane(Orientation.HORIZONTAL);
        Button exit = new Button("EXIT");
        exit.setPrefSize(100, 50);
        exit.setPrefSize(100, 50);
        exit.setFont(new Font("Arial", 18));
        exit.setTextFill(Color.BLACK);
        exit.setOnAction((e) -> System.exit(0));
        buttonExit.getChildren().add(exit);

        //Start button
        FlowPane buttonStart = new FlowPane(Orientation.HORIZONTAL);
        Button start = new Button("START");
        start.setPrefSize(100, 50);
        start.setFont(new Font("Arial", 18));
        start.setTextFill(Color.BLACK);
        start.setOnAction((e) -> primaryStage.setScene(difficultyScene));
        buttonStart.getChildren().add(start);

        introGrid.add(buttonStart, 10, 65, 1, 1);
        introGrid.add(buttonExit, 20, 65, 1, 1);

        Scene introScene = new Scene(introGrid, 1400, 900, Color.BLACK);

        if(board.isGameEnd() == true){
            primaryStage.setScene(scoreboard.scoreScene());
        }


        primaryStage.setScene(introScene);
        primaryStage.setTitle("Romper");
        primaryStage.show();

    }

}
