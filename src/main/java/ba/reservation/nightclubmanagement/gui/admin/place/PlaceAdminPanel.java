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
    private Label titleLabel = new Label("Administracija soba");
    private ObservableList<Place> roomObservableList;
    private TableView<Place> roomTableView = new TableView<>();

    private TextField roomCodeTextField = new TextField();
    private TextField numberOfBedsTextField = new TextField();
    private TextField priceTextField = new TextField();
    private Button addRoomButton = new Button("Dodaj sobu");
    private Button removeRoomButton = new Button("Obriši sobu");

    public PlaceAdminPanel(){
        titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));

        numberOfBedsTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    numberOfBedsTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        TableColumn<Place, String> roomCodeColumn = new TableColumn<>("Kod sobe");
        roomCodeColumn.setCellValueFactory(new PropertyValueFactory<Place, String>("code"));

        TableColumn<Place, Integer>  numberOfBedsColumn = new TableColumn<>("Broj kreveta");
        numberOfBedsColumn.setCellValueFactory(new PropertyValueFactory<Place, Integer>("numberOfBeds"));

        TableColumn<Place, BigDecimal> roomPriceColumn = new TableColumn<>("Cijena sobe");
        roomPriceColumn.setCellValueFactory(new PropertyValueFactory<Place, BigDecimal>("price"));

        PlaceService placeService = PlaceServiceFactory.SERVICE.getPlaceService();
        roomObservableList = FXCollections.observableList(placeService.findAll());
        roomTableView.setItems(roomObservableList);
        roomTableView.getColumns().addAll(
                roomCodeColumn, numberOfBedsColumn, roomPriceColumn);

        getChildren().addAll(roomTableView, getForm());
    }

    private HBox getForm(){
        HBox form = new HBox();
        form.setSpacing(3);
        roomCodeTextField.setPromptText("Kod sobe..");
        numberOfBedsTextField.setPromptText("Broj kreveta u sobi..");
        priceTextField.setPromptText("Cijena sobe..");
        addRoomButton.setOnAction(this::addRoom);
        removeRoomButton.setOnAction(this::removeRoom);
        form.getChildren().addAll(
                roomCodeTextField,
                numberOfBedsTextField,
                priceTextField,
                addRoomButton,
                removeRoomButton);
        return form;
    }

    private void removeRoom(ActionEvent actionEvent) {
        Place selectedRoom = roomTableView.getSelectionModel().getSelectedItem();
        PlaceService placeService = PlaceServiceFactory.SERVICE.getPlaceService();
        placeService.remove(selectedRoom);
        roomObservableList.remove(selectedRoom);
    }

    private void addRoom(ActionEvent actionEvent){
        Place room = new Place();
        room.setCode(roomCodeTextField.getText());
        room.setNumberofguests(Integer.parseInt(numberOfBedsTextField.getText()));
        room.setPrice(new BigDecimal(priceTextField.getText()));
        PlaceService roomService = PlaceServiceFactory.SERVICE.getPlaceService();
        roomService.create(room);
        roomObservableList.add(room);
        roomCodeTextField.setText("");
        numberOfBedsTextField.clear();
        priceTextField.setText("");
    }
}