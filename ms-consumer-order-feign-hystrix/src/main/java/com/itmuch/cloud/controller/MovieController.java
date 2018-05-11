package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;

@RestController
public class MovieController {

  @Autowired
  private UserFeignClient userFeignClient;

  @GetMapping("/movie-feign-hystrix/{id}")
  public User findById(@PathVariable Long id) {
    return this.userFeignClient.findById(id);
  }

  @GetMapping("/test-feign-hystrix")
  public User testPost(User user) {
    return this.userFeignClient.postUser(user);
  }

  @GetMapping("/test-get-feign-hystrix")
  public User testGet(User user) {
    return this.userFeignClient.getUser(user);
  }
}
