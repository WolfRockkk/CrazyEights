import View.MainMenu;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;


/*
Future features will be added in the project. Right now it is a raw picture of the future masterpiece
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        MainMenu menu = new MainMenu(stage);

    }
    public static void main(String[] args) {
        launch();
    }
}
