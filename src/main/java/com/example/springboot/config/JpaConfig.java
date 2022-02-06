package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @Author: kbs
 */


//application에 있던거 분리시킨 이유
    //@SpringBootApplication하고 함께 있으면 @WebMvcTest에서도 @EnableJpaAuditing을 스캔함
    //이건 문제가 무조건 Entity클래스 하나이상 필요해서 Entity 필요 없는 테스트의 경우 문제 발생.
    //그래서 따로 분리시킴.
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
