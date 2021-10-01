package com.provideaged.provideaged.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

/**
 * @ClassName: ServicePersonnel
 * @Description: 服务人员表
 * @author: 巫运辰
 * @date: 2021/08/13 14:53
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "service_personnel")//自动生成一个表名是personnel表
@Getter
@Setter
public class ServicePersonnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private long id;
    @NotEmpty(message = "身份证号不能为空")
    private String id_number;//身份证号
    private String name;//服务人员姓名
    private long phone_number;//电话号码
    private long service_time;//服务时长（秒）
    private int service_times;//服务次数
    @NotEmpty(message = "账号不能为空")
    private String username;//账号
    private String photo;//照片
    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp time_create;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp time_modify;//上次修改时间
}