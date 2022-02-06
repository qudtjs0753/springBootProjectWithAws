package com.example.springboot.config.auth;

import com.example.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: kbs
 */

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2USerService customOAuth2USerService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면 사용을 위해 해당 옵션들을 disable한다.
                .and()
                    .authorizeRequests() //URL별 권한 관리. 이거 써서 antMatchers 씀.
                    .antMatchers("/", "/css/**", "/images/**",
                        "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()//설정된 값 이외 나머지 url
                .and()
                    .logout()//로그아웃 기능에 대한 여러 설정의 진입점.
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()//OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당.
                    .userService(customOAuth2USerService); //소셜 로그인 성공 시 후속조치를 진행할 UserService 구현체 등록.
    }
}
