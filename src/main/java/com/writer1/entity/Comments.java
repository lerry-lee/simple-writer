package com.writer1.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comments {
    private int id;
    private int sid;
    private String comment;
    private String cdate;
    private String commentator;

    public Comments() {
    }

    public Comments(int sid, String comment, String cdate, String commentator) {
        this.sid = sid;
        this.comment = comment;
        this.cdate = cdate;
        this.commentator = commentator;
    }
}
