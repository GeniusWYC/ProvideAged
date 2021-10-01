package com.provideaged.provideaged.service.Impl;

import com.provideaged.provideaged.dao.ServiceObjectDao;
import com.provideaged.provideaged.entity.ServiceObject;
import com.provideaged.provideaged.service.ServiceObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ServiceObjectServiceImpl
 * @Description: 服务对象
 * @author: 巫运辰
 * @date: 2021/08/18 20:31
 */
@Service
public class ServiceObjectServiceImpl implements ServiceObjectService {
    @Autowired
    ServiceObjectDao serviceObjectDao;

    @Override
    public List<ServiceObject> findAll(int pageNumber,int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceObjectDao.queryAll(pageable);
    }

    @Override
    public void save(ServiceObject serviceObject) {
        serviceObjectDao.save(serviceObject);
    }

    @Override
    public void deleteByIdNumber(String idNumber) {
        serviceObjectDao.deleteByIdNumber(idNumber);
    }

    @Override
    public void updateAddress(ServiceObject serviceObject) {
        serviceObjectDao.updateAddress(serviceObject.getId(), serviceObject.getDistrict_name(), serviceObject.getAddress());
    }

    @Override
    public void updateBaseData(ServiceObject serviceObject) {
        serviceObjectDao.updateBaseData(serviceObject.getId(), serviceObject.getId_number(), serviceObject.getObject_name(),
                serviceObject.getPhone_number(), serviceObject.getTime_modify());
    }

    @Override
    public void updatePhoto(ServiceObject serviceObject) {
        serviceObjectDao.updatePhoto(serviceObject.getId(), serviceObject.getPhoto());

    }

    @Override
    public ServiceObject queryByIdNumber(String idNumber) {
        return serviceObjectDao.queryByIdNumber(idNumber);
    }

    @Override
    public void updateServiceTime(long id, long service_time) {
        serviceObjectDao.updateServiceTime(id, service_time);
    }

    @Override
    public List<ServiceObject> queryByObjectName(String name) {
        return serviceObjectDao.queryByObjectName(name);
    }

    @Override
    public List<ServiceObject> queryByDistrictName(String name) {
        return serviceObjectDao.queryByDistrictName(name);
    }
}