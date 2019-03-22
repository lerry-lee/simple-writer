package com.writer1.mapper;

import com.writer1.entity.Comments;

import java.util.List;

public interface CommentsMapper {
    public int add(Comments comments);

    public List<Comments> query(int sid);
}
