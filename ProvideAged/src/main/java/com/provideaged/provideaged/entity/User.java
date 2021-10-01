package com.provideaged.provideaged.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * @ClassName: User
 * @Description: 账户表
 * @author: 巫运辰
 * @date: 2021/08/26 17:24
 */
@Data
@Entity
@Table(name = "user")//自动生成一个表名是user表
@Getter
@Setter
public class User {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private long id;
    @NotEmpty(message = "账号不能为空")
    private String username;//账号
    @NotEmpty(message = "密码不能为空")
    private String password;//密码
    private short role_id;//权限id，1为管理员，2为服务员
    private short state;//账号状态,1为正常，2为禁用

}