package ba.reservation.nightclubmanagement.gui.admin.place;


import ba.reservation.nightclubmanagement.business.model.Place;
import ba.reservation.nightclubmanagement.business.place.PlaceService;
import ba.reservation.nightclubmanagement.business.place.PlaceServiceFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.math.BigDecimal;

public class PlaceAdminPanel extends VBox {
    private Label titleLabel = new Label("Administracija stolova");
    private ObservableList<Place> placeObservableList;
    private TableView<Place>  placeTableView = new TableView<>();

    private TextField placeCodeTextField = new TextField();

    private TextField numberOfPlaceTextField = new TextField();
    private TextField priceTextField = new TextField();

    private Button addPlaceButton = new Button("Dodaj stol/mjesto");

    private Button removePlaceButton = new Button("Obriši stol/mjesto");

    public PlaceAdminPanel(){
        titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));

        numberOfPlaceTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    numberOfPlaceTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

//        TableColumn<Place, String>  placeCodeColumn = new TableColumn<>("Kod stola");
//        placeCodeColumn.setCellValueFactory(new PropertyValueFactory<Place, String>("code"));

        TableColumn<Place, Integer>  numberOfTableColumn = new TableColumn<>("Broj stola");
        numberOfTableColumn.setCellValueFactory(new PropertyValueFactory<Place, Integer>("numberOfPTable"));

        TableColumn<Place, Integer>  numberOfGuestColumn = new TableColumn<>("Broj gostiju");
        numberOfGuestColumn.setCellValueFactory(new PropertyValueFactory<Place, Integer>("numberOfGuest"));

        TableColumn<Place, BigDecimal> placePriceColumn = new TableColumn<>("Cijena stola");
        placePriceColumn.setCellValueFactory(new PropertyValueFactory<Place, BigDecimal>("price"));

        PlaceService placeService = PlaceServiceFactory.SERVICE.getPlaceService();
        placeObservableList = FXCollections.observableList(placeService.findAll());
        placeTableView.setItems(placeObservableList);
        placeTableView.getColumns().addAll(
               numberOfTableColumn, numberOfGuestColumn, placePriceColumn);

        getChildren().addAll(placeTableView, getForm());
    }

    private HBox getForm(){
        HBox form = new HBox();
        form.setSpacing(3);
        placeCodeTextField.setPromptText("KOD/BROJ STOLA..");
        numberOfPlaceTextField.setPromptText("Broj osoba za stolom..");
        priceTextField.setPromptText("Cijena stola..");
        addPlaceButton.setOnAction(this::addPlace);
        removePlaceButton.setOnAction(this::removePlace);
        form.getChildren().addAll(
                placeCodeTextField,
                numberOfPlaceTextField,
                priceTextField,
                addPlaceButton,
                removePlaceButton);
        return form;
    }

    private void addPlace(ActionEvent actionEvent) {
        Place place = new Place();
    }

    private void removePlace(ActionEvent actionEvent) {
        Place selectedPlace = (Place) PlaceService.getSelectionModel().getSelectedItem();
        PlaceService placeService = PlaceServiceFactory.SERVICE.getPlaceService();
        placeService.remove(selectedPlace);
        placeObservableList.remove(selectedPlace);
    }

    private void setAddPlaceButton(ActionEvent actionEvent){
        Place place = new Place();
        place.setCode(placeCodeTextField.getText());
        place.setNumberofguests(Integer.parseInt(numberOfPlaceTextField.getText()));
        place.setPrice(new BigDecimal(priceTextField.getText()));
        PlaceService placeService = PlaceServiceFactory.SERVICE.getPlaceService();
        placeService.create(place);
        placeObservableList.add(place);
        placeCodeTextField.setText("");
        numberOfPlaceTextField.clear();
        priceTextField.setText("");
    }
}