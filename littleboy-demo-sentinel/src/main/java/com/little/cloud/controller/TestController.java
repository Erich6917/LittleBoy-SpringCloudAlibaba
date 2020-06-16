package com.little.cloud.controller;

import com.alibaba.csp.sentinel.adapter.reactor.SentinelReactorTransformer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2020-6-16
 */
@RestController
public class TestController {

  @GetMapping(value = "/hello")
  @SentinelResource("hello")
  public String hello() {
    return "Hello Sentinel";
  }

  @GetMapping("/mono")
  @SentinelResource("mono")
  public Mono<String> mono() {
    return Mono.just("simple string")
        .transform(new SentinelReactorTransformer<>("otherResourceName"));
  }


}
