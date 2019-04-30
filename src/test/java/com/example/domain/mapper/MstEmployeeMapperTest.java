package com.example.domain.mapper;

import com.example.config.MyBatisConfig;
import com.example.config.ServiceConfig;
import com.example.config.TestDataSourceConfig;
import com.example.security.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {TestDataSourceConfig.class, MyBatisConfig.class, ServiceConfig.class})
@ActiveProfiles("unit")
class MstEmployeeMapperTest {

    @Autowired
    MstEmployeeMapper mapper;

    @Test
    public void test() {
        UserInfo user = mapper.selectUser("01");
    System.out.println(user);
    }
}