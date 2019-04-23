package com.example.service;

import com.example.dto.NewsDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/** お知らせ情報を操作するサービスインターフェース. */
public interface NewsService {

  /**
   * 権限リストを取得します.
   *
   * @return
   */
  Map<String, String> retrieveRoleIdMap();

//  /**
//   * 追加・更新するお知らせ情報を検証します.
//   *
//   * @param dto お知らせ情報
//   */
//  void validateNews(NewsDto dto);

  /**
   * お知らせ情報を追加します.
   *
   * @param dto お知らせ情報
   */
  @Transactional
  void addNews(NewsDto dto);

  /**
   * お知らせ情報を修正します.
   *
   * @param dto お知らせ情報
   */
  @Transactional
  void modifyNews(NewsDto dto);

  /**
   * お知らせ情報を検索します.
   *
   * @param id:お知らせ情報ID
   * @return お知らせ情報
   */
  NewsDto findNews(Long id);

  /**
   * お知らせ情報の件数を取得します.
   *
   * @param subject:表題
   * @param roleId:権限ID
   * @param url:URL
   * @return お知らせ情報件数
   */
  long countNews(String subject, String roleId, String url);

  /**
   * お知らせ情報リストを検索します.
   *
   * @param subject:表題
   * @param roleId:権限ID
   * @param url:URL
   * @param pageNo:検索ページ
   * @return お知らせ情報ページ情報
   */
  List<NewsDto> findNewsPage(String subject, String roleId, String url, int pageNo);
}
