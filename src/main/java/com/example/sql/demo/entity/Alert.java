package com.example.sql.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */
@Entity
@Getter
@Setter
public class Alert extends AbstractEntity {

    @Column(unique = true)
    private String code;

    private Boolean active;
}
