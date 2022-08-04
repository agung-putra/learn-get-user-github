package com.agungtsp.githubuserfavorite;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository
  extends MongoRepository<User, Long > {
  Optional<User> findUserByLogin(String login);
  Optional<User> findUserById(String id);

  Optional<User> deleteById(String id);
}
