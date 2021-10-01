package com.provideaged.provideaged.service.Impl;

import com.provideaged.provideaged.dao.ServiceTypeDao;
import com.provideaged.provideaged.entity.ServiceType;
import com.provideaged.provideaged.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ServiceTypeServiceImpl
 * @Description: 服务项目
 * @author: 巫运辰
 * @date: 2021/09/22 14:20
 */
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeDao serviceTypeDao;

    @Override
    public void createServiceType(ServiceType type) {
        serviceTypeDao.save(type);
    }

    @Override
    public List<ServiceType> queryAll(int pageNumber,int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceTypeDao.queryAll(pageable);
    }
}