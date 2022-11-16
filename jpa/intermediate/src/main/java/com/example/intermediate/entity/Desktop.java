package com.example.intermediate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Desktop")
@Table(name = "TBL_DESKTOP")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Desktop extends Computer{

    @Column(name = "DESKTOP_KEYBOARD")
    private String desktopKeyboard;

    public void create(String computerScreen, String computerBrand, String computerName, String computerPrice, LocalDateTime computerReleaseDate, String computerRam, String computerSsd, String computerGpu, String computerProcessor, LocalDateTime computerCreateDate, LocalDateTime computerUpdateDate, String desktopKeyboard) {
        super.create(computerScreen, computerBrand, computerName, computerPrice, computerReleaseDate, computerRam, computerSsd, computerGpu, computerProcessor, computerCreateDate, computerUpdateDate);
        this.desktopKeyboard = desktopKeyboard;
    }
}

