package ensa.socialsphere.repositories;

import ensa.socialsphere.domain.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, String> {
    UserRole findByAuthority(String authority);

    UserRole getByAuthority(String authority);
}
