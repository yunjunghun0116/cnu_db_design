package com.junghun.con.domain.user.controller;

import com.junghun.con.domain.user.dto.LoginDto;
import com.junghun.con.domain.user.dto.RegisterDto;
import com.junghun.con.domain.user.entity.User;
import com.junghun.con.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @ResponseBody
    @PutMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto) {
        User registeredUser = service.register(registerDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @ResponseBody
    @PutMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto loginDto) {
        User loginUser = service.login(loginDto);
        return new ResponseEntity<>(loginUser, HttpStatus.CREATED);
    }
}
