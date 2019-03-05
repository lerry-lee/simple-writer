package dao;

import bean.CommentsBean;
import entity.CommentsEntity;

import java.util.List;

public interface CommentsDao {
    public boolean save(CommentsEntity comments);
    public List<CommentsBean> query(int sid);
}
