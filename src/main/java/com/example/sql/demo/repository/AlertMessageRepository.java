package com.example.sql.demo.repository;
/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */

import com.example.sql.demo.entity.AlertMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlertMessageRepository extends JpaRepository<AlertMessage,Long> {

    List<AlertMessage> findAllByAlert_Id(Long id);

    @Query("select  a from AlertMessage  a where a.alert.id=?1")
    List<AlertMessage> customQuery(Long id);
}
