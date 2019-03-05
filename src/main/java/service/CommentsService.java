package service;

import bean.CommentsBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import dao.impl.CommentsDaoImpl;
import entity.CommentsEntity;
import utils.ToJson;

import java.util.List;

public class CommentsService {
   public static boolean save(int sid,String comment,String cdate){
       CommentsEntity comments=new CommentsEntity(sid,comment,cdate);
       CommentsDaoImpl commentsDao=new CommentsDaoImpl();
       return commentsDao.save(comments);
   }
   public static String query(int sid) throws JsonProcessingException {
       CommentsDaoImpl commentsDao=new CommentsDaoImpl();
       List<CommentsBean> list=commentsDao.query(sid);
       return ToJson.toJson(list);
   }
}
