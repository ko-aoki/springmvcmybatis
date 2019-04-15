package com.example.service;

import com.example.entity.MstEmployee;

import java.util.List;

public interface CustomerService {

    List<MstEmployee> selectAll();

    void create(MstEmployee mstEmployee);
}
