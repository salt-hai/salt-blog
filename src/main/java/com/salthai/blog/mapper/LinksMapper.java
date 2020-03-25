package com.salthai.blog.mapper;

import com.salthai.blog.pojo.Links;
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
public interface LinksMapper {
    /**
     * 查询全部链接
     *
     * @param
     * @return list
     */
    @Select("select * from links")
    public List<Links> findAllLinks();

    /**
     * 查询链接详细信息
     *
     * @param linksId
     * @return links
     */
    @Select("select * from links where linksId= #{linksId} ")
    public Links findByLinksId(int linksId);

    /**
     * 添加一条链接
     *
     * @param links
     * @return int
     */
    @Insert("insert into links ( linksTitle,linksHref,linksTime) values (#{linksTitle},#{linksHref},#{linksTime}) ")
    public int addLinks(Links links);

    /**
     * 修改链接内容
     *
     * @param links
     * @return int
     */
    @Update("update links set linksTitle=#{linksTitle},linksHref=#{linksHref},linksTime=#{linksTime}" +
            "where linksId=#{linksId}")
    public int updateLinks(Links links);

    /**
     * 删除一条链接
     *
     * @param linksId
     * @return int
     */
    @Delete("delete from links where linksId= #{linksId} ")
    public boolean deleteByLinksId(int linksId);
}
