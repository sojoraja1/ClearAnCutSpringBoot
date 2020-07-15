package com.example.sql.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */
@Entity
@Getter
@Setter
public class AlertMessage extends AbstractEntity {

    private String alertHeading;

    private String alertDescription;

    @ManyToOne
    private Alert alert;

}
