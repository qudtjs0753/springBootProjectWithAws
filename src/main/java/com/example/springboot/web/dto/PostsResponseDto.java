package com.example.springboot.web.dto;

import com.example.springboot.domain.posts.Posts;
import lombok.Getter;

/**
 * @Author: kbs
 */

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    //Entity의 필드중 일부만 사용하므로 entity를 받아서 따로 쓴다.
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();

    }
}
