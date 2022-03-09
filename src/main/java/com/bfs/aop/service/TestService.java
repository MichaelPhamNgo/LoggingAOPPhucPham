package com.bfs.aop.service;

import com.bfs.aop.dao.TestDao;
import com.bfs.aop.domain.User;
import com.bfs.aop.exception.MyExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestDao testDao;

    public String test(){
        String res = testDao.test();
        return res;
    }

    public Integer testAge(Integer age) throws MyExceptionHandler.AgeIllegalArgumentException {
        Integer resAge = testDao.testAge(age);
        return resAge;
    }

    public List<User> findAll() {
        return testDao.findAll();
    }
}
