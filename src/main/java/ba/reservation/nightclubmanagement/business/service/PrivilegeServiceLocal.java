package ba.reservation.nightclubmanagement.business.service;


import ba.reservation.nightclubmanagement.business.model.Privilege;

import java.util.List;

public interface PrivilegeServiceLocal  {
    List<Privilege> findAll();
}
