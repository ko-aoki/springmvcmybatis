package com.example.service;

import com.example.domain.mapper.MstRoleMapper;
import com.example.dto.RoleDto;
import com.example.entity.MstRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/** 権限機能を操作するサービスクラス. */
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired private MstRoleMapper mapper;

  /**
   * 権限名称に一致する権限を検索します.
   *
   * @param roleNm:権限名称
   * @return
   */
  @Override
  public List<RoleDto> findRole(String roleNm) {

    List<MstRole> msts = mapper.selectByRoleName(roleNm);

    return msts.stream()
        .map(
            mst -> {
              RoleDto dto = new RoleDto();
              dto.setRoleId(mst.getRoleId());
              dto.setRoleNm(mst.getRoleName());
              return dto;
            })
        .collect(Collectors.toList());
  }
}
