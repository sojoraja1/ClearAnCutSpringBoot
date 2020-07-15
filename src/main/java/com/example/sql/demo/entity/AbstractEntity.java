package com.example.sql.demo.entity;
/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class AbstractEntity extends AbstractPersistable<Long> {

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date update_at;
}

