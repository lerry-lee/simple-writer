package com.writer1.service.impl;

import com.writer1.mapper.VisitsMapper;
import com.writer1.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitsServiceImpl implements VisitsService {
    @Autowired
    private VisitsMapper visitsMapper;

    @Override
    public int add(String username, String vdate) {
        String sign = username + vdate;
        if (visitsMapper.add(sign) > 0) return 1;
        return 0;
    }

    @Override
    public int queryTotal() {
        return visitsMapper.query();
    }
}
