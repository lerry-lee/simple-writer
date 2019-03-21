package com.writer1.service;

import com.writer1.dao.ContactDaoImpl;
import com.writer1.entity.Contact;

import java.io.IOException;

public class ContactService {
    Contact contact;
    ContactDaoImpl contactDao;
    public ContactService(){
        contactDao=new ContactDaoImpl();
    }
    public int save(String username,String name,String email,String comments) throws IOException {
        contact=new Contact(username,name,email,comments);
        if(contactDao.save(contact)) return 1;
        return 0;
    }
}
