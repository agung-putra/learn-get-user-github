package com.agungtsp.githubuserfavorite;

import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/favorite-users")
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<User> fetchAllStudents() {
    return userService.getAllUsers();
  }

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

  @DeleteMapping(path = "{userId}")
  public ResponseEntity<String> deleteStudent(@PathVariable("userId") String userId) {
    try {
      userService.deleteUser(userId);
      return new ResponseEntity<>("Success", HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest()
          .body(e.getMessage());
    }
  }
}
