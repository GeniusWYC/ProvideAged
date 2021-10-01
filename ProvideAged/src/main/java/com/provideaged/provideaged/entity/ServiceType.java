package com.provideaged.provideaged.entity;

import javax.persistence.*;

/**
 * @ClassName: ServiceType
 * @Description: 服务项目类型表
 * @author: 巫运辰
 * @date: 2021/08/13 16:40
 */
@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private long id;
    private String service_type;//服务项目类型

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }
}