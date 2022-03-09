package com.bfs.aop.controller;

import com.bfs.aop.domain.AgeResponse;
import com.bfs.aop.domain.User;
import com.bfs.aop.exception.MyExceptionHandler;
import com.bfs.aop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public ResponseEntity<String> testExecutionTime()  {
        String res = testService.test();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> testfindAllUsers()  {
        List<User> res = testService.findAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity testException(@PathVariable Integer age) throws MyExceptionHandler.AgeIllegalArgumentException {
        AgeResponse ageResponse = AgeResponse.builder().age(testService.testAge(age)).build();
        return new ResponseEntity<>(ageResponse, HttpStatus.OK);
    }
}
