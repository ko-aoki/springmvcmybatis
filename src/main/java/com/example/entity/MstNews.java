package com.example.entity;

/** お知らせマスタエンティティ. */
public class MstNews extends AuditEntity {

  private Long mstNewsId;

  private String roleId;
  private String subject;
  private String url;

  public Long getMstNewsId() {
    return mstNewsId;
  }

  public void setMstNewsId(Long mstNewsId) {
    this.mstNewsId = mstNewsId;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
