package com.example.rentacar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarEntityRepository extends JpaRepository<CarEntity, Integer> {

    Optional<CarEntity> findById(Long id);

  //  List<CarEntity> findAllByUserId(Long userId, Optional<String> name);

    @Query("SELECT c FROM CarEntity c WHERE c.userId = :userId" +
            " AND (:namePattern IS NULL OR c.name LIKE :namePattern)")
    List<CarEntity> findAllByUserId(Long userId, String namePattern);



    @Query("SELECT c FROM CarEntity c WHERE c.userId = :userId AND c.id = :carId")
    Optional<CarEntity> findByUserIdAndId(Long userId, Long carId);
}

