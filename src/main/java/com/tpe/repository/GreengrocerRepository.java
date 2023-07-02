package com.tpe.repository;

import com.tpe.domain.Greengrocer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreengrocerRepository extends JpaRepository<Greengrocer,Long> {
}
