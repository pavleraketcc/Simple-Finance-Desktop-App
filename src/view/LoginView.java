package view;

import controller.LoginController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class LoginView extends Stage {

    private GridPane root;

    private Label lblUsername;
    private Label lblPassword;
    private TextField tfUsername;
    private PasswordField tfPassword;

    private Label lblPoruka;

    private Button btnLogin;

    public LoginView() {
        initElements();
        addElements();
        addControllers();
    }

    private void addControllers() {
        btnLogin.setOnAction(new LoginController(this));
    }

    private void addElements() {

        root.addColumn(0,lblUsername,lblPassword);
        root.addColumn(1,tfUsername,tfPassword,btnLogin,lblPoruka);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(20);

}
    private void initElements() {

        root = new GridPane();
        Scene sc = new Scene(root);
        super.setScene(sc);

        lblUsername = new Label("Username");
        lblPassword = new Label("Password");
        tfUsername = new TextField();
        tfPassword = new PasswordField();

        lblPoruka = new Label();

        btnLogin = new Button("Log In");

    }

    public TextField getTfUsername() {
        return tfUsername;
    }

    public TextField getTfPassword() {
        return tfPassword;
    }

    public Label getLblPoruka() {
        return lblPoruka;
    }
}
