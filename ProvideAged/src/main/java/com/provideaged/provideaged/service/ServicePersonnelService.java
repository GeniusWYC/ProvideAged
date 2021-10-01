package com.provideaged.provideaged.service;

import com.provideaged.provideaged.entity.ServicePersonnel;
import com.provideaged.provideaged.entity.User;

import java.sql.Timestamp;
import java.util.List;

public interface ServicePersonnelService {
    List<ServicePersonnel> findAll(int pageNumber,int pageSize);

    ServicePersonnel queryByUsername(String username);

    void save(ServicePersonnel servicePersonnel, User user);

    void deleteByUsername(String username);

    void updateBaseData(ServicePersonnel servicePersonnel);

    void updateServiceTime(ServicePersonnel servicePersonnel);

    void updateServiceTimes(ServicePersonnel servicePersonnel);

    void updatePhoto(ServicePersonnel servicePersonnel);
}
