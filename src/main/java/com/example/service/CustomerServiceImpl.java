package com.example.service;

import com.example.domain.mapper.MstEmployeeMapper;
import com.example.entity.MstEmployee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final MstEmployeeMapper mapper;

    public CustomerServiceImpl(MstEmployeeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<MstEmployee> selectAll() {
        return mapper.selectAll();
    }

    @Transactional
    @Override
    public void create(MstEmployee mstEmployee) {
        mapper.create(mstEmployee);
    System.out.println("--------- create service ---------");
    }
}
