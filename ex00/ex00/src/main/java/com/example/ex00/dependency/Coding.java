package com.example.ex00.dependency;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component/*일반 객체에 @Componenct 붙이면 스프링이 관리해줌*/
//@Data/*기본 생성자, 초기화 생성자, getter, setter, toString*/
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Coding {
    
    /*필드 주입
    * 굉장히 편하게 주입할 수 있으나 순환 참조시 오류가 발생하지 않기 떄문에 StackOverFlow 발생
    * final을 붙일 수 없기 때문에 다른 곳에서 변형 가능
    * 단위 테스트에서는 반드시 필드 주입을 하자*/
    //@Autowired
    //->위 같은 문제가 생기기떄문에 생성자 주입을 해야한다
    //의존 관계가 있는 애들만 final 붙여줌
    //id나 pw 와 같이 사용자에게 입력받는 것에는 final 안붙임
    private final Computer computer;
//  생성자 주입 -> 해당 필드에 final을 붙일 수 있게됨
//  순환참조 시 컴파일러 인지 가능, stackoverflow 이전에 오류 발생
//  메모리에 할당되면서 초기값으로 주입되므로 final 키워드 사용 가능, 다른 곳에서 변형 불가능 
//  의존성 주입이 되지 않으면 객체가 생성되지 않으므로 NPE 방어
//  생성자에 @Autowired 생략 가능    
////    @Autowired 생략 가능
//    public Coding(Computer computer){
//        this.computer = computer;
//    }    
}
