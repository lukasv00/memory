package Memory;

import javafx.scene.image.Image;

import java.util.*;

public class Deck {

    private final List<Image> cards = new LinkedList<>();

    private Image cardFAXE = new Image("FAXE_CARD.jpg");
    private Image cardHARNAS = new Image("HARNAS_CARD.png");
    private Image cardKARPACKIE = new Image("KARPACKIE_CARD.jpg");
    private Image cardKUFLOWE = new Image("KUFLOWE_CARD.jpg");
    private Image cardKUSTOSZ = new Image("KUSTOSZ_CARD.jpg");
    private Image cardROMPER = new Image("ROMPER_CARD.jpg");
    private Image cardTATRA = new Image("TATRA_CARD.jpg");
    private Image cardVIP = new Image("VIP_CARD.jpg");


    public List<Image> cardsDeckPreparation(){
        cards.add(cardFAXE);
        cards.add(cardHARNAS);
        cards.add(cardKARPACKIE);
        cards.add(cardKUFLOWE);
        cards.add(cardKUSTOSZ);
        cards.add(cardROMPER);
        cards.add(cardTATRA);
        cards.add(cardVIP);

        List<Image> cardsDeck = new LinkedList<>();
        for(Image card: cards){
            cardsDeck.add(card);
            cardsDeck.add(card);
        }
        Collections.shuffle(cardsDeck);
        return new ArrayList<>(cardsDeck);
    }

}
