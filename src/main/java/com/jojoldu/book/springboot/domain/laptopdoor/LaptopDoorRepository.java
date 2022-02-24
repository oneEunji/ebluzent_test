package com.jojoldu.book.springboot.domain.laptopdoor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LaptopDoorRepository extends JpaRepository<LaptopDoor, Long> {

    @Query("SELECT ltd FROM LaptopDoor ltd ORDER BY ltd.id DESC")
    List<LaptopDoor> findAllDesc();


}
