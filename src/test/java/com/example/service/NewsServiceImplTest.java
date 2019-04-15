package com.example.service;

import com.example.config.MyBatisConfig;
import com.example.config.ServiceConfig;
import com.example.config.TestDataSourceConfig;
import com.example.dto.NewsDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes = {TestDataSourceConfig.class, MyBatisConfig.class, ServiceConfig.class})
@ActiveProfiles("unit")
class NewsServiceImplTest {

    @Autowired
    NewsService service;

    @Test
    @DisplayName("findNews()でお知らせが取得できる")
    public void findNewsTest() {

        NewsDto news = this.service.findNews(1l);

        assertEquals(Long.valueOf(1L), news.getId());
        assertEquals("表題テスト1", news.getSubject());
    }

}