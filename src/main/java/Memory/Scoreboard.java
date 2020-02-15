package Memory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Scoreboard {

    public Scoreboard() throws IOException {
    }

    Image imagebackPlayGround = new Image("Background.jpg");
    BackgroundSize backgroundSizePlayGround = new BackgroundSize(100, 100, true, true, true, false);
    BackgroundImage backgroundImagePlayGround = new BackgroundImage(imagebackPlayGround, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizePlayGround);
    Background backgroundPlayGround = new Background(backgroundImagePlayGround);

    public void scoreReader() {
        Path file = (Path) Paths.get("C:\\Users\\Lukas\\ProjectsJava\\memory\\src\\main\\resources\\Score.txt");

        try (
                Stream<String> stream = Files.lines((java.nio.file.Path) file)) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }


    public Scene scoreScene() {
        GridPane grid = new GridPane();
        grid.setBackground(backgroundPlayGround);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 40));
        grid.setHgap(10);
        grid.setVgap(10);


        // grid.add(scoreReader(), 2, 0, 1, 1);

        Scene scoreScene = new Scene(grid, 1400, 900, Color.BLACK);

        return scoreScene;
    }

}
