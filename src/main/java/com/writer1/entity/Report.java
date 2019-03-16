package com.writer1.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Report {
    private int id;
    private String username;
    private String content;

    public Report() {
    }

    public Report(String username, String report) {
        this.username = username;
        this.content = report;
    }
}
