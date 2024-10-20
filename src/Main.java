import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import util.Util;
import view.LoginView;
import view.MainView;



public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Util.initKorisnik();

        Image image = new Image("bank.png");

        LoginView loginView = new LoginView();
        loginView.getIcons().add(image);
        loginView.setTitle("Login");
        loginView.setHeight(250);
        loginView.setWidth(350);
        loginView.show();


    }
}