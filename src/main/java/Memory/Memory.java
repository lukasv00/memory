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
import javafx.stage.Stage;

public class Memory extends Application {
    private final Board board = new Board();

    //Playground
    private Pane playground = board.playGround();

    public static void main (String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image imagebackPlayGround = new Image("Background.jpg");
        BackgroundSize backgroundSizePlayGround = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImagePlayGround = new BackgroundImage(imagebackPlayGround, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizePlayGround);
        Background backgroundPlayGround = new Background(backgroundImagePlayGround);

       //Main grid
        GridPane grid = new GridPane();
        grid.setBackground(backgroundPlayGround);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 40));
        grid.setHgap(10);
        grid.setVgap(10);


        //Exit button
        FlowPane buttonExit = new FlowPane(Orientation.HORIZONTAL);
        Button exit = new Button("EXIT");
        exit.setOnAction((e) -> System.exit(0));
        buttonExit.getChildren().add(exit);

        //Start button
        FlowPane buttonStart = new FlowPane(Orientation.HORIZONTAL);
        Button start = new Button("START");
        start.setOnAction((e) -> grid.add(playground, 0,3, 15, 50));
        buttonStart.getChildren().add(start);

        grid.add(buttonStart, 0, 0, 1, 1);
        grid.add(buttonExit, 1, 0, 1, 1);
        grid.add(board.counterLabelBuilder(), 2, 0, 1, 1);
        grid.add(board.movesLabelBuilder(), 2, 1, 1, 1);
        grid.add(board.gameEndLabel(), 2, 2, 1, 1);


        Scene playScene = new Scene(grid, 1400, 900, Color.BLACK);

        primaryStage.setScene(playScene);
        primaryStage.setTitle("Romper");
        primaryStage.show();

    }

}
