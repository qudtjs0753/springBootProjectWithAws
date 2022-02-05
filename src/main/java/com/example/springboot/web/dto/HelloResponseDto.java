package com.example.springboot.web.dto;

/**
 * @Author: kbs
 */
public class HelloResponseDto {

    private final String name;
    private final int amount;


    public HelloResponseDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }
}
