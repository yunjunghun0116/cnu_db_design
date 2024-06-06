package com.junghun.con.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RegisterDto {
    private String email;
    private String name;
    private String password;
    private String phone;
}
