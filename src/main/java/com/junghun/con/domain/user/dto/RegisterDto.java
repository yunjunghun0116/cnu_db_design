package com.junghun.con.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    private String email;
    private String name;
    private String password;
    private String phone;
}
