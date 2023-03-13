package com.luti.report_application.repository;

import com.luti.report_application.model.KafkaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface KafkaOrderRepository extends JpaRepository<KafkaOrder, Long> {
    @Query(value ="SELECT SUM(k.amount) FROM Kafka_order k WHERE k.date BETWEEN ?1 AND ?2", nativeQuery = true)
   Double getTotalAmount(LocalDate ld1, LocalDate ld2);

    @Query(value ="SELECT COUNT(*) FROM Kafka_order k WHERE k.date BETWEEN ?1 AND ?2", nativeQuery = true)
    int getNumberOfOrders(LocalDate ld1, LocalDate ld2);
}
