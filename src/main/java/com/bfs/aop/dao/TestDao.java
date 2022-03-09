package com.bfs.aop.dao;

import com.bfs.aop.domain.User;
import com.bfs.aop.exception.MyExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TestDao {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    static List<User> list;
    static{
        list = new ArrayList();
        list.add(new User(1,  "UserA",18));
        list.add(new User(2,  "UserB",22));
        list.add(new User(3,  "UserC",39));
        list.add(new User(4,  "UserD",26));
    }

    public List<User> findAll() {
        List<User> users = list;
        logger.info(String.valueOf(users));
        return users;
    }

    public String test(){
        logger.trace("Dao trace");
        logger.debug("Dao debug");
        logger.info("Dao info");
        logger.warn("Dao warn");
        logger.error("Dao error");
        return "Data From DAO Layer";
    }

    public Integer testAge(Integer age) throws MyExceptionHandler.AgeIllegalArgumentException {
        if(age > 68) {
            logger.error("Age should be lower than 68");
            throw new MyExceptionHandler.AgeIllegalArgumentException("Age should be a positive number");
        } else if(age < 0) {
            logger.error("Age should be a positive number");
            throw new MyExceptionHandler.AgeIllegalArgumentException("Age should be a positive number");
        }
        return age;
    }


}
