package com.example.springboot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest{

    @Test
    public void 롬복_기능_테스트() {
        //Given
        String name = "test";
        int amount = 1000;
        //When
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //Then
        //assertj라이브러리의 검증메소드들.
        //검증하고자 하는 대상을 인자로 받음.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}