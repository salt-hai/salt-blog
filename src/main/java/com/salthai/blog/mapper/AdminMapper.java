package com.salthai.blog.mapper;

import com.salthai.blog.pojo.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/1/26 11:46
 * @Version 1.0
 */
@Mapper
@Repository
public interface AdminMapper {
    /**
     * @return List
     * 查询管理员
     */
    @Select("select * from admin")
    public List<Admin> findAllAdmin();

    /**
     * @return int
     * 插入管理员信息
     */
    @Insert(" insert into admin ( username,password,adminAddress,adminAbout) values (#{username},#{password}," +
            "#{adminAddress},#{adminAbout}) ")
    public int saveAdmin(Admin admin);

    /**
     * @return int
     * 根据id进行删除
     */
    @Delete(" delete from admin where id= #{adminId} ")
    public void deleteById(int id);

    /**
     * @return Admin
     * 根据id查找
     */
    @Select("select * from admin where id= #{adminId} ")
    public Admin findById(int id);

    /**
     * @return int
     * 更新管理员密码
     */
    @Update("update admin set password=#{password} where id=#{adminId} ")
    public int updateAdminPassword(Admin admin);

    /**
     * @param admin
     * @return int
     * 更新管理员信息
     */
    @Update("update admin set username=#{username},adminAddress=#{adminAddress},adminAbout=#{adminAbout}" +
            " where id=#{adminId} ")
    public int updateAdminInfo(Admin admin);
}
