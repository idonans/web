package com.idonans.web.user;

import com.idonans.web.user.domain.User;
import com.idonans.web.user.mapper.UserMapper;
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
  private UserMapper userMapper;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public User getById(@PathVariable long id) {
    User user = userMapper.findById(id);
    return user;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody
  public User createOne(@RequestBody User userInput) {
    userInput.timeCreate = System.currentTimeMillis();
    userInput.timeUpdate = userInput.timeCreate;
    long id = userMapper.insertOne(userInput);
    User user = getById(id);
    return user;
  }
}
