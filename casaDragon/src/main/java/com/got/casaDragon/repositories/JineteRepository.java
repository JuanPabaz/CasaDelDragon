package com.got.casaDragon.repositories;

import com.got.casaDragon.models.Jinete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JineteRepository extends JpaRepository<Jinete, Integer> {
}
