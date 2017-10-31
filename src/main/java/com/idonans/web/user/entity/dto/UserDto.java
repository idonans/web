package com.idonans.web.user.entity.dto;

import com.idonans.web.user.entity.bo.UserBo;
import org.springframework.beans.BeanUtils;

/**
 * 数据传输对象
 */
public class UserDto {

  public long id;
  public String username;
  public String nickname;
  public int sex;
  public long timeCreate;
  public long timeUpdate;

  public static UserDto valueOf(UserBo userBo) {
    if (userBo == null) {
      return null;
    }

    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(userBo, userDto);
    return userDto;
  }

  public UserBo toUserBo() {
    UserBo userBo = new UserBo();
    BeanUtils.copyProperties(this, userBo);
    return userBo;
  }
}
