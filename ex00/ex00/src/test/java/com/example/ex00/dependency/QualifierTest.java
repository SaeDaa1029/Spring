package com.example.ex00.dependency;

import com.example.ex00.qualifier.Computer;
import com.example.ex00.qualifier.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class QualifierTest {
    @Autowired @Qualifier("desktop")
    private Computer desktop;
    @Autowired @Qualifier("laptop")
    private Computer laptop;
    @Autowired
    private Computer computer;

    @Autowired
    private Restaurant restaurant;

    @Autowired
    private Restaurant outback;

    @Autowired @Qualifier("vips")
    private Restaurant vips;

    @Test
    public void qualifierTest(){
        log.info(desktop + "");
        log.info(laptop + "");
        log.info(computer + "");
        log.info(vips + "");
        log.info(outback + "");
        log.info("빕스 스테이크 가격 : "+vips.getSteakPrice());
        log.info("아웃백 스테이크 가격 : " + outback.getSteakPrice());
        log.info("빕스 셀바 이용가능 여부 : "+vips.UseSelfbar());
        log.info("아웃백 셀바 이용가능 여부 : "+outback.UseSelfbar());
    }
}