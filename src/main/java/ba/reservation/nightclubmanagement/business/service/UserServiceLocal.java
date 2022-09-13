package ba.reservation.nightclubmanagement.business.service;


import ba.reservation.nightclubmanagement.business.model.User;

import java.util.List;


public interface UserServiceLocal {

    public User login(String username, String password);

    List<User> findAll();

    void create(User user);

    void edit(User user);

    void remove(User user);

    void removeById(Integer id);

    User find(Integer id);

}


