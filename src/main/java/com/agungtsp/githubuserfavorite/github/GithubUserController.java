package com.agungtsp.githubuserfavorite.github;

import com.agungtsp.githubuserfavorite.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@RestController
@RequestMapping("api/v1/github-users")
public class GithubUserController {
  private final GithubUserService githubUserService;

  @Autowired
  public GithubUserController(GithubUserService githubUserService) {
    this.githubUserService = githubUserService;
  }

  @GetMapping
  public List<GithubUserDAO> list() {
    return githubUserService.getUser();
  }

}
