package View;

import Model.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

    /*
    View.GameScene class.
    This class will be modified in the future
     */


public class GameScene {

    public GameScene(Stage stage) {

        AnchorPane root = new AnchorPane();

        /*
         * Background image
         */
        Image image = new Image(MainMenu.class.getResource("/gameBack.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1920);
        imageView.setFitHeight(1080);

        /**
         * Player 2 hand
         */
        playerTwoDeck playerTwoDeck = new playerTwoDeck();

        AnchorPane.setTopAnchor(playerTwoDeck, 100.0);
        AnchorPane.setLeftAnchor(playerTwoDeck, 560.0);

        /**
         * Main Player hand
         */
        mainPlayerDeck mainPlayerDeck = new mainPlayerDeck();

        AnchorPane.setLeftAnchor(mainPlayerDeck, 560.0);
        AnchorPane.setBottomAnchor(mainPlayerDeck, 100.0);

        /**
         * Player 1 hand
         */
        playerOneDeck playerOneDeck = new playerOneDeck();
        AnchorPane.setTopAnchor(playerOneDeck, 350.0);
        AnchorPane.setLeftAnchor(playerOneDeck, 180.0);

        /**
         * Player 3 hand
         */
        playerThreeDeck playerThreeDeck = new playerThreeDeck();
        AnchorPane.setTopAnchor(playerThreeDeck, 350.0);
        AnchorPane.setRightAnchor(playerThreeDeck, 550.0);

        /**
         * Model.Cards in the middle
         */
        Cards centerCards = new Cards();

        /*
         * Buttons that a user can use during the game
         * "Quit Game"
         * "Settings"
         * "Restart"
         */
        Button quitGame = new Button("Quit Game");
        quitGame.setPrefSize(111, 30); // Corrected method

        Button settings = new Button("Settings");
        settings.setPrefSize(111, 30);

        Button restart = new Button("Restart");
        restart.setPrefSize(111, 30);

        HBox hBox = new HBox(quitGame, settings,restart);

        hBox.setSpacing(10);

        AnchorPane.setBottomAnchor(hBox, 20.0); // 20px from bottom
        AnchorPane.setRightAnchor(hBox, 20.0);

        /*
         * ChatBox for user and players interactions
         */
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);
        chatArea.setPrefSize(250,900);
        chatArea.setWrapText(true); // Enables word wrapping

        TextField chatInput = new TextField();
        chatInput.setPrefWidth(250); // Input field width

        Button sendButton = new Button("Send");
        sendButton.setPrefWidth(80);

        /*
        Sending the message in the text box from the main player(me)
         */
        sendButton.setOnAction(e -> {
            String message = chatInput.getText().trim();
            if (!message.isEmpty()) {
                chatArea.appendText("You: " + message + "\n");
                chatInput.clear(); // Clear input field
            }
        });

        HBox inputBox = new HBox(10, chatInput, sendButton);

        /*
         VBox for chat box Layout
         */
        VBox chatBox = new VBox(10, chatArea, inputBox);
        chatBox.setPrefWidth(350);
        chatBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4); -fx-padding: 10;");

        /*
         Position chat box to the right bottom
         */
        AnchorPane.setBottomAnchor(chatBox, 100.0);
        AnchorPane.setRightAnchor(chatBox, 20.0);

        /*
         * Player Boxes
         */
        PlayerBox playerLeft = new PlayerBox("Player 1");
        PlayerBox playerRight = new PlayerBox("Player 3");
        PlayerBox playerTop = new PlayerBox("Player 2");
        PlayerBox playerBottom = new PlayerBox("You");

        /*
        Positions for the player info boxes
         */
        //PLAYER 1
        AnchorPane.setLeftAnchor(playerLeft, 10.0);
        AnchorPane.setBottomAnchor(playerLeft, 520.0);
        //PLAYER 3
        AnchorPane.setRightAnchor(playerRight, 390.0);
        AnchorPane.setBottomAnchor(playerRight, 520.0);
        //PLAYER 2
        AnchorPane.setTopAnchor(playerTop, 10.0);
        AnchorPane.setLeftAnchor(playerTop, 750.0);

        //MAIN PLAYER
        AnchorPane.setBottomAnchor(playerBottom, 10.0);
        AnchorPane.setLeftAnchor(playerBottom, 750.0);

        root.getChildren().addAll(imageView, hBox, chatBox, playerLeft, playerRight, playerTop,
                playerBottom,centerCards, playerTwoDeck, mainPlayerDeck, playerOneDeck, playerThreeDeck);

        stage.setScene(new Scene(root, 1920, 1080));
        stage.show();
    }
}

