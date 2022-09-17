package ba.reservation.nightclubmanagement.gui.admin.place;


import ba.reservation.nightclubmanagement.business.model.Place;
import ba.reservation.nightclubmanagement.business.place.PlaceService;
import ba.reservation.nightclubmanagement.business.place.PlaceServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.math.BigDecimal;
import java.util.List;

public class PlaceAdminPanel extends VBox {
    private Label titleLabel = new Label("Administracija stolova");
    private ObservableList<Place> placeObservableList;

    private TextField numberofguestTextField = new TextField();

    private TextField numberoftableTextField = new TextField();

    private TextField priceTextField = new TextField();

    private Button addPlaceButton = new Button("Dodaj ");

    private Button removePlaceButton = new Button("Obriši ");

    public PlaceAdminPanel() {
        titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));


        TableColumn<Place, Integer> numberofguestColumn = new TableColumn<>("Broj gostiju");
        numberofguestColumn.setCellValueFactory(new PropertyValueFactory<Place, Integer>("numberofguest"));

        TableColumn<Place, Integer> numberoftableColumn = new TableColumn<>("Broj stola");
        numberoftableColumn.setCellValueFactory(new PropertyValueFactory<Place, Integer>("numberoftable"));

        TableColumn<Place, BigDecimal> priceColumn = new TableColumn<>("Cijena stola");
        priceColumn.setCellValueFactory(new PropertyValueFactory<Place, BigDecimal>("price"));


        PlaceService placeService = PlaceServiceFactory.SERVICE.getPlaceService();
        placeObservableList = FXCollections.observableList(placeService.findAll());
        TableView<Place> placeTableView = new TableView<>();
        placeTableView.setItems(placeObservableList);
        placeTableView.getColumns().addAll(
                numberofguestColumn, numberoftableColumn, priceColumn);
        getChildren().addAll(titleLabel, placeTableView, getForm());
    }

    private HBox getForm() {
        HBox form = new HBox();
        form.setSpacing(3);

//        List<Place> places = PlaceServiceFactory.PLACE_SERVICE.getPlaceService().findAll();
        numberofguestTextField.setPromptText("Broj gostiju");
        numberoftableTextField.setPromptText("Broj stola");
        priceTextField.setPromptText("Cijena stola");
        addPlaceButton.setOnAction(this::addPlace);
        removePlaceButton.setOnAction(this::removePlace);
        form.getChildren().addAll(
                numberofguestTextField,
                numberoftableTextField,
                priceTextField,
                addPlaceButton,
                removePlaceButton);
        return form;


    }


    private void removePlace(ActionEvent actionEvent) {

        Place selectedPlace = (Place) PlaceService.getSelectionModel().getSelectedItem();
        PlaceService placeService = PlaceServiceFactory.SERVICE.getPlaceService();
        placeService.remove(selectedPlace);
        placeObservableList.remove(selectedPlace);

    }


    private void addPlace(ActionEvent actionEvent) {
            Place place = new Place();
            place.setNumberofguests(Integer.parseInt(numberofguestTextField.getText()));
            place.setNumberoftable(Integer.parseInt(numberoftableTextField.getText()));
            place.setPrice(new BigDecimal(priceTextField.getText()));
            PlaceService placeService = PlaceServiceFactory.SERVICE.getPlaceService();
            placeService.create(place);
            numberofguestTextField.clear();
            numberoftableTextField.clear();
            priceTextField.setText("");


        }

    }


