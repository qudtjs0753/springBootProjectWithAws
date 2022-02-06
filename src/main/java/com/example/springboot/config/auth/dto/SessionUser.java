package com.example.springboot.config.auth.dto;

import com.example.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Author: kbs
 */

//굳이 session user를 또 만든 이유
    //serialize를 안하면 오류가 생김
    //근데 User class에 직렬화를 하면?
    //User 클래스는 엔티티이므로 다른 엔티티와 언제 관계가 생길지 모름
    //1대n, n대m 등 자식 entity가 있는 관계의 경우 자식까지 직렬화해야되므로 성능이슈 생김.
    //따라서 직렬화 기능을 가진 세션 Dto를 따로 만드는 것이 좋다.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.email = user.getEmail();
        this.name = user.getName();
        this.picture = user.getPicture();
    }
}
