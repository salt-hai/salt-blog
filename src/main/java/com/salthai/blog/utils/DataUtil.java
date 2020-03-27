package com.salthai.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/** @Author: salthai @Date: 2020/3/27 16:57 @Version 1.0 */
public class DataUtil {
  /**
   * 获取当前系统时间
   *
   * @return data
   */
  public String getDate() {
    Date date = new Date();
    // 设置日期格式
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 强制类型转换
    String dataSystem = df.format(date);
    return dataSystem;
  }
}
