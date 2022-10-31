package com.example.ex00.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vips")
public class Vips implements Restaurant{

    @Override
    public boolean UseSelfbar(){
        return true;
    };
    public int getSteakPrice(){
        return steakPrice+10000;
    };
}
