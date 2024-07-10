package com.got.casaDragon.repositories;

import com.got.casaDragon.models.Aliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliadoRepository extends JpaRepository<Aliado,Integer> {
}
