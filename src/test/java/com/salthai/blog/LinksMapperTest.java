package com.salthai.blog;

import com.salthai.blog.mapper.LinksMapper;
import com.salthai.blog.pojo.Links;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

/** @Author: salthai @Date: 2020/2/16 12:12 @Version 1.0 */
@SpringBootTest
public class LinksMapperTest {
  @Autowired LinksMapper linksMapper;

  public void findAllLinks() {
    List<Links> linksList = linksMapper.findAllLinks();
    System.out.println(linksList);
  }

  public void addLinks() {
    Links links = new Links();
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String linksTime = dateFormat.format(date);
    links.setLinksTitle("淘宝");
    links.setLinksTime(linksTime);
    links.setLinksHref("www.taobao.com");
    linksMapper.addLinks(links);
    System.out.println("success");
  }

  public void findByLinksId() {
    Links links = linksMapper.findByLinksId(1);
    System.out.println(links);
  }

  public void updateLinks() {
    Links links = new Links();
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String linksTime = dateFormat.format(date);
    links.setLinksTitle("天猫");
    links.setLinksHref("www.tianmao.com");
    links.setLinksTime(linksTime);
    links.setLinksId(1);
    linksMapper.updateLinks(links);
    System.out.println("Success");
  }

  public void deleteByLinksId() {
    linksMapper.deleteByLinksId(2);
    System.out.println("Success");
  }
}
