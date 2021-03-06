package com.salthai.blog.controller;

import com.salthai.blog.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Author: salthai
 * @Date: 2020/3/19 22:31
 * @Version 1.0
 */
@Controller
public class DownloadFileController {
  @Autowired
  ResourceService resourceService;

  /**
   * 资源下载
   *
   * @param resourceId          资源Id
   * @param httpServletResponse
   * @return String
   * @throws Exception
   */
  @RequestMapping("/downloadResource/{resourceId}")
  @ResponseBody
  public String downloadFile(@PathVariable int resourceId, HttpServletResponse httpServletResponse)
          throws Exception {
    //        根据资源Id查找详细信息，资源名称，资源目录，用于下载
    String resourceName = resourceService.findByResourceId(resourceId).getResourceName();
    String resourcePath = resourceService.findByResourceId(resourceId).getResourcePath();
    System.out.println(resourceName);
    System.out.println(resourcePath);
    File file = new File(resourcePath);
    //        文件路径是否存在
    if (file.exists()) {
      // 设置强制下载打开
      httpServletResponse.setContentType("application/octet-stream");
      httpServletResponse.setHeader("content-type", "application/octet-stream");
      httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(resourceName, "UTF-8"));
      byte[] buffer = new byte[1024];
      FileInputStream fileInputStream = null;
      BufferedInputStream bufferedInputStream = null;
      try {
        System.out.println("-----启动下载------");
        fileInputStream = new FileInputStream(file);
        bufferedInputStream = new BufferedInputStream(fileInputStream);
        OutputStream outputStream = httpServletResponse.getOutputStream();
        int i = bufferedInputStream.read(buffer);
        while (i != -1) {
          outputStream.write(buffer, 0, i);
          i = bufferedInputStream.read(buffer);
        }
        System.out.println("成功下载");
        return "success";
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        if (bufferedInputStream != null) {
          try {
            bufferedInputStream.close();

          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
      if (fileInputStream != null) {
        try {
          fileInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println("-----失败------");
    return "下载失败";
  }
}
