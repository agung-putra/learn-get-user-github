package com.agungtsp.githubuserfavorite.github;

import lombok.Data;


@Data
public class GithubUserDAO {
  private Integer id;
  private String login;
  private String node_id;
  private String avatar_url;
  private String gravatar_id;
  private String url;
  private String html_url;
  private String followers_url;
  private String following_url;
  private String gists_url;
  private String starred_url;
  private String subscriptions_url;
  private String organizations_url;
  private String repos_url;
  private String events_url;
  private String received_events_url;
  private String type;
  private Boolean site_admin;
}
