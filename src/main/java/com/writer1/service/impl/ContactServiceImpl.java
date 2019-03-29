package com.writer1.service.impl;

import com.writer1.entity.Contact;
import com.writer1.mapper.ContactMapper;
import com.writer1.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    Contact contact;
    @Autowired
    ContactMapper contactMapper;

    @Override
    public int save(Contact c) {
        contact = c;
        if (contactMapper.add(contact) > 0) return 1;
        return 0;
    }
}
