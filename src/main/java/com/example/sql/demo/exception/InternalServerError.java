package com.example.sql.demo.exception;
/*
 * @author: Sundar Gautam
 * @create date: 7/12/2020
 */


public class InternalServerError extends Exception{

    public InternalServerError(String ok){
        super(ok);
    }
}

