package com.agungtsp.githubuserfavorite.github;

import com.agungtsp.githubuserfavorite.User;
import java.util.ArrayList;
import java.util.Optional;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubUserRepository {
  @Headers("Accept: application/json")
  @GET("/users")
  Call<ArrayList<GithubUserDAO>> get(@Query("per_page") Integer perPage);

  Optional<User> findUserByEmail(String email);
}
