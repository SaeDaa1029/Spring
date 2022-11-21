package com.example.advanced.repository;

import com.example.advanced.entity.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRegistrationRepository extends JpaRepository<CarOwner, Long> {

}
