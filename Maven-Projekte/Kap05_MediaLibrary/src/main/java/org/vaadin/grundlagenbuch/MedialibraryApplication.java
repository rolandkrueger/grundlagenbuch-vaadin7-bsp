package org.vaadin.grundlagenbuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.vaadin.grundlagenbuch.repository")
@EnableElasticsearchRepositories(basePackages = "org.vaadin.grundlagenbuch.elasticsearch.repository")
public class MedialibraryApplication {
  public static void main(String[] args) {
    SpringApplication.run(MedialibraryApplication.class, args);
  }
}
