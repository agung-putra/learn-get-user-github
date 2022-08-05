package com.agungtsp.githubuserfavorite;

import java.time.LocalDateTime;
import java.util.Date;
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

  public User detailUsers(String userId) {
    Optional<User> user = userRepository.findUserById(userId);
    if(user.isPresent()){
      return user.get();
    } else {
      throw new IllegalStateException(userId + " Not Found");
    }
  }

  public void AddFavoriteUser(User user) {
    userRepository.findUserByLogin(user.getLogin())
      .ifPresent(s -> {
        throw new IllegalStateException(s.getLogin() + " already exist");
      });
    user.setCreated(LocalDateTime.now());
    userRepository.insert(user);
  }

  public void updateUser(String userId, User user) {
    Optional<User> detailUser = userRepository.findUserById(userId);
    if(detailUser.isPresent()){
      User updateUser = detailUser.get();
      updateUser.setNode_id(user.getNode_id());
      updateUser.setUrl(user.getUrl());
      updateUser.setUpdated(LocalDateTime.now());
      userRepository.save(updateUser);
    } else {
      throw new IllegalStateException(userId + " Not Found");
    }
  }

  public void deleteUser(String userId) {
    if(userRepository.findUserById(userId).isPresent()){
      userRepository.deleteById(userId);
    } else {
      throw new IllegalStateException(userId + " Not Found");
    }
  }
}
