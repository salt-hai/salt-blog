package com.salthai.blog.utils;

/**
 * Json工具类，可自定义返回信息
 *
 * @Author: salthai
 * @Date: 2020/3/17 12:52
 * @Version 1.0
 */
public class JsonResult<T> {
  private T data;
  private String code;
  private String msg;

  /**
   * 若没有数据返回，默认状态码为 0，提示信息为“操作失败”
   */
  public JsonResult() {
    this.code = "0";
    this.msg = "操作成功！";
  }

  /**
   * 若没有数据返回，可以人为指定状态码和提示信息
   *
   * @param code
   * @param msg
   */
  public JsonResult(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  /**
   * 有数据返回时，状态码为 1，默认提示信息为“操作成功！”
   *
   * @param data
   */
  public JsonResult(T data) {
    this.data = data;
    this.code = "1";
    this.msg = "操作成功！";
  }

  /**
   * 有数据返回，状态码为 1，人为指定提示信息
   *
   * @param data
   * @param msg
   */
  public JsonResult(T data, String msg) {
    this.data = data;
    this.code = "1";
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "JsonResult{" + "data=" + data + ", code='" + code + '\'' + ", msg='" + msg + '\'' + '}';
  }
}
