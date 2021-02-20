package com.itheima.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2021-2-20
 */
public class Tes {

  public static void main(String[] args) {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String password = passwordEncoder.encode("123");
    System.out.println(password);
  }
}
