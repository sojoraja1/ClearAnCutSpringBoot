package com.example.sql.demo.repository;
/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */

import com.example.sql.demo.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert,Long> {

Alert findByCode(String code);

@Query("select alert from Alert alert where alert.active=?1")
List<Alert> customQuery(Boolean active);
}
