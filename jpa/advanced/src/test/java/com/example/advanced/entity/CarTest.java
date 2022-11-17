package com.example.advanced.entity;

import com.example.advanced.repository.CarOwnerRepository;
import com.example.advanced.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CarTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Test
    public void saveTest(){
        CarOwner carOwner = new CarOwner();
        Car car1 = new Car();
        Car car2 = new Car();

        carOwner.setCarOwnerName("김인영");
        carOwner.setCarOwnerAge(24);
        carOwner.setCarOwnerZipcode("10102");
        carOwner.setCarOwnerAddress("김포시 봉화로");
        carOwner.setCarOwnerAddressDetail("삼환아파트");

        carOwnerRepository.save(carOwner);

        car1.setCarOwner(carOwner);
        car1.setCarName("부릉부릉");
        car1.setCarBrand("Bentley");
        car1.setCarPrice(360000000L);
        car1.setCarColor("red");
        car1.setCarReleaseDate(LocalDateTime.of(2019, 12, 4, 0, 0));


        carRepository.save(car1);

        car2.setCarOwner(carOwner);
        car2.setCarName("빵빵");
        car2.setCarBrand("Benz");
        car2.setCarPrice(120000000L);
        car2.setCarColor("blue");
        car2.setCarReleaseDate(LocalDateTime.of(2019, 12, 4, 0, 0));
        LocalDateTime.now();
        carRepository.save(car2);

    }

    @Test
    public void findTest(){
        Optional<Car> findCar = carRepository.findById(2L);
        if(findCar.isPresent()){
            Assertions.assertThat(findCar.get().getCarName()).isEqualTo("부릉부릉");
            log.info("주인 이름" + findCar.get().getCarOwner().getCarOwnerName());
            log.info("주인 이름" + findCar.get().getCarOwner().getCarOwnerId());
        }

    }

    @Test
    public void updateTest(){
        carRepository.findAll().get(0).getCarOwner().setCarOwnerName("김녕");

    }


}
