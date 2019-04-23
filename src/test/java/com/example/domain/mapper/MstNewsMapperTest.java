package com.example.domain.mapper;

import com.example.config.MyBatisConfig;
import com.example.config.ServiceConfig;
import com.example.config.TestDataSourceConfig;
import com.example.dto.NewsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {TestDataSourceConfig.class, MyBatisConfig.class, ServiceConfig.class})
@ActiveProfiles("unit")
class MstNewsMapperTest {

  @Autowired
  MstNewsMapper mapper;

  @Test
  void selectNewsDtoByCond() {

    Pageable page = PageRequest.of(1, 2);

    List<NewsDto> list = mapper.selectNewsDtoByCond("テスト表題", "ROLE_USER", null, page);

    assertEquals(2, list.size());

  }
}