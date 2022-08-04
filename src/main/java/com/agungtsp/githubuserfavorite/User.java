package com.agungtsp.githubuserfavorite;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
  @Id
  private String id;
  private Integer id_github;
  @Indexed(unique = true)
  @NotNull(message = "Login ID is required")
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
  private LocalDateTime created;

  public User(Integer id_github, String login, String node_id, String avatar_url,
      String gravatar_id, String url, String html_url, String followers_url, String following_url,
      String gists_url, String starred_url, String subscriptions_url, String organizations_url,
      String repos_url, String events_url, String received_events_url, String type,
      Boolean site_admin, LocalDateTime created) {
    this.id_github = id_github;
    this.login = login;
    this.node_id = node_id;
    this.avatar_url = avatar_url;
    this.gravatar_id = gravatar_id;
    this.url = url;
    this.html_url = html_url;
    this.followers_url = followers_url;
    this.following_url = following_url;
    this.gists_url = gists_url;
    this.starred_url = starred_url;
    this.subscriptions_url = subscriptions_url;
    this.organizations_url = organizations_url;
    this.repos_url = repos_url;
    this.events_url = events_url;
    this.received_events_url = received_events_url;
    this.type = type;
    this.site_admin = site_admin;
    this.created = created;
  }
}
