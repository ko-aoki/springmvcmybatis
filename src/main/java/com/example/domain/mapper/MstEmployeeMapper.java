package com.example.domain.mapper;

import com.example.entity.MstEmployee;
import com.example.security.UserInfo;

import java.util.List;

public interface MstEmployeeMapper {

    List<MstEmployee> selectAll();

    UserInfo selectUser(String id);

    void create(MstEmployee mstEmployee);

}
