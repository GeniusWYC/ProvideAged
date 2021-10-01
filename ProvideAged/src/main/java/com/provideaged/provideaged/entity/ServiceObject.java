package com.provideaged.provideaged.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Blob;
import java.sql.Timestamp;

/**
 * @ClassName: ServiceObject
 * @Description: 服务对象表
 * @author: 巫运辰
 * @date: 2021/07/28 14:26
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "service_object")//自动生成一个表名是ServiceObject表
@Getter
@Setter

public class ServiceObject {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private long id;
    @NotEmpty(message = "身份证号不能为空")
    private String id_number;//身份证号
    private String object_name;//服务对象姓名
    private String city_name = "南京市";//城市名
    private String district_name;//区名
    private String address;//详细地址
    private long phone_number;//电话号码
    private long service_time;//服务时长(秒)
    private String photo;//照片

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp time_create;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp time_modify;//上次修改时间
}