package Memory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

public class Board{
    List<Button> buttonsWithFunction = new LinkedList<>();
    List<Button> clickedButtons = new LinkedList<>();

    public List<Button> getButtonsWithFunction() {
        return buttonsWithFunction;
    }

    public TilePane playGround() {
        Deck deck = new Deck();

        //Button look
        Image buttonCover = new Image("Button_Cover.jpg");
        ImageView buttonCoverView = new ImageView(buttonCover);
        buttonCoverView.setPreserveRatio(true);
        buttonCoverView.setFitHeight(150);

        //Button creation
        List<Button> buttonsRaw = new LinkedList<>();
        for(int i=0; i<16; i++){
            buttonsRaw.add(new Button());
        }

        //View of buttons before click
        List<Button> buttonWithImages = new LinkedList<>();
        for(Button button: buttonsRaw) {
            ImageView buttonImage = new ImageView(buttonCover);
            buttonImage.setPreserveRatio(true);
            buttonImage.setFitHeight(150);
            button.setGraphic(buttonImage);
            button.setPrefSize(120,150);
            buttonWithImages.add(button);
        }

        //Image of buttons after click
        final List<Image> hiddenCards = deck.cardsDeckPreparation();
        int buttonStep = 0;
        for (Button button: buttonWithImages) {
            Image hiddenBeer = hiddenCards.get(buttonStep);
            ImageView hiddenBeerView = new ImageView(hiddenBeer);
            hiddenBeerView.setPreserveRatio(true);
            hiddenBeerView.setFitHeight(150);

            button.setOnMouseClicked(b -> button.setGraphic(hiddenBeerView));
            button.setPrefSize(120,150);
            button.setOnAction(b -> {
                clickedButtons.add(button);
                event();});
            buttonsWithFunction.add(button);
            buttonStep++;
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
        for(Button button: buttonsWithFunction){
            cardsPane.getChildren().add(button);
        }

        return cardsPane;
    }

    int countSuccess = 0;

    public void event(){
        //Button look
        Image buttonCover = new Image("Button_Cover.jpg");
        ImageView buttonCoverView = new ImageView(buttonCover);
        buttonCoverView.setPreserveRatio(true);
        buttonCoverView.setFitHeight(150);

        if(clickedButtons.size() == 2){
            if(clickedButtons.get(0).equals(clickedButtons.get(1))){
                countSuccess++;
            }
            if (buttonsWithFunction.contains(clickedButtons)){
                for(Button button: buttonsWithFunction){
                        button.setGraphic(buttonCoverView);
                }
                clickedButtons.remove(0);
                clickedButtons.remove(1);
            }

        }
    }
}


