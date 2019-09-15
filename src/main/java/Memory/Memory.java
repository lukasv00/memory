package Memory;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class Memory extends Application {
    private final Deck deck = new Deck();

    public static void main (String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        List<Image> cards = deck.cardsDeckPreparation();

        Image imagebackPlayGround = new Image("Background.jpg");
        BackgroundSize backgroundSizePlayGround = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImagePlayGround = new BackgroundImage(imagebackPlayGround, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizePlayGround);
        Background backgroundPlayGround = new Background(backgroundImagePlayGround);

        //Start button
        FlowPane buttonStart = new FlowPane(Orientation.HORIZONTAL);
        Button start = new Button("START");
        //start.setOnAction((e) -> );
        buttonStart.getChildren().add(start);

        //Exit button
        FlowPane buttonExit = new FlowPane(Orientation.HORIZONTAL);
        Button exit = new Button("EXIT");
        exit.setOnAction((e) -> System.exit(0));
        buttonExit.getChildren().add(exit);

        //Playground
        TilePane cardsPane = new TilePane();
        cardsPane.setAlignment(Pos.BASELINE_CENTER);
        cardsPane.setLayoutX(0);
        cardsPane.setPadding(new Insets(0,0,0,350));
        cardsPane.setLayoutY(0);
        cardsPane.setHgap(120);
        cardsPane.setVgap(10);
        cardsPane.setPrefColumns(4);
        cardsPane.setPrefRows(4);
        for (Image card: cards) {
            ImageView imageView = ImageViewBuilder.create()
                    .preserveRatio(true)
                    .fitHeight(200)
                    .image(card)
                    .build();
            cardsPane.getChildren().add(imageView);
        }


       //Main grid
        GridPane grid = new GridPane();
        grid.setBackground(backgroundPlayGround);
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 50));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(buttonExit, 0, 0, 1, 1);
        grid.add(buttonStart, 0, 50, 1, 1);
        grid.add(cardsPane, 0,20, 10, 10);

        Scene playScene = new Scene(grid, 1400, 900, Color.BLACK);

        primaryStage.setScene(playScene);
        primaryStage.setTitle("Romper");
        primaryStage.show();



    }

}
