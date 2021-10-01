package com.provideaged.provideaged.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @ClassName: TokenEntity
 * @Description: token表
 * @author: 巫运辰
 * @date: 2021/08/27 15:23
 */
@Data
@Entity
@Table(name = "token")//自动生成一个表名是user表
@Getter
@Setter
public class TokenEntity {
    /* tokenId */
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Long id;

    /* 用户ID */
    private Long userId;

    /* 刷新时间 */
    private int buildTime;

    /* token */
    private String token;
}