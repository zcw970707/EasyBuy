package com.ymIntnet.service;

import com.ymIntnet.entity.Browse;

import java.util.List;

public interface browseService {
    public List<Browse> findAll();
    public int browseInsert(Browse bb);
    public int deleteAll();
}
