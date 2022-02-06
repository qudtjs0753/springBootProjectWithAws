package com.example.springboot.domain.posts;

import com.example.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: kbs
 */

//꿀팁. 중요한 어노테이션일수록 클래스에 가깝게 둬라.
    //예를들어 lombok은 코틀린으로 전환하거나 하면 필요 없으니까 삭제하면 됨.
    //하지만 entity는 그대로 필요하므로 제일 클래스 가까이에 둔다.
    //entity 클래스에는 절대로 setter를 두지 않는다!
    //해당 값의 변경이 필요하면 그 목적과 의도가 명확히 나타난 메소드를 추가해야함.
    //Builder로 넣는 경우가 많음.
@Getter
@NoArgsConstructor
@Entity //기본적으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭해줌.
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false) //굳이 선언 안해도 컬럼으로 인식은 함. 추가적 설정이 필요한 경우에만 사용.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
