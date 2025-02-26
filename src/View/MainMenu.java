package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class MainMenu{



    public MainMenu (Stage stage) throws IOException {
        // Main layer
        AnchorPane root = new AnchorPane();


        /**
         * Background image
         */
        Image image = new Image(MainMenu.class.getResource("/Back.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1920);
        imageView.setFitHeight(1080);

        /**
         * Title of the game in the main menu
         */
        Text title = new Text("Crazy Eights");
        title.setFont(Font.font("Georgia", FontWeight.MEDIUM, 150)); // Bigger & bolder font
        title.setStyle("-fx-fill: rgba(6,241,198,0.65); -fx-stroke: rgb(178,58,58); -fx-stroke-width: 3;");

        /**
         * Calculate width dynamically for proper centering
         */
        double textWidth = title.getLayoutBounds().getWidth();
        double screenWidth = 1920;
        title.setLayoutX((screenWidth - textWidth) / 2); // Center X

        title.setLayoutY(200);


        /**
         * Buttons in the main menu
         */
        Button startGame = new Button("Start Game"); //Beginning of the game
        Button settings = new Button("Settings"); // (FUnctions will be added in the future)Settings: Change language, turn on/of music
        Button about = new Button("About"); // Info about creator and game rules
        Button exit = new Button("Exit"); //Terminate game

        /*
         Button styling & size
         */
        startGame.setPrefSize(230, 80);
        settings.setPrefSize(230, 80);
        about.setPrefSize(230, 80);
        exit.setPrefSize(230, 80);

        /**
         * Start game menu fuction!!!
         */
        startGame.setOnMouseClicked(event -> {
            new GameScene(stage);
        });

        /**
         * VBox for Centered Buttons
         */
        VBox buttonBox = new VBox(20, startGame, settings, about, exit);
        buttonBox.setLayoutX(845); // Center horizontally (1920/2 - button width/2)
        buttonBox.setLayoutY(400); // Adjust vertical position


        /*
        Add everything to root
         */
        root.getChildren().addAll(imageView, title, buttonBox);


        /*
         Set Scene
         */
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

}


