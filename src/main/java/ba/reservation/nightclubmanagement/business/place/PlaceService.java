package ba.reservation.nightclubmanagement.business.place;

import ba.reservation.nightclubmanagement.business.model.Place;
import ba.reservation.nightclubmanagement.business.service.AbstractService;
import ba.reservation.nightclubmanagement.commons.Constants;

import javafx.scene.control.SelectionModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PlaceService extends AbstractService<Place, Integer> {
    PlaceService() {
        super(Place.class);
    }

    public static SelectionModel<Object> getSelectionModel() {
        return null;
    }


    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory(Constants.PU_NAME);
        return entityManagerFactory.createEntityManager();
    }
}