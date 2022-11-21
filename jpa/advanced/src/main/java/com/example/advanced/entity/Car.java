package com.example.advanced.entity;


import com.example.advanced.type.CarBrand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_CAR")
@Getter @Setter @ToString
public class Car extends Period{
    @Id @GeneratedValue
    private Long carId;
    @Enumerated(EnumType.STRING)
    private CarBrand carBrand;
    private String carName;
    private String carColor;
    private Long carPrice;
    private LocalDateTime carReleaseDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    @JoinColumn(name = "CAR_REGISTRATION_ID")
    private List<CarRegistration> carRegistration;



    public void create(CarBrand carBrand, String carName, String carColor, Long carPrice, LocalDateTime carReleaseDate) {
        this.carBrand = carBrand;
        this.carName = carName;
        this.carColor = carColor;
        this.carPrice = carPrice;
        this.carReleaseDate = carReleaseDate;
    }





}


















