package dao;

import entity.ReportEntity;

public interface ReportDao {
    public boolean save(ReportEntity report);
    public String query(String username);
}
