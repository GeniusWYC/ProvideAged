package com.provideaged.provideaged.service;

import com.provideaged.provideaged.entity.ServiceObject;
import com.provideaged.provideaged.entity.User;

import java.util.List;

public interface ServiceObjectService {
    List<ServiceObject> findAll(int pageNumber,int pageSize);

    void save(ServiceObject serviceObject);

    void deleteByIdNumber(String idNumber);

    void updateAddress(ServiceObject serviceObject);

    void updateBaseData(ServiceObject serviceObject);

    void updatePhoto(ServiceObject serviceObject);

    ServiceObject queryByIdNumber(String idNumber);

    void updateServiceTime(long id, long service_time);

    List<ServiceObject> queryByObjectName(String name);

    List<ServiceObject> queryByDistrictName(String name);
}
