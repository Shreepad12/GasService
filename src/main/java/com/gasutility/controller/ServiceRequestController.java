package com.gasutility.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gasutility.model.ServiceRequest;
import com.gasutility.service.ServiceRequestService;

@RestController
@RequestMapping("/service-requests")
public class ServiceRequestController {
    private final ServiceRequestService serviceRequestService;

    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @PostMapping
    public ResponseEntity<ServiceRequest> createRequest(@RequestBody ServiceRequest request) {
        return ResponseEntity.ok(serviceRequestService.createRequest(request));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ServiceRequest>> getRequestsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(serviceRequestService.findByCustomerId(customerId));
    }
}
