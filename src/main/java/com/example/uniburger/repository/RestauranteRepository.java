package com.example.uniburger.repository;

import com.example.uniburger.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}