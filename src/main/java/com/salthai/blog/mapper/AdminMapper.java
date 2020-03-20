package com.salthai.blog.mapper;

import com.salthai.blog.pojo.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/** @Author: salthai @Date: 2020/1/26 11:46 @Version 1.0 */
@Mapper
@Repository
public interface AdminMapper {
  /**
   * 查询管理员
   *
   * @return List
   */
  @Select("select * from admin")
  public Admin findAllAdmin();

  /**
   * 查询用户（登录用）
   *
   * @param username
   * @param password
   * @return
   */
  @Select("select * from admin where username= #{username} && password=#{password} ")
  public Admin findAdmin(String username, String password);

  /**
   * 添加管理员
   *
   * @param admin
   * @return int
   */
  @Insert(
      " insert into admin ( username,nickName,password,adminAddress,adminAbout) values (#{username},#{nickName},#{password},"
          + "#{adminAddress},#{adminAbout}) ")
  public int addAdmin(Admin admin);

  /**
   * 根据Id删除
   *
   * @param adminId
   * @return void
   */
  @Delete(" delete from admin where adminId= #{adminId} ")
  public void deleteByAdminId(int adminId);

  /**
   * 查询管理员信息
   *
   * @param adminId
   * @return Admin
   */
  @Select("select * from admin where adminId= #{adminId} ")
  public Admin findByAdminId(int adminId);

  /**
   * 更新管理员密码
   *
   * @param admin
   * @return int
   */
  @Update("update admin set password=#{password} where adminId=#{adminId} ")
  public int updateAdminPassword(Admin admin);

  /**
   * 更新管理员信息
   *
   * @param admin
   * @return int
   */
  @Update(
      "update admin set username=#{username},nickName=#{nickName},adminAddress=#{adminAddress},adminAbout=#{adminAbout} where adminId=#{adminId}")
  public int updateAdminInfo(Admin admin);
}
