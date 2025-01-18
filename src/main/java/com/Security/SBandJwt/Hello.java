package com.Security.SBandJwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
   @GetMapping("/")
    public String hello(HttpServletRequest req) {
       return "Hello World"+req.getSession().getId();
   }
}
