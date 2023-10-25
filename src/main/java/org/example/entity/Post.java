package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Post {
    private int postId;
    private String title;
    private String content;
    private String userId;

}
