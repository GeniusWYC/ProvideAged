package com.provideaged.provideaged.service;

import com.provideaged.provideaged.entity.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceTypeService {
    void createServiceType(ServiceType serviceType);
    List<ServiceType> queryAll(int pageNumber,int pageSize);
}
