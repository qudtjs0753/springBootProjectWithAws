package com.example.springboot.web;

import static org.hamcrest.Matchers.is;

import com.example.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자 실행.
//여기서는 SpringRunner라는 스프링 실행자 사용.
@RunWith(SpringRunner.class)

//여러 스프링 어노테이션 중 Web에 집중할 수 있는 어노테이션
//이거 쓰면 @Service, @Component, @Repository등은 쓸 수 없다.
//@Controller, @ControllerAdvice등 사용 가능.
@WebMvcTest(controllers = HelloController.class,//@repository, @Service, @Component는 스캔대상 아니므로
            excludeFilters = {//securityconfig 읽어도 이 안에서 사용하는 애들 못읽어서 얘 그냥 제외함.
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = SecurityConfig.class)
            })
public class HelloControllerTest {

    @Autowired
    //스프링 MVC test 시작점.
    //이 MockMvc 클래스를 통해 API 테스트가 가능해진다.
    private MockMvc mvc;

    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                 .andExpect(status().isOk())//결과 검증(200인지 체크)
                .andExpect(content().string(hello));//컨텐츠가 string hello반환하는지 체크.
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount))
                );

    }
}