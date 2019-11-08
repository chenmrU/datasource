package com.cmr.datasource.entity.jpa;

import lombok.*;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author chenmengrui
 * @Description: user JPA版本
 * @date 2019/11/8 9:33
 */
@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;

    private Long userSex;

    private String userPhone;

    private String userEmail;

}
