package com.example.moocClient;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class MoocClientServletInitializer
       extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(
                                    SpringApplicationBuilder builder) {
    return builder.sources(MoocClientApplication.class);
  }
  
}
