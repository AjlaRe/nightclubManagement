package ba.reservation.nightclubmanagement.gui;


import ba.reservation.nightclubmanagement.business.model.User;
import ba.reservation.nightclubmanagement.gui.admin.AdminView;
import ba.reservation.nightclubmanagement.gui.employee.EmployeeView;
import ba.reservation.nightclubmanagement.gui.event.EventBus;
import ba.reservation.nightclubmanagement.gui.login.LoginView;

import javafx.stage.Stage;

public class Controller {
    private static Controller INSTANCE = null;

    private LoginView loginView;
    private AdminView adminView;
    private EmployeeView employeeView;
    private User loggedUser;
    private Stage stage;
    private EventBus eventBus = new EventBus();

    private Controller() {
    }


    public static Controller instance() {
        if(INSTANCE == null){
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }

    public void setEmployeeView(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

}