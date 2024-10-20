package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Baza;
import model.Transakcije;
import view.MainView;

public class ObrisiController implements EventHandler<ActionEvent> {

    private MainView mainView;

    public ObrisiController(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void handle(ActionEvent event) {
        Transakcije t = MainView.getTableView().getSelectionModel().getSelectedItem();
        Baza.getInstance().obrisiIzTrasakciju(t);
        MainView.getTfStanjeKartica().setText(String.valueOf(Baza.getInstance().trenutnoStanjeKartica()));
        MainView.getTfStanjeKes().setText(String.valueOf(Baza.getInstance().trenutnoStanjeKes()));
        MainView.getTableView().refresh();
    }
}
