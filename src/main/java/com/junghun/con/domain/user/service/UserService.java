package com.junghun.con.domain.user.service;

import com.junghun.con.domain.point.service.PointService;
import com.junghun.con.domain.user.dto.LoginDto;
import com.junghun.con.domain.user.dto.RegisterDto;
import com.junghun.con.domain.user.entity.User;
import com.junghun.con.domain.user.exception.DuplicatedEmailException;
import com.junghun.con.domain.user.exception.InvalidInputException;
import com.junghun.con.domain.user.exception.NotFoundUserException;
import com.junghun.con.domain.user.repository.UserRepository;
import com.junghun.con.util.RegexUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final PointService pointService;

    public User register(RegisterDto registerDto) {
        if (!RegexUtils.isValidEmail(registerDto.getEmail())) {
            throw new InvalidInputException("사용할 수 없는 이메일입니다. ");
        }
        if (!RegexUtils.isValidPassword(registerDto.getPassword())) {
            throw new InvalidInputException("사용할 수 없는 패스워드입니다. ");
        }
        if (!RegexUtils.isValidName(registerDto.getName())) {
            throw new InvalidInputException("사용할 수 없는 닉네임입니다.");
        }
        if (repository.findByEmail(registerDto.getEmail()).isPresent()) {
            throw new DuplicatedEmailException(registerDto.getEmail() + "은 이미 가입된 이메일입니다.");
        }

        String encryptedPassword = passwordEncoder.encode(registerDto.getPassword());

        User user = User.builder()
                .email(registerDto.getEmail())
                .name(registerDto.getName())
                .password(encryptedPassword)
                .phone(registerDto.getPhone())
                .build();

        pointService.welcomePoint(user.getId());

        return repository.save(user);
    }

    public User login(LoginDto loginDto) {
        User user = repository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new NotFoundUserException(loginDto.getEmail() + " 이메일을 가진 이용자가 존재하지 않습니다."));

        if (user != null && passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return user;
        }

        return null;
    }
}