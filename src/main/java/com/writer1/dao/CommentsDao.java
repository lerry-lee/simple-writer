package com.writer1.dao;

import com.writer1.entity.Comments;

import java.io.IOException;
import java.util.List;

public interface CommentsDao {
    public boolean save(Comments comments) throws IOException;

    public List<Comments> query(int sid) throws IOException;
}
