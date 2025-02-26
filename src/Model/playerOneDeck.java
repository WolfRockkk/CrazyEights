package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class playerOneDeck extends VBox {

    public playerOneDeck() {
        /*
         Load images for cards
         */
        String cardBack = "cards/lback_reverse.png";
        String lastCard = "cards/back_reverse.png";

        /*
        Adding cards images to the deck
         */
        for (int i = 0; i < 11; i++) {
            ImageView card = new ImageView(new Image(cardBack));
            card.setFitWidth(190);
            card.setFitHeight(190);
            card.setPreserveRatio(true);
            this.getChildren().add(card);
        }

        /*
        Adding last card
         */
        ImageView lastCardView = new ImageView(new Image(lastCard));
        lastCardView.setFitWidth(190);
        lastCardView.setFitHeight(400);

        lastCardView.setPreserveRatio(true);
        this.getChildren().add(lastCardView);

        this.setSpacing(0);
    }
}
