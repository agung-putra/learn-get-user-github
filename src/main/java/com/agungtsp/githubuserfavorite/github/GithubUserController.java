package com.agungtsp.githubuserfavorite.github;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/github-users")
public class GithubUserController {
  private final GithubUserService githubUserService;

  @Autowired
  public GithubUserController(GithubUserService githubUserService) {
    this.githubUserService = githubUserService;
  }

  @GetMapping
  public ArrayList<GithubUserDAO> list() {
    return githubUserService.getUser().blockingGet();
  }

}
