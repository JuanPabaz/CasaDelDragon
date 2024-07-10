package com.got.casaDragon.repositories;

import com.got.casaDragon.models.Dragon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DragonRepository extends JpaRepository<Dragon,Integer> {


}
