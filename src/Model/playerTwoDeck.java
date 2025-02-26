package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * RENAME THE CLASS AND REFACTOR EVERYTHING
 */
public class playerTwoDeck extends HBox {

    public playerTwoDeck() {
        /**
         * Loading cards just to show the future inerface
         */
        String cardBack = "cards/lback.png";
        String lastCard = "cards/back.png";

        /**
         * Creating node omages
         */
        for (int i = 0; i < 11; i++) {
            ImageView card = new ImageView(new Image(cardBack));
            card.setFitWidth(130);
            card.setFitHeight(190);
            card.setPreserveRatio(true);
            this.getChildren().add(card);
        }

        /**
         * Adding last card in the hand
         */
        ImageView lastCardView = new ImageView(new Image(lastCard));
        lastCardView.setFitWidth(140);
        lastCardView.setFitHeight(400);
        lastCardView.setPreserveRatio(true);
        this.getChildren().add(lastCardView);

        // Spacing will be 0
        this.setSpacing(0);
    }
}
