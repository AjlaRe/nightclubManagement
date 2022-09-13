package ba.reservation.nightclubmanagement.business.service;

import ba.reservation.nightclubmanagement.business.model.Privilege;
import ba.reservation.nightclubmanagement.commons.Constants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class PrivilegeService extends  AbstractService<Privilege, Integer>  implements PrivilegeServiceLocal {
    public PrivilegeService(){
        super(Privilege.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PU_NAME);
        return entityManagerFactory.createEntityManager();
    }
}