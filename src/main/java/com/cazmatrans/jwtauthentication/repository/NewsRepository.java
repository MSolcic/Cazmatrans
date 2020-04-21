package com.cazmatrans.jwtauthentication.repository;

import com.cazmatrans.jwtauthentication.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
        Optional<News> findByTitle(String title);
        Boolean existsByTitle(String title);
        Boolean existsByIsActive(String isActive);

    //Page<News> getPage(Pageable pageable);
}
