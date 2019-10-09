package Memory;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.TilePane;

import java.util.List;

import static Memory.Deck.cardsDeckPreparation;

public class Board {
    private List<BeerButton> beerButtonList = cardsDeckPreparation();
    private BeerButton buttonClicked1 = null;
    private BeerButton buttonClicked2 = null;
    private int counter = 0;

    public TilePane playGround() {

        for (BeerButton button : beerButtonList) {
            button.setOnMousePressed(e -> {
                BeerButton source = (BeerButton) e.getSource();
                if (buttonClicked1 == null) {
                    buttonClicked1 = source;
                    buttonClicked1.setBeer();
                } else {
                    buttonClicked2 = source;
                    buttonClicked2.setBeer();
                }
            });
            button.setOnMouseReleased(e -> event());
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

    public void event() {
        Thread event = new Thread(() -> Platform.runLater(() -> {
            if (buttonClicked1.getIndex() != buttonClicked2.getIndex()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                buttonClicked1.setCover();
                buttonClicked2.setCover();
                buttonClicked1 = null;
                buttonClicked2 = null;
            } else {
                counter++;
                buttonClicked1 = null;
                buttonClicked2 = null;
            }
        }));
        event.start();
    }

    public int getCounter() {
        return counter;
    }
}


