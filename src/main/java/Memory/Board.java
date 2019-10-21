package Memory;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static Memory.Deck.cardsDeckPreparation;

public class Board {
    private Scoreboard scoreboard = new Scoreboard();
    private List<BeerButton> beerButtonList = cardsDeckPreparation();
    private BeerButton buttonClicked1 = null;
    private BeerButton buttonClicked2 = null;
    private Label pairsLabel = new Label("Pairs shown: 0");
    private int pairsCounter = 0;
    private Label movesLabel = new Label("Moves: 0");
    private int movesCounter = 0;
    private Label gameEndLabel = new Label("");
    private double scoreRatio = 0;
    private Stage primaryStage;

    public Board() throws IOException {
    }

    public TilePane playGround(int time) {
        for (BeerButton button : beerButtonList) {
            button.setOnMousePressed(e -> {
                BeerButton source = (BeerButton) e.getSource();
                if (buttonClicked1 == null) {
                    buttonClicked1 = source;
                    buttonClicked1.setBeer();
                } else {
                    buttonClicked2 = source;
                    buttonClicked2.setBeer();
                    movesCounter++;

                    StringBuilder movesBulider = new StringBuilder();
                    movesBulider.append("Moves: ").append(movesCounter);
                    movesLabel.setText(movesBulider.toString());
                }
            });
            button.setOnMouseReleased(e -> event(time));
        }

        TilePane cardsPane = new TilePane();
        cardsPane.setAlignment(Pos.BASELINE_CENTER);
        cardsPane.setLayoutX(0);
        cardsPane.setPadding(new Insets(20, 0, 0, 300));
        cardsPane.setLayoutY(0);
        cardsPane.setHgap(80);
        cardsPane.setVgap(5);
        cardsPane.setPrefColumns(4);
        cardsPane.setPrefRows(4);
        for (BeerButton button : beerButtonList) {
            cardsPane.getChildren().add(button);
        }

        return cardsPane;
    }

    public void event(int time) {
        Thread event = new Thread(() -> Platform.runLater(() -> {
            if (buttonClicked1.getIndex() != buttonClicked2.getIndex()) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                buttonClicked1.setCover();
                buttonClicked2.setCover();
                buttonClicked1 = null;
                buttonClicked2 = null;
            } else {
                pairsCounter++;
                buttonClicked1.setDisable(true);
                buttonClicked2.setDisable(true);
                buttonClicked1 = null;
                buttonClicked2 = null;
            }
            StringBuilder pairsBulider = new StringBuilder();
            pairsBulider.append("Pairs shown: ").append(pairsCounter);
            pairsLabel.setText(pairsBulider.toString());

            if (pairsCounter == 8) {
                gameEndLabel.setText("YOU WON");
                //save();
                primaryStage.setScene(scoreboard.scoreScene());
            }
        }));
        event.start();
    }

    public void save() {
        Path path = (Path) Paths.get("C:\\Users\\Lukas\\ProjectsJava\\memory\\src\\main\\resources\\Score.txt");
        scoreRatio = 2 * pairsCounter / movesCounter;

        try (
                BufferedWriter writer = Files.newBufferedWriter((java.nio.file.Path) path)) {
            writer.write("Player: " + scoreRatio);
        } catch (
                IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }

    public Label counterLabelBuilder() {
        pairsLabel.setFont(new Font("Arial", 24));
        pairsLabel.setTextFill(Color.web("#FFF"));
        return pairsLabel;
    }

    public Label movesLabelBuilder() {
        movesLabel.setFont(new Font("Arial", 24));
        movesLabel.setTextFill(Color.web("#FFF"));
        return movesLabel;
    }

    public Label gameEndLabel() {
        gameEndLabel.setFont(new Font("Arial", 24));
        gameEndLabel.setTextFill(Color.web("#FFF"));
        return gameEndLabel;
    }
}


