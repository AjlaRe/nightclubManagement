package ba.reservation.nightclubmanagement.business.service;



import ba.reservation.nightclubmanagement.business.model.User;


import javax.persistence.*;
import java.util.List;


class UserService extends AbstractService implements UserServiceLocal {


    public UserService() {
        super(User.class);
    }

    @Override
    public User login(String username, String password) {

        if (username == null || username.isEmpty()) {
            return null;
        }

        if (password == null || password.isEmpty()) {
            return null;

        }
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        try{
            User user = (User)query.getSingleResult();
            if(user != null && password.equals(user.getPassword())) {
                return user;
            }

        }catch (NoResultException e) {
            System.err.println("Not exist user with username:" + username);
            return null;
        }

        return null;
    }






    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nightclubManagementPU");
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void removeById(Integer id) {

    }

    @Override
    public User find(Integer id) {
        return null;
    }


}
