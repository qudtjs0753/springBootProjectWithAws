package com.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: kbs
 */

//@Repository를 추가할 필요 없다.
    //Entity 클래스는 반드시 기본 Repository와 함께 움직여야 한다.
    //그래서 얘네는 규모가 커져 도메인을 나누는 경우에 같이다니는 놈들끼리 도메인 패키지에서 함께 관리.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
