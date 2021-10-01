package com.provideaged.provideaged.dao;

import com.provideaged.provideaged.entity.ServicePersonnel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Transactional
public interface ServicePersonnelDao extends JpaRepository<ServicePersonnel, Long>, JpaSpecificationExecutor<ServicePersonnel> {
    @Query("from ServicePersonnel where username = ?1")
    ServicePersonnel queryByUsername(String username);

    @Modifying
    @Query("delete from ServicePersonnel where username = ?1")
    void deleteByUsername(String username);

    @Modifying
    @Query("update ServicePersonnel set id_number = ?2,name = ?3,phone_number = ?4 ,time_modify = ?5 where username = ?1")
    void updateBaseData(String username, String id_number, String name, long phone_number, Timestamp time_modify);

    @Modifying
    @Query("update ServicePersonnel set service_time = ?2 where username = ?1")
    void updateServiceTime(String username, long service_time);

    @Modifying
    @Query("update ServicePersonnel set service_times = ?2 where username = ?1")
    void updateServiceTimes(String username, int times);

    @Modifying
    @Query("update ServicePersonnel set photo = ?2 where username = ?1")
    void updatePhoto(String username, String photo);

    @Query("from ServicePersonnel")
    List<ServicePersonnel> queryAll(Pageable pageable);
}
