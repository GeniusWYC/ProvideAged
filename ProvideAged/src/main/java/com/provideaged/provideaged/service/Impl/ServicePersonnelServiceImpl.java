package com.provideaged.provideaged.service.Impl;

import com.provideaged.provideaged.dao.ServicePersonnelDao;
import com.provideaged.provideaged.entity.ServicePersonnel;
import com.provideaged.provideaged.service.ServicePersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName: ServicePersonnelServiceImpl
 * @Description: 服务人员
 * @author: 巫运辰
 * @date: 2021/08/19 16:48
 */
@Service
public class ServicePersonnelServiceImpl implements ServicePersonnelService {
    @Autowired
    ServicePersonnelDao servicePersonnelDao;

    @Override
    public List<ServicePersonnel> findAll(int pageNumber,int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return servicePersonnelDao.queryAll(pageable);
    }

    @Override
    public ServicePersonnel queryByUsername(String username) {
        return servicePersonnelDao.queryByUsername(username);
    }

    @Override
    public void save(ServicePersonnel servicePersonnel) {
        servicePersonnelDao.save(servicePersonnel);
    }

    @Override
    public void deleteByUsername(String username) {
        servicePersonnelDao.deleteByUsername(username);
    }

    @Override
    public void updateBaseData(ServicePersonnel servicePersonnel) {
        servicePersonnelDao.updateBaseData(servicePersonnel.getUsername(), servicePersonnel.getId_number(),
                servicePersonnel.getName(), servicePersonnel.getPhone_number(), servicePersonnel.getTime_modify());
    }

    @Override
    public void updateServiceTime(ServicePersonnel servicePersonnel) {
        servicePersonnelDao.updateServiceTime(servicePersonnel.getUsername(), servicePersonnel.getService_time());
    }

    @Override
    public void updateServiceTimes(ServicePersonnel servicePersonnel) {
        servicePersonnelDao.updateServiceTimes(servicePersonnel.getUsername(), servicePersonnel.getService_times());
    }

    @Override
    public void updatePhoto(ServicePersonnel servicePersonnel) {
        servicePersonnelDao.updatePhoto(servicePersonnel.getUsername(), servicePersonnel.getPhoto());
    }


}