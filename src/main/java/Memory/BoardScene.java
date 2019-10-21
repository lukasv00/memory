package Memory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class BoardScene {
    private final Board board = new Board();

    Image imagebackPlayGround = new Image("Background.jpg");
    BackgroundSize backgroundSizePlayGround = new BackgroundSize(100, 100, true, true, true, false);
    BackgroundImage backgroundImagePlayGround = new BackgroundImage(imagebackPlayGround, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizePlayGround);
    Background backgroundPlayGround = new Background(backgroundImagePlayGround);

    public BoardScene() throws IOException {
    }

    public Scene boardScene(int time){

        GridPane grid = new GridPane();
        grid.setBackground(backgroundPlayGround);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 40));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(board.counterLabelBuilder(), 2, 0, 1, 1);
        grid.add(board.movesLabelBuilder(), 2, 1, 1, 1);
        grid.add(board.gameEndLabel(), 2, 2, 1, 1);
        grid.add(board.playGround(time), 2, 2, 1, 1);


        Scene boardScene = new Scene(grid,1400,900, Color.BLACK);

        return boardScene;
    }

}
