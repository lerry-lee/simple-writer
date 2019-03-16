package com.writer1.dao;

import java.io.IOException;

public interface VisitsDao {
    public boolean add(String sign) throws IOException;
    public int query() throws IOException;
}
