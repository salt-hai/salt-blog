package com.salthai.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salthai.blog.pojo.Resource;
import com.salthai.blog.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/3/19 14:20
 * @Version 1.0
 */
@Controller
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    /**
     * 查看资源
     *
     * @param modelMap
     * @param start
     * @param size
     * @return String
     * @throws Exception
     */
    @RequestMapping("/resource/getAllResource")
    public String getAllResource(ModelMap modelMap,
                                 @RequestParam(value = "start", defaultValue = "0") int start,
                                 @RequestParam(value = "size", defaultValue = "5") int size)
            throws Exception {
        PageHelper.startPage(start, size);
        List<Resource> resourceList = resourceService.findAllResource();
        if (resourceList != null && !resourceList.isEmpty()) {
            PageInfo<Resource> resourcePageInfo = new PageInfo<>(resourceList);
            modelMap.addAttribute("resourcePageInfo", resourcePageInfo);
            System.out.println("------/resource/getAllResource--------有数据可执行");
            return "resource";
        } else {
            System.out.println("------/resource/getAllResource--------无数据");
            return "error";
        }

    }
}
