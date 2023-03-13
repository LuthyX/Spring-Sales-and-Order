package com.luti.report_application.controller;

import com.luti.report_application.request.ReportRequest;
import com.luti.report_application.response.OrderResponse;
import com.luti.report_application.response.ParseErrorResponse;
import com.luti.report_application.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api/v1/report")
public class OrderReportController {

    private final static String INCORRECT_FORMAT = "Incorrect Date Format, Input date as 'yyyy-mm-dd' ";
    private ReportService reportService;

    public OrderReportController(ReportService reportService) {
        this.reportService = reportService;
    }



    @PostMapping()
    private ResponseEntity<?>getOrderReport(@RequestBody ReportRequest request){
        try {
        LocalDate start = LocalDate.parse(request.getStart_date());
        LocalDate end = LocalDate.parse(request.getEnd_date());
        Double amount = reportService.getTotalAmountOfOrders(start, end);
        Integer total_orders = reportService.getTotalNumberOfOrders(start, end);
        OrderResponse response = new OrderResponse();
        response.setSuccess(true);
        response.setDate("FROM: " + request.getStart_date() + " TO: " + request.getEnd_date());
        response.setTotal_Order_Amount(amount);
        response.setTotal_Order(total_orders);
        return ResponseEntity.status(200).body(response);
        }
        catch (DateTimeParseException e){
            ParseErrorResponse response1 = new ParseErrorResponse();
            response1.setMsg(INCORRECT_FORMAT);
            return ResponseEntity.status(400).body(response1);
        }
    }
}
