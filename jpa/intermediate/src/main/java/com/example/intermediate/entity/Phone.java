package com.example.intermediate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Phone")
@Table(name = "TBL_PHONE")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Phone extends Computer{

    @Column(name = "PHONE_BATTERY")
    private String phoneBattery;

    public void create(String computerScreen, String computerBrand, String computerName, String computerPrice, LocalDateTime computerReleaseDate, String computerRam, String computerSsd, String computerGpu, String computerProcessor, LocalDateTime computerCreateDate, LocalDateTime computerUpdateDate, String phoneBattery) {
        super.create(computerScreen, computerBrand, computerName, computerPrice, computerReleaseDate, computerRam, computerSsd, computerGpu, computerProcessor, computerCreateDate, computerUpdateDate);
        this.phoneBattery = phoneBattery;
    }
}

