package com.junghun.con.domain.point.service;

import com.junghun.con.domain.point.dto.MakePointDto;
import com.junghun.con.domain.point.entity.Point;
import com.junghun.con.domain.point.repository.PointRepository;
import com.junghun.con.domain.user.entity.User;
import com.junghun.con.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository repository;
    private final UserService userService;

    public Point makePoint(MakePointDto makePointDto) {
        User user = userService.findById(makePointDto.getUserId());

        Point point = Point.builder()
                .user(user)
                .point(makePointDto.getPoint())
                .minOrderPrice(makePointDto.getMinOrderPrice())
                .receivedDate(LocalDateTime.now())
                .expiredDate(LocalDateTime.now().plusMonths(2))
                .isUsed(false)
                .build();

        return repository.save(point);
    }
}
