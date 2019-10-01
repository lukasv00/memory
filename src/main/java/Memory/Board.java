package Memory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.TilePane;

import java.util.LinkedList;
import java.util.List;

public class Board{
    Deck deck = new Deck();
    List<BeerButton> beerButtonList = deck.cardsDeckPreparation();
    BeerButton buttonClicked1 = null;
    BeerButton buttonClicked2 = null;
    int counter = 0;

    public TilePane playGround() {

        final List<BeerButton> playableBeerButtons = new LinkedList<>();
        for(BeerButton button: beerButtonList){
            button.setOnAction(e -> {
            if((buttonClicked1 == null) && (buttonClicked2 == null)){
                buttonClicked1 = button;
            }
            if((buttonClicked1 != null) && (buttonClicked2 == null)){
                buttonClicked2 = button;
            }
            if((buttonClicked1 != null) && (buttonClicked2 != null)) {
                event();
            }
            });
            playableBeerButtons.add(button);
        }

        TilePane cardsPane = new TilePane();
        cardsPane.setAlignment(Pos.BASELINE_CENTER);
        cardsPane.setLayoutX(0);
        cardsPane.setPadding(new Insets(300, 0, 0, 300));
        cardsPane.setLayoutY(0);
        cardsPane.setHgap(80);
        cardsPane.setVgap(5);
        cardsPane.setPrefColumns(4);
        cardsPane.setPrefRows(4);
        for(BeerButton button: playableBeerButtons){
            cardsPane.getChildren().add(button);
        }

        return cardsPane;
    }

    public void event(){
            if(deck.buttonIndex(buttonClicked1) == deck.buttonIndex(buttonClicked2)){
                counter++;
            }else{
                try {
                    wait(1);
                    buttonClicked1.setCover(buttonClicked1);
                    buttonClicked2.setCover(buttonClicked2);
                    buttonClicked1 = null;
                    buttonClicked2 = null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}


