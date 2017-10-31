package com.idonans.web.lang;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {

  private static final Map<Integer, String> DEFAULT_MESSAGES = new HashMap<>();

  /**
   * 正常
   */
  public static final int CODE_OK = 0;

  static {
    DEFAULT_MESSAGES.put(CODE_OK, "ok");
  }

  /**
   * 没有找到
   */
  public static final int CODE_NOT_FOUND = 1000;

  static {
    DEFAULT_MESSAGES.put(CODE_NOT_FOUND, "not found");
  }

  /**
   * 参数错误
   */
  public static final int CODE_PARAM_ERROR = 1001;

  static {
    DEFAULT_MESSAGES.put(CODE_PARAM_ERROR, "param error");
  }

  /**
   * 数据插入失败
   */
  public static final int CODE_INSERT_FAIL = 1002;

  static {
    DEFAULT_MESSAGES.put(CODE_INSERT_FAIL, "insert fail");
  }

  /**
   * 其它未知错误
   */
  public static final int CODE_ERROR = 5000;

  static {
    DEFAULT_MESSAGES.put(CODE_ERROR, "error");
  }

  public static String getDefaultMessage(int errorCode) {
    return DEFAULT_MESSAGES.getOrDefault(errorCode, "unknown");
  }
}
