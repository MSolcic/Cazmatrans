package com.cazmatrans.jwtauthentication.repository;

import com.cazmatrans.jwtauthentication.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListRepository extends JpaRepository<List, Long>{
        Optional<List> findByTitle(String title);
        Boolean existsByTitle(String title);
        Boolean existsByIsActive(String isActive);
}
