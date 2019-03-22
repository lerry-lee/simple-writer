package com.writer1.service.impl;

import com.writer1.entity.Comments;
import com.writer1.mapper.CommentsMapper;
import com.writer1.mapper.PostsMapper;
import com.writer1.service.CommentsService;
import com.writer1.utils.ToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    Comments comments;
    @Autowired
    CommentsMapper commentsMapper;
    @Autowired
    PostsMapper postsMapper;

    @Override
    public int save(int sid, String comment, String cdate, String commentator) {
        comments = new Comments(sid, comment, cdate, commentator);
        if (commentsMapper.add(comments) > 0) {
            if (postsMapper.addComments(sid) > 0)
                return 1;
        }
        return 0;
    }

    @Override
    public String query(int sid) throws IOException {
        List<Comments> list = commentsMapper.query(sid);
        return ToJson.toJson(list);
    }
}
