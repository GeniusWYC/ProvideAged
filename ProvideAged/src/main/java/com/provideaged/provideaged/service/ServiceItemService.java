package com.provideaged.provideaged.service;

import com.provideaged.provideaged.entity.ServiceItem;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ServiceItemService {
    List<ServiceItem> findByYear(int year,int pageNumber,int pageSize);

    List<ServiceItem> findByMonth(int year, int month,int pageNumber,int pageSize);

    List<ServiceItem> findByDay(int year, int month, int day,int pageNumber,int pageSize);

    List<ServiceItem> findByYearAndPersonnel(int year, long service_personnel_id,int pageNumber,int pageSize);

    List<ServiceItem> findByMonthAndPersonnel(int year, int month, long service_personnel_id,int pageNumber,int pageSize);

    List<ServiceItem> findByDayAndPersonnel(int year, int month, int day, long service_personnel_id,int pageNumber,int pageSize);

    List<Object[]> findByServiceType(long typeId,int pageNumber,int pageSize);

    List<Object[]> findByServiceTypeAndPersonnelId(long typeId, long personnelId,int pageNumber,int pageSize);

    List<ServiceItem> findByState(String state,int pageNumber,int pageSize);

    List<Object[]> findByStateAndPersonnelId(String state, long personnelId,int pageNumber,int pageSize);

    void updateIntervalLength(long id, long interval_length);

    void updateStartService(long id, String address);

    void updateStopService(long id, String address);

    void updateServiceState(long id, String service_state);

    void save(ServiceItem serviceItem);
}
