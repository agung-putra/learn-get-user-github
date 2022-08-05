package com.agungtsp.githubuserfavorite;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/favorite-users")
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  /**
   * Get all favorite users list.
   *
   * @return the list
   */
  @GetMapping
  public List<User> fetchAllUsers() {
    return userService.getAllUsers();
  }

  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping(path = "{userId}")
  public Object detailUsers(@PathVariable("userId") String userId) {
    try {
      return userService.detailUsers(userId);
    } catch (Exception e) {
      return ResponseEntity.badRequest()
          .body(e.getMessage());
    }
  }

  /**
   * Create user favorite.
   *
   * @param user the user
   * @return Success
   */
  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> addFavoriteUser(@Valid @RequestBody User user) {
    try {
      userService.AddFavoriteUser(user);
      return new ResponseEntity<>("Success", HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest()
          .body(e.getMessage());
    }
  }

  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param user the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping(path = "{userId}")
  public ResponseEntity<String>  updateUser(
      @PathVariable("userId") String userId, @RequestBody User user) {
    try {
      userService.updateUser(userId, user);
      return new ResponseEntity<>("Success", HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest()
          .body(e.getMessage());
    }
  }

  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping(path = "{userId}")
  public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId) {
    try {
      userService.deleteUser(userId);
      return new ResponseEntity<>("Success", HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest()
          .body(e.getMessage());
    }
  }
}
