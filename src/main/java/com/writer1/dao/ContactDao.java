package com.writer1.dao;

import com.writer1.entity.Contact;

import java.io.IOException;

public interface ContactDao {
    public boolean save(Contact contact) throws IOException;
}
