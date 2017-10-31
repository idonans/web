package com.idonans.web.user.service;

import com.idonans.web.lang.ErrorCode;
import com.idonans.web.lang.InternalException;
import com.idonans.web.user.entity.bo.UserBo;
import com.idonans.web.user.entity.po.UserPo;
import com.idonans.web.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public UserBo findOneById(long id) throws InternalException {
    UserBo target = UserBo.valueOf(userMapper.findOneById(id));
    if (target == null) {
      throw new InternalException(ErrorCode.CODE_NOT_FOUND, "user not found with id " + id);
    }
    return target;
  }

  public UserBo insertOne(UserBo inputOriginal) throws InternalException {
    if (inputOriginal == null) {
      throw new InternalException(ErrorCode.CODE_PARAM_ERROR, "input original is null");
    }

    UserPo input = inputOriginal.toUserPo();
    if (input == null) {
      throw new InternalException(ErrorCode.CODE_PARAM_ERROR, "input is null");
    }

    long timeNow = System.currentTimeMillis();
    input.setTimeCreate(timeNow);
    input.setTimeUpdate(timeNow);

    int rows = userMapper.insertOne(input);
    if (rows != 1) {
      throw new InternalException(ErrorCode.CODE_INSERT_FAIL,
          "user insert fail, rows return " + rows);
    }

    return findOneById(input.getId());
  }
}
