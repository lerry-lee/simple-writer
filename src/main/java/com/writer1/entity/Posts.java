package com.writer1.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Posts {
    private int id;
    private String author;
    private String sdate;
    private String category;
    private String content;
    private String title;
    private int totalComments;

    public  Posts(){}

    public Posts(String author, String sdate, String category, String content, String title) {
        this.author = author;
        this.sdate = sdate;
        this.category = category;
        this.content = content;
        this.title = title;
    }
}
