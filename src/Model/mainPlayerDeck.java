package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class mainPlayerDeck extends HBox {

    public mainPlayerDeck() {

        String lastCard = "cards/Ah.png";
        /*
         Array of face-up cards (will be modified in the future)
         */
        String[] cardFaces = {
                "cards/l2h.png", "cards/l3d.png", "cards/l4s.png", "cards/l5c.png",
                "cards/l6h.png", "cards/l7d.png", "cards/l8s.png", "cards/l9c.png",
                "cards/l9h.png", "cards/lJd.png", "cards/lJs.png", "cards/lKd.png"
        };

        /*
         Create ImageView nodes for facing up the cards
         */
        for (String cardFace : cardFaces) {
            ImageView card = new ImageView(new Image(cardFace));
            card.setFitWidth(130);
            card.setFitHeight(190);
            card.setPreserveRatio(true);
            this.getChildren().add(card);
        }

        /*
        Last card in the hand
         */
        ImageView lastCardView = new ImageView(new Image(lastCard));
        lastCardView.setFitWidth(140);
        lastCardView.setFitHeight(400);
        lastCardView.setPreserveRatio(true);
        this.getChildren().add(lastCardView);


        this.setSpacing(0);
    }
}
