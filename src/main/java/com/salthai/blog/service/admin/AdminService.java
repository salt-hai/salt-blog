package com.salthai.blog.service.admin;

import com.salthai.blog.mapper.AdminMapper;
import com.salthai.blog.pojo.Admin;
import com.salthai.blog.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @Author: salthai @Date: 2020/3/14 22:03 @Version 1.0 */
@Service
public class AdminService {
  @Autowired AdminMapper adminMapper;

  /**
   * 管理员登录
   *
   * @param username
   * @param password
   * @return
   */
  public Admin login(String username, String password) {
    String passwordMd5 = Md5Util.md5Encode(password, "UTF-8");
    return adminMapper.findAdmin(username, passwordMd5);
  }

  /**
   * 查询管理员信息
   *
   * @param
   * @return admin
   */
  public Admin findAdminAbout() {
    Admin admin = adminMapper.findAllAdmin();
    return admin;
  }

  /**
   * 更新管理员密码
   *
   * @param admin
   * @return boolean
   */
  public boolean updateAdminPassword(Admin admin) {
    return adminMapper.updateAdminPassword(admin);
  }

  /**
   * 更新管理员信息
   *
   * @param admin
   * @return boolean
   */
  public boolean updateAdminInfo(Admin admin) {
    return adminMapper.updateAdminInfo(admin);
  }
}
