package com.idonans.web.user.entity.bo;

import com.idonans.web.user.entity.po.UserPo;
import org.springframework.beans.BeanUtils;

/**
 * 业务对象
 */
public class UserBo {

  public long id;
  public String username;
  public String nickname;
  public int sex;
  public long timeCreate;
  public long timeUpdate;

  public static UserBo valueOf(UserPo userPo) {
    if (userPo == null) {
      return null;
    }

    UserBo userBo = new UserBo();
    BeanUtils.copyProperties(userPo, userBo);
    return userBo;
  }

  public UserPo toUserPo() {
    UserPo userPo = new UserPo();
    BeanUtils.copyProperties(this, userPo);
    return userPo;
  }
}
