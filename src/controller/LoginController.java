package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import model.Baza;
import model.Korisnik;
import util.Util;
import view.LoginView;
import view.MainView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.zip.DataFormatException;

public class LoginController implements EventHandler<ActionEvent> {

    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void handle(ActionEvent event) {

        String username = loginView.getTfUsername().getText();
        String password = loginView.getTfPassword().getText();
        Image image = new Image("bank.png");
            for(Korisnik k: Baza.getInstance().getKorisnici()){
                if(k.getUsername().equals(username) && k.getPassword().equals(password)){
                    Util.ucitajIzFajla();
                    MainView mainView = new MainView();
                    mainView.getIcons().add(image);
                    mainView.show();
                    loginView.close();
                }
                loginView.getLblPoruka().setText("Wrong username or password!");
            }


    }
}
