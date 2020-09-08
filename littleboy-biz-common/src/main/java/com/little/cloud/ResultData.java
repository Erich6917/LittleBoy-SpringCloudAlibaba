package com.little.cloud;

import lombok.Data;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-19
 */
@Data
public class ResultData<T> {

  /**
   * 结果状态 ,正常响应200，其他状态码都为失败
   */
  private int status;
  private String message;
  private T data;
  private boolean success;
  private long timestamp;


  public ResultData(String message, int status) {
    this.message = message;
    this.status = status;
  }

  public ResultData(T data) {
    this.data = data;
    this.status = 200;
    this.message = "SUCCESS";
  }

  public static <T> ResultData<T> success(T data) {
    return new ResultData<T>(data);
  }

  public static <T> ResultData error(String message) {
    return new ResultData<T>(message, 500);
  }

}
