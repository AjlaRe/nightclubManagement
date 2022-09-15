package ba.reservation.nightclubmanagement.gui.login;


import ba.reservation.nightclubmanagement.gui.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class LoginView extends GridPane {
    private final Label usernameLabel = new Label("Korisničko ime: ");
    private final Label passwordLabel = new Label("Lozinka: ");
    private final TextField usernameTextField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final Button loginButton = new Button("Prijava");
    private final Button cancelButton = new Button("Odustani");
    private final Label messageLabel = new Label();

    public LoginView() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(40, 25, 40, 25));
        setAlignment(Pos.CENTER);

        add(usernameLabel, 0, 0);
        add(usernameTextField, 1, 0);

        add(passwordLabel, 0, 1);
        add(passwordField, 1, 1);

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        loginButton.setOnAction(Controller.instance().getEventBus().getLoginEvent());
        cancelButton.setOnAction(Controller.instance().getEventBus().getCancelEvent());
        flowPane.getChildren().addAll(loginButton, cancelButton);
        add(flowPane, 1, 2);
        add(messageLabel, 1, 3);
    }

    public String getUsername() {
        return usernameTextField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public void setLoginMessage(String message){
        messageLabel.setText(message);
    }
}