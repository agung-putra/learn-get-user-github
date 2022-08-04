package com.agungtsp.githubuserfavorite.github;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class GithubUserService {
  public static Single<ArrayList<GithubUserDAO>> getUser(){
    return Single.create(emitter -> {
      ArrayList<GithubUserDAO> user = fetchUser();

      if(user != null){
        emitter.onSuccess(user);
      } else {
        emitter.onError(new Exception("User not found"));
      }
    });
  }

  public static ArrayList<GithubUserDAO> fetchUser(){
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
