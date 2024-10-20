package view;

import controller.IzvrsiTransakcijuController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Nacin;
import model.Tip;

public class TransactionView extends Stage {

    private GridPane root;

    private Label lblNaziv;
    private Label lblIznos;
    private Label lblDatum;
    private Label lblTip;
    private Label lblNacin;

    private TextField tfNaziv;
    private TextField tfIznos;
    private DatePicker datePicker;
    private ComboBox<Tip> comboBox;
    private ComboBox<Nacin> comboBox2;

    private Button btnIzvrsiTransakciju;
    private Button btnClose;

    public TransactionView() {
        initElements();
        addElements();
        addControllers();
        insertCombo();
        insertCombo2();
    }

    private void addControllers() {
        btnIzvrsiTransakciju.setOnAction(new IzvrsiTransakcijuController(this));
        btnClose.setOnAction(event -> {
            this.close();
        });
    }

    private void addElements() {

        root.addColumn(0,lblNaziv,lblIznos,lblDatum,lblTip,lblNacin,btnClose);
        root.addColumn(1,tfNaziv,tfIznos,datePicker,comboBox,comboBox2,btnIzvrsiTransakciju);
        root.setVgap(10);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(15));

    }

    private void initElements() {

        root = new GridPane();
        Scene sc = new Scene(root);
        super.setScene(sc);

        lblNaziv = new Label("Naziv");
        lblIznos = new Label("Iznos");
        lblDatum = new Label("Datum");
        lblTip = new Label("Tip");
        lblNacin = new Label("Nacin");

        tfNaziv = new TextField();
        tfIznos = new TextField();
        datePicker = new DatePicker();
        comboBox = new ComboBox<>();
        comboBox2 = new ComboBox<>();

        btnIzvrsiTransakciju = new Button("Izvrsi Transakciju");
        btnClose = new Button("Close");


    }

    private void insertCombo(){
        comboBox.getItems().clear();
        comboBox.getItems().addAll(Tip.UPLATA,Tip.ISPLATA);
        comboBox.getSelectionModel().select(0);
    }

    private void insertCombo2(){
        comboBox2.getItems().clear();
        comboBox2.getItems().addAll(Nacin.KARTICA,Nacin.KES);
        comboBox2.getSelectionModel().select(0);
    }

    public TextField getTfNaziv() {
        return tfNaziv;
    }

    public TextField getTfIznos() {
        return tfIznos;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public ComboBox<Tip> getComboBox() {
        return comboBox;
    }

    public ComboBox<Nacin> getComboBox2() {
        return comboBox2;
    }
}
