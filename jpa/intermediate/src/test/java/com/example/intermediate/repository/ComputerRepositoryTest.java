package com.example.intermediate.repository;

import com.example.intermediate.entity.Desktop;
import com.example.intermediate.entity.Phone;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Month;


@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class ComputerRepositoryTest {

    @Autowired private DesktopRepository desktopRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    public void saveTest(){
        Desktop desktop = new Desktop();
        Phone phone = new Phone();

        desktop.create("FHD", "한성", "무지빠름",
                "900000",
                LocalDateTime.of(2022, Month.AUGUST, 11, 0, 0, 0),
                "16", "256", "GeForce 400", "intel i3",
                LocalDateTime.of(2022, Month.AUGUST, 11, 0, 0, 0), LocalDateTime.now(), "logitec");
        phone.create("FHD", "애플", "아이폰13",
                "900000",
                LocalDateTime.of(2022, Month.AUGUST, 11, 0, 0, 0),
                "16", "256", "GeForce 400", "intel i3",
                LocalDateTime.of(2022, Month.AUGUST, 11, 0, 0, 0), LocalDateTime.now(), "100");

        assertThat(desktopRepository.save(desktop).getComputerBrand()).isEqualTo("한성");
        assertThat(phoneRepository.save(phone).getComputerBrand()).isEqualTo("애플");
    }
}