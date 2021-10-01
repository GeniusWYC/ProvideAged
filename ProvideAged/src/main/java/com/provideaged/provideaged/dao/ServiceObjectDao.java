package com.provideaged.provideaged.dao;

import com.provideaged.provideaged.entity.ServiceObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Transactional
public interface ServiceObjectDao extends JpaRepository<ServiceObject, Long>, JpaSpecificationExecutor<ServiceObject> {
    @Modifying
    @Query("delete from ServiceObject where id_number = ?1")
    void deleteByIdNumber(String id_number);

    @Modifying
    @Query("update ServiceObject set district_name = ?2,address = ?3 where id = ?1")
    void updateAddress(long id, String district_name, String address);

    @Modifying
    @Query("update ServiceObject set id_number = ?2,object_name = ?3,phone_number = ?4 ,time_modify = ?5 where id = ?1")
    void updateBaseData(long id, String id_number, String object_name, long phone_number, Timestamp time_modify);

    @Modifying
    @Query("update ServiceObject set photo = ?2 where id = ?1")
    void updatePhoto(long id, String photo);

    @Query("from  ServiceObject where id_number = ?1")
    ServiceObject queryByIdNumber(String id_number);

    @Modifying
    @Query("update ServiceObject set service_time = ?2 where id = ?1")
    void updateServiceTime(long id, long service_time);

    @Query("from ServiceObject")
    List<ServiceObject> queryAll(Pageable pageable);

    @Query("from ServiceObject where object_name = ?1")
    List<ServiceObject> queryByObjectName(String name);

    @Query("from ServiceObject where district_name = ?1")
    List<ServiceObject> queryByDistrictName(String name);


}
