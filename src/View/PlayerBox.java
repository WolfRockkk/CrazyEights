package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerBox extends VBox {

    public PlayerBox(String playerName) {

        /*
        Creating box for player info and score
         */
        Label nameLabel = new Label(playerName);
        nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label scoreLabel = new Label("Score: 0");


        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll( nameLabel, scoreLabel);

        this.setStyle("-fx-border-color: #0eb69c; -fx-padding: 10; -fx-background-color: #09d9a8;");
        this.setPrefSize(120, 60);
    }
}


