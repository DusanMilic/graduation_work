package com.milic.service;

import com.milic.api.model.UserDto;
import com.milic.db.model.User;
import com.milic.db.repositories.UserRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepo userRepo;

  @Autowired
  public UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public User create(UserDto userDto) {
    return userRepo.save(User.fromDto(userDto));
  }

  public User getByEmail(String email) {
    Optional<User> maybeUser = userRepo.findByEmail(email);
    return maybeUser.orElse(null);
  }
}
