package com.agungtsp.githubuserfavorite.github;

import com.agungtsp.githubuserfavorite.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class GithubUserService {

  public ArrayList<GithubUserDAO> getUser() {
    Integer perPage = 10;

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(JacksonConverterFactory.create())
        .build();

    GithubUserRepository service = retrofit.create(GithubUserRepository.class);

    ArrayList<GithubUserDAO> listUsers = null;
    try {
      listUsers = service.get(perPage).execute().body();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return listUsers;
  }

}
