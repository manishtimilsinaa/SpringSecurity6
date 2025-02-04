package com.Security.SBandJwt.service;

import com.Security.SBandJwt.model.Users;
import com.Security.SBandJwt.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
return repo.save(user);
    }

}
