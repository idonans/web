package com.idonans.web.user;

import com.idonans.web.lang.ErrorCode;
import com.idonans.web.lang.InternalException;
import com.idonans.web.lang.entity.dto.ResponseDto;
import com.idonans.web.user.entity.bo.UserBo;
import com.idonans.web.user.entity.dto.UserDto;
import com.idonans.web.user.service.UserService;
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

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseDto<UserDto> getById(@PathVariable long id) {
    ResponseDto<UserDto> responseDto = new ResponseDto<>();
    try {
      responseDto.data = UserDto.valueOf(userService.findOneById(id));
      if (responseDto.data == null) {
        throw new InternalException(ErrorCode.CODE_NOT_FOUND, "user not found with id " + id);
      }

      responseDto.setWithDefaultMessage(ErrorCode.CODE_OK);
    } catch (InternalException e) {
      e.printStackTrace();
      responseDto.setWithInternalException(e);
    } catch (Throwable e) {
      e.printStackTrace();
      responseDto.setWithDefaultMessage(ErrorCode.CODE_ERROR);
    }

    return responseDto;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ResponseDto<UserDto> createOne(@RequestBody UserDto inputOriginal) {
    ResponseDto<UserDto> responseDto = new ResponseDto<>();
    try {
      UserBo input = null;
      if (inputOriginal != null) {
        input = inputOriginal.toUserBo();
      }
      responseDto.data = UserDto.valueOf(userService.insertOne(input));
      if (responseDto.data == null) {
        throw new InternalException(ErrorCode.CODE_INSERT_FAIL, "data of user is null");
      }

      responseDto.setWithDefaultMessage(ErrorCode.CODE_OK);
    } catch (InternalException e) {
      e.printStackTrace();
      responseDto.setWithInternalException(e);
    } catch (Throwable e) {
      e.printStackTrace();
      responseDto.setWithDefaultMessage(ErrorCode.CODE_ERROR);
    }

    return responseDto;
  }
}
