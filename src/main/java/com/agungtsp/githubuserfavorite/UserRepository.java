package com.agungtsp.githubuserfavorite;

import java.util.Optional;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository
    extends MongoRepository<User, Long > {
  Optional<User> findUserByLogin(String login);
  Optional<User> findUserById(String id);

  @DeleteQuery(value="{'id' : $0}")
  Optional<User> deleteById(String id);
}
