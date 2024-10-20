package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import util.Util;
import view.MainView;

public class IspisController implements EventHandler<ActionEvent> {

    private MainView mainView;

    public IspisController(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void handle(ActionEvent event) {

        Util.ispisUFajl();

    }
}
