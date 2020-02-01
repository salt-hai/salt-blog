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
     * 查询管理员
     *
     * @return List
     */
    @Select("select * from admin")
    public List<Admin> findAllAdmin();

    /**
     * 插入管理员信息
     *
     * @param admin
     * @return int
     */
    @Insert(" insert into admin ( username,password,adminAddress,adminAbout) values (#{username},#{password}," +
            "#{adminAddress},#{adminAbout}) ")
    public int saveAdmin(Admin admin);

    /**
     * 根据Id删除
     *
     * @param id
     * @return int
     */
    @Delete(" delete from admin where id= #{adminId} ")
    public void deleteById(int id);

    /**
     * 更新管理员信息
     *
     * @param id
     * @return Admin
     */
    @Select("select * from admin where id= #{adminId} ")
    public Admin findById(int id);

    /**
     * 更新管理员密码
     *
     * @param admin
     * @return int
     */
    @Update("update admin set password=#{password} where id=#{adminId} ")
    public int updateAdminPassword(Admin admin);

    /**
     * 更新管理员信息
     *
     * @param admin
     * @return int
     */
    @Update("update admin set username=#{username},adminAddress=#{adminAddress},adminAbout=#{adminAbout}" +
            " where id=#{adminId} ")
    public int updateAdminInfo(Admin admin);
}
