package Memory;

import javafx.scene.image.Image;

import java.util.*;
import java.util.List;

public class Deck {

    private final List<Image> beerImages = new LinkedList<>();
    private final List<BeerButton> buttonCollection = new LinkedList<>();
    private final List<BeerButton> buttonCollectionDoubled = new LinkedList<>();

    private Image cardFAXE = new Image("FAXE_CARD.jpg");
    private Image cardHARNAS = new Image("HARNAS_CARD.png");
    private Image cardKARPACKIE = new Image("KARPACKIE_CARD.jpg");
    private Image cardKUFLOWE = new Image("KUFLOWE_CARD.jpg");
    private Image cardKUSTOSZ = new Image("KUSTOSZ_CARD.jpg");
    private Image cardROMPER = new Image("ROMPER_CARD.jpg");
    private Image cardTATRA = new Image("TATRA_CARD.jpg");
    private Image cardVIP = new Image("VIP_CARD.jpg");


    public List<BeerButton> cardsDeckPreparation(){
        beerImages.add(cardFAXE);
        beerImages.add(cardHARNAS);
        beerImages.add(cardKARPACKIE);
        beerImages.add(cardKUFLOWE);
        beerImages.add(cardKUSTOSZ);
        beerImages.add(cardROMPER);
        beerImages.add(cardTATRA);
        beerImages.add(cardVIP);

        for(int i=0; i<beerImages.size(); i++){
            buttonCollection.add(new BeerButton(i,beerImages.get(i)));
            buttonCollection.add(new BeerButton(i,beerImages.get(i)));
        }

        for(BeerButton button: buttonCollection){
            button.setCover(button);
            button.setOnMouseClicked(e -> button.setBeer(button));
        }

        Collections.shuffle(buttonCollection);
        return new LinkedList<>(buttonCollection);
    }

    public int buttonIndex(BeerButton button){
        return button.getIndex();
    }

}
