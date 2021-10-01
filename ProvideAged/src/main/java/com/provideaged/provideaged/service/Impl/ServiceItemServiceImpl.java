package com.provideaged.provideaged.service.Impl;

import com.provideaged.provideaged.dao.ServiceItemDao;
import com.provideaged.provideaged.dao.ServiceObjectDao;
import com.provideaged.provideaged.dao.ServicePersonnelDao;
import com.provideaged.provideaged.entity.ServiceItem;
import com.provideaged.provideaged.entity.ServiceObject;
import com.provideaged.provideaged.entity.ServicePersonnel;
import com.provideaged.provideaged.service.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ServiceItemServiceImpl
 * @Description: 服务项目
 * @author: 巫运辰
 * @date: 2021/08/20 11:41
 */
@Service
public class ServiceItemServiceImpl implements ServiceItemService {
    @Autowired
    ServiceItemDao serviceItemDao;
    @Autowired
    ServiceObjectDao serviceObjectDao;
    @Autowired
    ServicePersonnelDao servicePersonnelDao;

    @Override
    public List<ServiceItem> findByYear(int year, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByYear(year, pageable);
    }

    @Override
    public List<ServiceItem> findByMonth(int year, int month, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByMonth(year, month, pageable);
    }

    @Override
    public List<ServiceItem> findByDay(int year, int month, int day, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByDay(year, month, day, pageable);
    }

    @Override
    public List<ServiceItem> findByYearAndPersonnel(int year, long service_personnel_id, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByYearAndPersonnel(year, service_personnel_id, pageable);
    }

    @Override
    public List<ServiceItem> findByMonthAndPersonnel(int year, int month, long service_personnel_id, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByMonthAndPersonnel(year, month, service_personnel_id, pageable);
    }

    @Override
    public List<ServiceItem> findByDayAndPersonnel(int year, int month, int day, long service_personnel_id, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByDayAndPersonnel(year, month, day, service_personnel_id, pageable);
    }

    @Override
    public List<Object[]> findByServiceType(long typeId, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByServiceType(typeId, pageable);
    }

    @Override
    public List<Object[]> findByServiceTypeAndPersonnelId(long typeId, long personnelId, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByServiceTypeAndPersonnelId(typeId, personnelId, pageable);
    }

    @Override
    public List<ServiceItem> findByState(String state, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByState(state, pageable);
    }

    @Override
    public List<Object[]> findByStateAndPersonnelId(String state, long personnelId, int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return serviceItemDao.findByStateAndPersonnelId(state, personnelId, pageable);
    }

    @Override
    public void updateIntervalLength(long id, long interval_length) {
        serviceItemDao.updateIntervalLength(id, interval_length);
    }

    @Override
    public void updateStartService(long id, String address) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        serviceItemDao.updateStartService(id, currentTime, address);
    }

    @Override
    public void updateStopService(long id, String address) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        serviceItemDao.updateStopService(id, currentTime, address);
        updateTime(id);
    }

    @Override
    public void updateServiceState(long id, String service_state) {
        serviceItemDao.updateServiceState(id, service_state);
    }

    @Override
    public void save(ServiceItem serviceItem) {
        serviceItem.setHas_finished(0);
        serviceItemDao.save(serviceItem);
    }

    private void updateTime(long id) {
        ServiceItem serviceItem = serviceItemDao.getById(id);
        long time = serviceItem.getStop_time().getTime() - serviceItem.getStart_time().getTime();
        ServiceObject serviceObject = serviceObjectDao.getById(serviceItem.getService_object_id());
        ServicePersonnel servicePersonnel = servicePersonnelDao.getById(serviceItem.getService_personnel_id());
        serviceObjectDao.updateServiceTime(serviceObject.getId(), serviceObject.getService_time() + time / 1000);
        if (serviceItem.getHas_finished() != 1){
            servicePersonnelDao.updateServiceTimes(servicePersonnel.getUsername(), servicePersonnel.getService_times() + 1);
            serviceItemDao.updateFinishedState(id,1);
        }

        servicePersonnelDao.updateServiceTime(servicePersonnel.getUsername(), servicePersonnel.getService_time() + time / 1000);
    }

}