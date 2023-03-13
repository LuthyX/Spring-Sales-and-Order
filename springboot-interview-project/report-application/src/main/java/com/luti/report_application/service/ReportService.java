package com.luti.report_application.service;

import com.luti.report_application.repository.KafkaOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReportService {
    private KafkaOrderRepository kafkaOrderRepository;

    public ReportService(KafkaOrderRepository kafkaOrderRepository) {
        this.kafkaOrderRepository = kafkaOrderRepository;
    }
    public Double getTotalAmountOfOrders(LocalDate start, LocalDate end){
        if(kafkaOrderRepository.getTotalAmount(start, end) == null){
            return 0.0;
        }
        return kafkaOrderRepository.getTotalAmount(start, end);
    }
    public Integer getTotalNumberOfOrders(LocalDate start, LocalDate end){
        return kafkaOrderRepository.getNumberOfOrders(start, end);
    }
}
