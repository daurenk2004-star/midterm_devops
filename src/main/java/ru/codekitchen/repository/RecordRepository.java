package ru.codekitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.codekitchen.entity.Record;
import ru.codekitchen.entity.RecordStatus;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    @Modifying
    @Query("UPDATE Record SET status = :status WHERE id= :id")
    void update(Long id, @Param("status") RecordStatus newStatus);
}
