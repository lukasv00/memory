package Memory;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeerButton extends Button {

    private final int index;
    private final Image beerImage;

    public BeerButton(int index, Image beerImage) {
        this.index = index;
        this.beerImage = beerImage;
    }

    public void setCover() {
        Image coverImage = new Image("Button_Cover.jpg");
        ImageView buttonCoverView = new ImageView(coverImage);
        buttonCoverView.setPreserveRatio(true);
        buttonCoverView.setFitHeight(150);
        super.setGraphic(buttonCoverView);
        super.setPrefSize(120, 150);
    }

    public void setBeer() {
        ImageView buttonBeerView = new ImageView(beerImage);
        buttonBeerView.setPreserveRatio(true);
        buttonBeerView.setFitHeight(150);
        super.setGraphic(buttonBeerView);
        super.setPrefSize(120, 150);
    }

    public int getIndex() {
        return index;
    }
}
