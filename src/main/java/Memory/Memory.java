package Memory;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Memory extends Application {

    private Image imageback = new Image("Background.jpg");

    private Image cardFAXE = new Image("FAXE_CARD.jpg");
    //private Image cardHARNAS = new Image("HARNAS_CARD.png");
    private Image cardKARPACKIE = new Image("KARPACKIE_CARD.jpg");
    private Image cardKUFLOWE = new Image("KUFLOWE_CARD.jpg");
    private Image cardKUSTOSZ = new Image("KUSTOSZ_CARD.jpg");
    private Image cardROMPER = new Image("ROMPER_CARD.jpg");
    private Image cardTATRA = new Image("TATRA_CARD.jpg");
    private Image cardVIP = new Image("VIP_CARD.jpg");

    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(11.5,12.5,13.5,14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        ImageView imgCardFAXE = new ImageView(cardFAXE);
        cards.getChildren().add(imgCardFAXE);
        ImageView imgCardROMPER = new ImageView(cardROMPER);
        cards.getChildren().add(imgCardROMPER);

        grid.add(cards,0,0,2,2);

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        primaryStage.setTitle("ROMPER - Play for VABANK");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
