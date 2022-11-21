package com.example.advanced.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_CAR_REGISTRATION")
@Getter
@Setter
@ToString(exclude = {"carOwner", "car"})
public class CarRegistration extends Period{

    @Id
    @GeneratedValue
    private Long carRegistrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_OWNER_ID")
    private CarOwner carOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    private Car car;

    private LocalDateTime carRegistrationRegisterDate;
    private LocalDateTime carRegistrationUpdateDate;

/*    public void create(CarOwner carOwnerId, Car carId, LocalDateTime carRegistrationRegisterDate, LocalDateTime carRegistrationUpdateDate) {
        this.carOwner = carOwner;
        this.car = car;
        this.carRegistrationRegisterDate = carRegistrationRegisterDate;
        this.carRegistrationUpdateDate = carRegistrationUpdateDate;
    }*/

    public void changeCarOwner(CarOwner carOwner, CarRegistration carRegistrationUpdateDate){
        this.carOwner = carOwner;
        carRegistrationUpdateDate.setCarRegistrationUpdateDate(LocalDateTime.now());
    }

}
