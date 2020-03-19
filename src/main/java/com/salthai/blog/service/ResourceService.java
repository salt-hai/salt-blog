package com.salthai.blog.service;

import com.salthai.blog.mapper.ResourceMapper;
import com.salthai.blog.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/3/19 14:15
 * @Version 1.0
 */
@Service
public class ResourceService {
    @Autowired
    ResourceMapper resourceMapper;

    /**
     * 资源列表
     *
     * @return list
     */
    public List<Resource> findAllResource() {
        List<Resource> resourceList = resourceMapper.findAllResource();
        return resourceList;
    }

    /**
     * 资源详细信息
     *
     * @param resourceId
     * @return object
     */
    public Resource findByResourceId(int resourceId) {
        Resource resource = resourceMapper.findByResourceId(resourceId);
        return resource;
    }
}
