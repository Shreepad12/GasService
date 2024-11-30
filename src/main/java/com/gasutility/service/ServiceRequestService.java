package com.gasutility.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gasutility.model.ServiceRequest;
import com.gasutility.repository.ServiceRequestRepository;

@Service
public class ServiceRequestService {
    private final ServiceRequestRepository serviceRequestRepository;

    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }

    public List<ServiceRequest> findByCustomerId(Long customerId) {
        return serviceRequestRepository.findByCustomerId(customerId);
    }

    public ServiceRequest createRequest(ServiceRequest request) {
        request.setCreatedAt(java.time.LocalDateTime.now());
        request.setStatus("Pending");
        return serviceRequestRepository.save(request);
    }
}
