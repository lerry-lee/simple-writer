package com.writer1.service;

import com.writer1.dao.CommentsDaoImpl;
import com.writer1.entity.Comments;
import com.writer1.utils.ToJson;

import java.io.IOException;
import java.util.List;

public class CommentsService {
    Comments comments;
    CommentsDaoImpl commentsDao;

    public CommentsService() {
        commentsDao = new CommentsDaoImpl();
    }

    public int save(int sid, String comment, String cdate, String commentator) throws IOException {
        comments = new Comments(sid, comment, cdate, commentator);
        if (commentsDao.save(comments)) {
            if(new PostsService().addComments(sid))
            return 1;
        }
        return 0;
    }

    public String query(int sid) throws IOException {
        List<Comments> list = commentsDao.query(sid);
        return ToJson.toJson(list);
    }
}
