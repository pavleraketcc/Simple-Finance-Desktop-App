package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.MainView;
import view.TransactionView;

public class IsplatiController implements EventHandler<ActionEvent> {

    private MainView mainView;

    public IsplatiController(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void handle(ActionEvent event) {
        TransactionView transactionView = new TransactionView();
        transactionView.setWidth(400);
        transactionView.show();
    }
}
