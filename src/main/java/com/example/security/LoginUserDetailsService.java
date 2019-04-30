package com.example.security;

import com.example.domain.mapper.MstEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** Spring Securityで使用するログイン時に取得するユーザ情報サービスクラス. */
@Service
public class LoginUserDetailsService implements UserDetailsService {
  @Autowired
  private MstEmployeeMapper mapper;

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

    UserInfo user = mapper.selectUser(id);
    if (user == null) {
      throw new UsernameNotFoundException("ユーザID:" + id + "は存在しません");
    }

    UserInfo userInfo = new UserInfo();

    userInfo.setId(user.getId());
    userInfo.setEmployeeFirstName(user.getEmployeeFirstName());
    userInfo.setEmployeeLastName(user.getEmployeeLastName());
    userInfo.setRoleId(user.getRoleId());
    userInfo.setPassword(user.getPassword());

    return new LoginUserDetails(userInfo);
  }
}
