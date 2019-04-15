package com.example.domain.mapper;

import com.example.entity.MstEmployee;

import java.util.List;

public interface MstEmployeeMapper {

    List<MstEmployee> selectAll();

    MstEmployee selectUser(String id);

    void create(MstEmployee mstEmployee);

}
