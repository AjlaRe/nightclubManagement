module ba.reservation.nightclubmanagement {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.persistence;
    requires java.xml.bind;
    requires java.naming;
    requires java.base;
    requires java.sql;
    requires java.sql.rowset;
    requires mysql.connector.java;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires java.desktop;


    opens ba.reservation.nightclubmanagement to javafx.fxml;
    opens ba.reservation.nightclubmanagement.business.model to org.hibernate.orm.core;
    opens ba.reservation.nightclubmanagement.gui to javafx.base;

    exports ba.reservation.nightclubmanagement;
    exports ba.reservation.nightclubmanagement.business.model;


}


