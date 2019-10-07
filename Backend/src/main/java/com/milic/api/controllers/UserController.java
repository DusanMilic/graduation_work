package com.milic.api.controllers;

import com.milic.api.model.CredentialsDto;
import com.milic.api.model.UserDto;
import com.milic.db.model.User;
import com.milic.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sun.tools.jconsole.JConsole;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  User createUser(@RequestBody UserDto userDto) {
    return userService.create(userDto);
  }

  @PostMapping(value = "/credentials", consumes = "application/json", produces = "application/json")
  public User getByCredentials(@RequestBody CredentialsDto credentialsDto) {
    User user = userService.getByEmail(credentialsDto.getEmail());
    if (user == null || !credentialsDto.getPassword().equals(user.getPassword())) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
    return user;
  }
}
