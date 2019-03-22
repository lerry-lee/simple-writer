package com.writer1.service;

import java.io.IOException;

public interface CommentsService {
    public int save(int sid, String comment, String cdate, String commentator);

    public String query(int sid) throws IOException;
}
