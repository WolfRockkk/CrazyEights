package Model;

import View.MainMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Cards extends AnchorPane {
    private ImageView imageViewTopCard;

    public Cards() {
        /**
         *  Load the top/center card image
         */
        Image topCard = new Image(MainMenu.class.getResource("/cards/back.png").toExternalForm());
        imageViewTopCard = new ImageView(topCard);
        imageViewTopCard.setFitWidth(150); // Set appropriate size
        imageViewTopCard.setFitHeight(200);

        /**
         * Put the card in the middle of the deck
         */
        AnchorPane.setTopAnchor(imageViewTopCard, 460.0);
        AnchorPane.setLeftAnchor(imageViewTopCard, 510.0);

        this.getChildren().add(imageViewTopCard);


    }

    // Method to update the top card
    public void setTopCard(String newCardPath) {
        imageViewTopCard.setImage(new Image(getClass().getResource(newCardPath).toExternalForm()));
    }
}
