package com.example.domain.mapper;

import com.example.dto.NewsDto;
import com.example.entity.MstNews;

import java.util.List;

/** お知らせマスタのDaoインターフェース. */
public interface MstNewsMapper {

  List<MstNews> selectAll();

//  List<NewsDto> selectNewsDtoByCond(
//          String subject, String roleId, String url, SelectOptions selectOptions);

  NewsDto selectOneNewsDto(Long id);

  int insert(MstNews trn);

  int update(MstNews trn);

  int delete(MstNews trn);
}
