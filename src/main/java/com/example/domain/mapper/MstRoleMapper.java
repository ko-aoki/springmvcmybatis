package com.example.domain.mapper;

import com.example.entity.MstRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** 権限マスタのDaoインターフェース. */
public interface MstRoleMapper {

  List<MstRole> selectAll();

  List<MstRole> selectByRoleName(String roleName);

  @Transactional
  int insert(MstRole ent);
}
