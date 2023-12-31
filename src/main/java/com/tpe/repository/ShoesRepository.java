package com.tpe.repository;

import com.tpe.domain.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes,Long> {
    boolean existsByName(String name);

    Shoes findByName(String name);
}
