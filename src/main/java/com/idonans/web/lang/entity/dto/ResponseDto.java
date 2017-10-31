package com.idonans.web.lang.entity.dto;

import com.idonans.web.lang.ErrorCode;
import com.idonans.web.lang.InternalException;

public class ResponseDto<T> {

  private int code;
  private String message;
  private T data;

  public void setWithDefaultMessage(int code) {
    this.code = code;
    this.message = ErrorCode.getDefaultMessage(code);
  }

  public void setWithInternalException(InternalException exception) {
    this.code = exception.getErrorCode();
    this.message = exception.getMessage();
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
