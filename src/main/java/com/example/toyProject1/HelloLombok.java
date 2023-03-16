package com.example.toyProject1;

import lombok.Getter;
//import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
//@Setter
@RequiredArgsConstructor
public class HelloLombok {
    private final String hello;
    private final int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok =  new HelloLombok("hello", 10);
        //helloLombok.setHello("hello");
        //helloLombok.setLombok(10);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());

    }
}
