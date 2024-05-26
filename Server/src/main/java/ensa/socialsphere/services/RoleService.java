package ensa.socialsphere.services;

import ensa.socialsphere.domain.entities.UserRole;

public interface RoleService {
    boolean persist(UserRole role) throws Exception;

    UserRole getByName(String name);
}
