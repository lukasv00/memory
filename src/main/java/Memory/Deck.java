package Memory;

import javafx.scene.image.Image;

import java.util.*;
import java.util.List;

public class Deck {

    public static List<BeerButton> cardsDeckPreparation(){

        Image cardFAXE = new Image("FAXE_CARD.jpg");
        Image cardHARNAS = new Image("HARNAS_CARD.png");
        Image cardKARPACKIE = new Image("KARPACKIE_CARD.jpg");
        Image cardKUFLOWE = new Image("KUFLOWE_CARD.jpg");
        Image cardKUSTOSZ = new Image("KUSTOSZ_CARD.jpg");
        Image cardROMPER = new Image("ROMPER_CARD.jpg");
        Image cardTATRA = new Image("TATRA_CARD.jpg");
        Image cardVIP = new Image("VIP_CARD.jpg");

        final List<Image> beerImages = new ArrayList<>();

        beerImages.add(cardFAXE);
        beerImages.add(cardHARNAS);
        beerImages.add(cardKARPACKIE);
        beerImages.add(cardKUFLOWE);
        beerImages.add(cardKUSTOSZ);
        beerImages.add(cardROMPER);
        beerImages.add(cardTATRA);
        beerImages.add(cardVIP);

        final List<BeerButton> buttonCollection = new ArrayList();

        for(int i=0; i<beerImages.size(); i++){
            buttonCollection.add(new BeerButton(i,beerImages.get(i)));
            buttonCollection.add(new BeerButton(i,beerImages.get(i)));
        }

        for(BeerButton button: buttonCollection){
            button.setCover();
        }

        Collections.shuffle(buttonCollection);

        return buttonCollection;
    }
}
