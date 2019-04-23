package com.example.domain.mapper;

import com.example.dto.NewsDto;
import com.example.entity.MstNews;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/** お知らせマスタのDaoインターフェース. */
public interface MstNewsMapper {

  List<MstNews> selectAll();

  int countByCond(
          @Param("subject")String subject, @Param("roleId")String roleId, @Param("url")String url);

  List<NewsDto> selectNewsDtoByCond(
          @Param("subject")String subject, @Param("roleId")String roleId, @Param("url")String url, @Param("pageable")Pageable pageable);

  NewsDto selectOneNewsDto(Long id);

  int insert(MstNews trn);

  int update(MstNews trn);

  int delete(MstNews trn);
}
