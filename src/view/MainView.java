package view;

import controller.IspisController;
import controller.IsplatiController;
import controller.ObrisiController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Baza;
import model.Transakcije;

public class MainView extends Stage {

    private VBox root;

    private HBox hBox;

    private static TableView<Transakcije> tableView;
    private ObservableList<Transakcije> olTransakcije;

    private VBox vbButtons;
    private Button btnObrisi;
    private Button btnIsplata;

    private GridPane gridPane;
    private Label lblStanjeKartica;
    private Label lblStanjeKes;
    private static TextField tfStanjeKartica;
    private static TextField tfStanjeKes;

    private Button btnIspis;

    public MainView(){
        initLists();
        initElements();
        addElements();
        addControllers();
        insertStanjeKartica();
        insertStanjeKes();
    }

    private void addControllers() {
        btnIsplata.setOnAction(new IsplatiController(this));
        btnIspis.setOnAction(new IspisController(this));
        btnObrisi.setOnAction(new ObrisiController(this));
    }

    private void addElements() {

        gridPane.addColumn(0,lblStanjeKartica,lblStanjeKes);
        gridPane.addColumn(1,tfStanjeKartica,tfStanjeKes);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0,0,50,0));


        vbButtons.getChildren().addAll(gridPane,btnIsplata,btnObrisi);
        vbButtons.setAlignment(Pos.CENTER);
        vbButtons.setSpacing(10);

        tableView.setMinWidth(400);
        hBox.getChildren().addAll(tableView,vbButtons);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setSpacing(20);

        root.getChildren().addAll(hBox,btnIspis);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        root.setPadding(new Insets(20));

    }

    private void initElements() {

        root = new VBox();
        Scene sc = new Scene(root);
        super.setScene(sc);

        hBox = new HBox();

        tableView = new TableView<>(olTransakcije);
        TableColumn<Transakcije,String> col1 = new TableColumn<>("Naziv");
        TableColumn<Transakcije,String> col2 = new TableColumn<>("Iznos");
        TableColumn<Transakcije,String> col3 = new TableColumn<>("Datum");
        TableColumn<Transakcije,String> col4 = new TableColumn<>("Tip");
        TableColumn<Transakcije,String> col5 = new TableColumn<>("Nacin Placanja");
        col1.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        col2.setCellValueFactory(new PropertyValueFactory<>("iznos"));
        col3.setCellValueFactory(new PropertyValueFactory<>("datum"));
        col4.setCellValueFactory(new PropertyValueFactory<>("tip"));
        col5.setCellValueFactory(new PropertyValueFactory<>("nacin"));
        tableView.getColumns().addAll(col1,col2,col3,col4,col5);

        vbButtons = new VBox();
        btnObrisi = new Button("Obrisi");
        btnIsplata = new Button("Transakcija");

        gridPane = new GridPane();
        lblStanjeKartica = new Label("Trenutno stanje na kartici");
        lblStanjeKes = new Label("Trenutno stanje kesa");
        tfStanjeKartica = new TextField();
        tfStanjeKes = new TextField();

        btnIspis = new Button("Sacuvaj");


    }

    private void initLists() {
        olTransakcije = FXCollections.observableList(Baza.getInstance().getTransakcije());
    }

    public static TableView<Transakcije> getTableView() {
        return tableView;
    }

    public static TextField getTfStanjeKartica() {
        return tfStanjeKartica;
    }

    public static TextField getTfStanjeKes() {
        return tfStanjeKes;
    }

    public void insertStanjeKartica(){
        tfStanjeKartica.setText(String.valueOf(Baza.getInstance().trenutnoStanjeKartica()));
    }

    public void insertStanjeKes(){
        tfStanjeKes.setText(String.valueOf(Baza.getInstance().trenutnoStanjeKes()));
    }
}
