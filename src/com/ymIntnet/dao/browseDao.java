package com.ymIntnet.dao;

import com.ymIntnet.entity.Browse;

import java.util.List;

public interface browseDao {
    public List<Browse> findAll();
    public int browseInsert(Browse bb);
    public int deleteAll();
}
