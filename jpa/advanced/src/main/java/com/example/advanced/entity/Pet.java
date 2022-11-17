package com.example.advanced.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PET")
@Getter @Setter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pet extends Period{
    @Id @GeneratedValue
    private Long petId;
    private String petName;
    private String petGender;
    private String petDisease;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;
}
