package com.example.ex00.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("outback") @Primary
public class Outback implements Restaurant{
    @Override
    public boolean UseSelfbar(){
        return false;
    };
    public int getSteakPrice() {
        return steakPrice+12000;
    };
}
