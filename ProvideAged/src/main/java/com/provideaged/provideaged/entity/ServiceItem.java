package com.provideaged.provideaged.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @ClassName: ServiceItem
 * @Description: 服务项目表
 * @author: 巫运辰
 * @date: 2021/08/13 15:49
 */
@Entity
@Table(name = "service_item")
@Getter
@Setter
public class ServiceItem {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private long id;
    private long service_personnel_id;//服务人员Id
    private long service_object_id;//服务对象Id
    private long service_type_id;//服务类型
    private int service_year;//服务时间(年)
    private int service_month;//服务时间(月)
    private int service_day;//服务时间(日)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp start_time;//服务开始时间日期
    private String start_address;//服务开始打卡地址
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp stop_time;//服务结束时间日期
    private String stop_address;//服务结束打卡地址
    private String service_state;//服务状态（执行中,待完成,已过期,已完成）
    private long interval_length;//间隔时长
    private int has_finished;//0:未打卡；1：已打卡
}