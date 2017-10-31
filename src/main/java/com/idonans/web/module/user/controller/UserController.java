package com.idonans.web.module.user.controller;

import com.idonans.web.lang.ErrorCode;
import com.idonans.web.lang.InternalException;
import com.idonans.web.lang.entity.dto.ResponseDto;
import com.idonans.web.module.user.entity.bo.UserBo;
import com.idonans.web.module.user.entity.dto.UserDto;
import com.idonans.web.module.user.service.UserService;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseDto<UserDto> getById(@PathVariable long id, HttpSession session) {
    String logPrefix = "[getById session:" + session.getId() + ", id:" + id + "]";
    logger.info(logPrefix);
    ResponseDto<UserDto> responseDto = new ResponseDto<>();
    try {
      UserDto data = UserDto.valueOf(userService.findOneById(id));
      if (data == null) {
        throw new InternalException(ErrorCode.CODE_NOT_FOUND, "data of user is null with id " + id);
      }

      responseDto.setData(data);
      responseDto.setWithDefaultMessage(ErrorCode.CODE_OK);
    } catch (InternalException e) {
      logger.error(logPrefix, e);
      e.printStackTrace();
      responseDto.setWithInternalException(e);
    } catch (Throwable e) {
      logger.error(logPrefix, e);
      responseDto.setWithDefaultMessage(ErrorCode.CODE_ERROR);
    }

    return responseDto;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ResponseDto<UserDto> createOne(@RequestBody UserDto inputOriginal, HttpSession session) {
    String logPrefix =
        "[createOne session:" + session.getId() + ", inputOriginal:" + inputOriginal + "]";
    logger.info(logPrefix);
    ResponseDto<UserDto> responseDto = new ResponseDto<>();
    try {
      UserBo input = null;
      if (inputOriginal != null) {
        input = inputOriginal.toUserBo();
      }

      UserDto data = UserDto.valueOf(userService.insertOne(input));
      if (data == null) {
        throw new InternalException(ErrorCode.CODE_INSERT_FAIL, "data of user is null");
      }

      responseDto.setData(data);
      responseDto.setWithDefaultMessage(ErrorCode.CODE_OK);
    } catch (InternalException e) {
      logger.error(logPrefix, e);
      responseDto.setWithInternalException(e);
    } catch (Throwable e) {
      logger.error(logPrefix, e);
      responseDto.setWithDefaultMessage(ErrorCode.CODE_ERROR);
    }

    return responseDto;
  }
}
