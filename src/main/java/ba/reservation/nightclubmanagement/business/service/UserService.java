package ba.reservation.nightclubmanagement.business.service;



import ba.reservation.nightclubmanagement.business.model.User;
import ba.reservation.nightclubmanagement.commons.Constants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

class UserService extends AbstractService<User, Integer> implements UserServiceLocal {//User find Integer


    public UserService() {
        super(User.class);
    }

    @Override
    public User login(String username, String password) {
        if(username == null || username.isEmpty()){
            return null;
        }
        if(password == null || password.isEmpty()){
            return null;
        }
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        try{
            User user = (User)query.getSingleResult();
            if(user != null && password.equals(user.getPassword())){
                return user;
            }
        }catch (NoResultException e){
            System.err.println("Not exist user with username: " + username);
            return null;
        }
        return null;
    }


    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory(Constants.PU_NAME);
        return entityManagerFactory.createEntityManager();
    }
}