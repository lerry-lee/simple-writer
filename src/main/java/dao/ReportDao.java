package dao;

public interface ReportDao {
    public boolean save(String username,String content);
    public String query(String username);
}
