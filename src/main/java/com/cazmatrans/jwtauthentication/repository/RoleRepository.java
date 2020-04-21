package com.cazmatrans.jwtauthentication.repository;

import java.util.Optional;

import com.cazmatrans.jwtauthentication.model.Role;
import com.cazmatrans.jwtauthentication.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
