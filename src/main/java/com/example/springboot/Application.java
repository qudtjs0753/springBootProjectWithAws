package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @Author: kbs
 */


//이거 있어야 Auditing Annotation 활성화된다.!!!
@EnableJpaAuditing

//이 어노테이션으로 인해 스프링부트의 자동설정, 스피링 빈 읽기와
//생성을 모두 자동으로 설정함.
    //이때 SpringBootApplication이 있는 위치부터 설정을 읽으므로 반드시
    //이 클래스는 항상 프로젝트의 최상단에 위치해야한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //run을 통해서 내장된 WAS를 실행.
        SpringApplication.run(Application.class, args);
    }
}
