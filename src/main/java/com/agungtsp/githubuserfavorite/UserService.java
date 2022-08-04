package com.agungtsp.githubuserfavorite;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
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
        .ifPresentOrElse(s -> {
          throw new IllegalStateException(s.getLogin() + " already exist");
        }, () -> {
          userRepository.insert(user);
        });
  }

  public void deleteUser(String login) {
    userRepository.findUserById(login)
        .ifPresentOrElse(s -> {
          userRepository.deleteById(s.getId());
        }, () -> {
          throw new IllegalStateException(login + " Not Found");
        });

  }
}
