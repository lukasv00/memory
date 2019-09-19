package Memory;

import javafx.scene.image.Image;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Deck deck = new Deck();

        List<Image> dupa = deck.cardsDeckPreparation();

        for (Image dupas: dupa) {
            String pather;
            pather = dupas.getClass().toString();
            System.out.println(pather);
        }
    }
}
