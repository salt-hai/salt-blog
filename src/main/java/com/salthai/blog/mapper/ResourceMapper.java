package com.salthai.blog.mapper;

import com.salthai.blog.pojo.Links;
import com.salthai.blog.pojo.Resource;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/2/1 22:06
 * @Version 1.0
 */
@Mapper
@Repository
public interface ResourceMapper {
    /**
     * 查询全部资源
     *
     * @param
     * @return list
     */
    @Select("select * from resource")
    public List<Resource> findAllResource();

    /**
     * 查询资源详细信息
     *
     * @param resourceId
     * @return links
     */
    @Select("select * from resource where resourceId= #{resourceId} ")
    public Links findByResourceId(int resourceId);

    /**
     * 添加一条链接
     *
     * @param resource
     * @return int
     */
    @Insert("insert into resource ( resourceName,resourcePath,resourceTime) " +
            "values (#{resourceName},#{resourcePath},#{resourceTime}) ")
    public int addResource(Resource resource);

    /**
     * 修改链接内容
     *
     * @param resource
     * @return int
     */
    @Update("update resource set resourceName=#{resourceName},resourcePath=#{resourcePath}," +
            "resourceTime=#{resourceTime}where resourceId=#{resourceId}")
    public int updateResource(Resource resource);

    /**
     * 删除一条链接
     *
     * @param resourceId
     * @return int
     */
    @Delete("delete from resource where resourceId= #{resourceId} ")
    public int deleteByResourceId(int resourceId);
}
