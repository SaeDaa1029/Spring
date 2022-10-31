package com.example.ex00.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DependencyTest {
    @Autowired
    private Coding coding;
    @Autowired
    private Restaurant restaurant;
    @Autowired
    private Chef chef;

    @Test/*테스트 메소드임을 spring에 보고*/
    public void dependencyTest(){
        /*@Slf4j는 문자열만 받아줌*/
        log.info(coding+"");
        log.info(restaurant+"");
        log.info(chef+"");

    }
}
