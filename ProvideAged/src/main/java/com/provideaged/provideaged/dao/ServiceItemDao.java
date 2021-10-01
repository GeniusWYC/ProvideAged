package com.provideaged.provideaged.dao;

import com.provideaged.provideaged.entity.ServiceItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Transactional
public interface ServiceItemDao extends JpaRepository<ServiceItem, Long>, JpaSpecificationExecutor<ServiceItem> {
    @Query("from ServiceItem where service_year = ?1")
    List<ServiceItem> findByYear(int year, Pageable pageable);

    @Query("from ServiceItem where service_year = ?1 and service_month = ?2")
    List<ServiceItem> findByMonth(int year, int month, Pageable pageable);

    @Query("from ServiceItem where service_year = ?1 and service_month = ?2 and service_day = ?3")
    List<ServiceItem> findByDay(int year, int month, int day, Pageable pageable);

    @Query("from ServiceItem where service_year = ?1 and service_personnel_id = ?2")
    List<ServiceItem> findByYearAndPersonnel(int year, long service_personnel_id, Pageable pageable);

    @Query("from ServiceItem where service_year = ?1 and service_month = ?2 and service_personnel_id = ?3")
    List<ServiceItem> findByMonthAndPersonnel(int year, int month, long service_personnel_id, Pageable pageable);

    @Query("from ServiceItem where service_year = ?1 and service_month = ?2 and service_day = ?3 and service_personnel_id = ?4")
    List<ServiceItem> findByDayAndPersonnel(int year, int month, int day, long service_personnel_id, Pageable pageable);

    @Query("select si,st from ServiceItem si inner join ServiceType st on si.service_type_id = st.id where si.service_type_id = ?1")
    List<Object[]> findByServiceType(long typeId, Pageable pageable);

    @Query("select si,st from ServiceItem si inner join ServiceType st on si.service_type_id = st.id where si.service_type_id = ?1 and si.service_personnel_id = ?2")
    List<Object[]> findByServiceTypeAndPersonnelId(long typeId, long personnelId, Pageable pageable);

    @Query("from ServiceItem where service_state = ?1")
    List<ServiceItem> findByState(String state, Pageable pageable);

    @Query("select so,si from ServiceItem si inner join ServiceObject so on si.service_object_id = so.id where si.service_state = ?1 and si.service_personnel_id = ?2")
    List<Object[]> findByStateAndPersonnelId(String state, long personnelId, Pageable pageable);

    @Modifying
    @Query("update ServiceItem set interval_length = ?2 where id = ?1")
    void updateIntervalLength(long id, long interval_length);

    @Modifying
    @Query("update ServiceItem set start_time = ?2 ,start_address = ?3 where id = ?1")
    void updateStartService(long id, Timestamp startTime, String address);

    @Modifying
    @Query("update ServiceItem set stop_time = ?2 ,stop_address = ?3 where id = ?1")
    void updateStopService(long id, Timestamp stopTime, String address);

    @Modifying
    @Query("update ServiceItem set service_state = ?2 where id = ?1")
    void updateServiceState(long id, String service_state);

    @Query("select start_time from ServiceItem where id = ?1")
    Timestamp queryStartTime(long id);

    @Modifying
    @Query("update ServiceItem set has_finished = ?2 where id = ?1")
    void updateFinishedState(long id,int finishState);
}
