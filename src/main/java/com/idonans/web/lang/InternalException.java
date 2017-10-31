package com.idonans.web.lang;

/**
 * 封装内部错误信息, 包含一个 errorCode 和 对应的 message
 */
public class InternalException extends Exception {

  private int errorCode;

  public InternalException(int errorCode) {
    this(errorCode, ErrorCode.getDefaultMessage(errorCode));
  }

  public InternalException(int errorCode, String message) {
    this(errorCode, message, null);
  }

  public InternalException(int errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return errorCode;
  }
}
