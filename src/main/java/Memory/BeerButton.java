package Memory;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeerButton extends Button {
    private final int index;
    private final Image coverImage = new Image("Button_Cover.jpg");
    private final Image beerImage;

    public BeerButton(int index, Image beerImage) {
        this.index = index;
        this.beerImage = beerImage;
    }

    public void setCover(Button button){
        ImageView buttonCoverView = new ImageView(coverImage);
        buttonCoverView.setPreserveRatio(true);
        buttonCoverView.setFitHeight(150);
        button.setGraphic(buttonCoverView);
        button.setPrefSize(120,150);
    }

    public void setBeer(Button button){
        ImageView buttonBeerView = new ImageView(beerImage);
        buttonBeerView.setPreserveRatio(true);
        buttonBeerView.setFitHeight(150);
        button.setGraphic(buttonBeerView);
        button.setPrefSize(120,150);
    }

    public int getIndex() {
        return index;
    }
}
