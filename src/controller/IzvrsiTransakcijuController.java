package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Baza;
import model.Nacin;
import model.Tip;
import model.Transakcije;
import view.MainView;
import view.TransactionView;

import java.time.LocalDate;
import java.util.Date;

public class IzvrsiTransakcijuController implements EventHandler<ActionEvent> {

    private TransactionView transactionView;

    public IzvrsiTransakcijuController(TransactionView transactionView) {
        this.transactionView = transactionView;
    }

    @Override
    public void handle(ActionEvent event) {

        String naziv = transactionView.getTfNaziv().getText();
        Double iznos = Double.parseDouble(transactionView.getTfIznos().getText());
        LocalDate datum = transactionView.getDatePicker().getValue();
        Tip tip = transactionView.getComboBox().getSelectionModel().getSelectedItem();
        Nacin nacin = transactionView.getComboBox2().getSelectionModel().getSelectedItem();

        Transakcije transakcija = new Transakcije(naziv,iznos,datum,tip,nacin);
        Baza.getInstance().dodajTransakciju(transakcija);
        MainView.getTableView().refresh();
        MainView.getTfStanjeKartica().setText(String.valueOf(Baza.getInstance().trenutnoStanjeKartica()));
        MainView.getTfStanjeKes().setText(String.valueOf(Baza.getInstance().trenutnoStanjeKes()));

    }
}
