package com.agungtsp.githubuserfavorite;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.hamcrest.core.IsNull;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public void AddFavoriteUser(User user) {
    userRepository.findUserByLogin(user.getLogin())
      .ifPresent(s -> {
        throw new IllegalStateException(s.getLogin() + " already exist");
      });
    userRepository.insert(user);
  }

  public void deleteUser(String login) {
    if(userRepository.findUserById(login).isPresent()){
      userRepository.deleteById(login);
    } else {
      throw new IllegalStateException(login + " Not Found");
    }
  }
}
