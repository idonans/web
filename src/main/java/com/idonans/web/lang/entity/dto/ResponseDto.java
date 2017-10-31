package com.idonans.web.lang.entity.dto;

import com.idonans.web.lang.ErrorCode;
import com.idonans.web.lang.InternalException;

public class ResponseDto<T> {

  public int code;
  public String message;
  public T data;

  public void setWithDefaultMessage(int code) {
    this.code = code;
    this.message = ErrorCode.getDefaultMessage(code);
  }

  public void setWithInternalException(InternalException exception) {
    this.code = exception.getErrorCode();
    this.message = exception.getMessage();
  }
}
