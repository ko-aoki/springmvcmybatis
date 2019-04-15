package com.example.service;

import com.example.domain.mapper.MstNewsMapper;
import com.example.domain.mapper.MstRoleMapper;
import com.example.dto.NewsDto;
import com.example.entity.MstNews;
import com.example.entity.MstRole;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** お知らせ情報を操作するサービスクラス. */
@Service
public class NewsServiceImpl implements NewsService {

  @Autowired
  private MstNewsMapper newsMapper;

  @Autowired
  private MstRoleMapper mstRoleMapper;

  @Override
  public Map<String, String> retrieveRoleIdMap() {

    List<MstRole> mstRoles = mstRoleMapper.selectAll();
    Map<String, String> roleIdMap = new HashMap<>();
    mstRoles.forEach(mstRole -> roleIdMap.put(mstRole.getRoleId(), mstRole.getRoleName()));

    return roleIdMap;
  }

//  /**
//   * 追加・更新するお知らせ情報を検証します.
//   *
//   * @param dto お知らせ情報
//   */
//  @Override
//  public void validateNews(NewsDto dto) {
//
//    SelectOptions selectOptions = SelectOptions.get().offset(0).limit(100).count();
//    // 表題の一致をチェック
//    dao.selectNewsDtoByCond(dto.getSubject(), null, null, selectOptions);
//    if (selectOptions.getCount() > 0) {
//      throw new BusinessException("同一の表題が存在します。");
//    }
//  }

  @Override
  public void addNews(NewsDto dto) {

//    this.validateNews(dto);

    MstNews trn = new MstNews();
    BeanUtils.copyProperties(dto, trn);

    newsMapper.insert(trn);
  }

  @Override
  public void modifyNews(NewsDto dto) {

//    this.validateNews(dto);

    MstNews mstNews = new MstNews();
    BeanUtils.copyProperties(dto, mstNews);
    mstNews.setMstNewsId(dto.getId());

    newsMapper.update(mstNews);
  }

  @Override
  public NewsDto findNews(Long id) {
    return newsMapper.selectOneNewsDto(id);
  }

//  @Override
//  public Page<NewsDto> findNewsPage(String subject, String roleId, String url, int pageNo) {
//
//    // ページあたり件数
//    // TODO パラメータ化
//    int sizePerPage = 5;
//    // offset指定、最大100件、カウントあり
//    int offset = pageNo * sizePerPage;
//    SelectOptions selectOptions = SelectOptions.get().offset(offset).limit(100).count();
//    // お知らせリスト取得
//    List<NewsDto> newsDtoList = dao.selectNewsDtoByCond(subject, roleId, url, selectOptions);
//    // 取得件数
//    long count = selectOptions.getCount();
//    // ページ内最終インデックス
//    int lastIdxInPage = sizePerPage > newsDtoList.size() ? newsDtoList.size() : sizePerPage;
//    // ページ情報作成
//    return new PageImpl<>(
//        newsDtoList.subList(0, lastIdxInPage), new PageRequest(pageNo, sizePerPage), count);
//  }
}
