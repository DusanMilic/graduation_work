package com.milic.db.repositories;

import com.milic.db.model.User;
import com.milic.db.model.UserType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
  List<User> findByUserType(UserType userType);
}
