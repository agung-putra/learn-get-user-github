package com.agungtsp.githubuserfavorite.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GithubUser {

  public static void main(String[] args) {
    SpringApplication.run(GithubUser.class, args);
  }

}
