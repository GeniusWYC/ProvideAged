package com.provideaged.provideaged.dao;

import com.provideaged.provideaged.entity.ServiceType;
import com.provideaged.provideaged.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceTypeDao extends JpaRepository<ServiceType,Long>, JpaSpecificationExecutor<ServiceType> {
    @Query("from ServiceType")
    List<ServiceType> queryAll(Pageable pageable);
}
