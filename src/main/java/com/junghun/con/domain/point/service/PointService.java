package com.junghun.con.domain.point.service;

import com.junghun.con.domain.point.dto.MakePointDto;
import com.junghun.con.domain.point.entity.Point;
import com.junghun.con.domain.point.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository repository;

    public Point makePoint(MakePointDto makePointDto) {
        Point point = Point.builder()
                .userId(makePointDto.getUserId())
                .point(makePointDto.getPoint())
                .minOrderPrice(makePointDto.getMinOrderPrice())
                .receivedDate(LocalDateTime.now())
                .expiredDate(LocalDateTime.now().plusMonths(2))
                .isUsed(false)
                .build();

        return repository.save(point);
    }

    public void welcomePoint(Long userId) {
        Point point = Point.builder()
                .userId(userId)
                .point(1000)
                .minOrderPrice(10000)
                .receivedDate(LocalDateTime.now())
                .expiredDate(LocalDateTime.now().plusMonths(2))
                .isUsed(false)
                .build();

        repository.save(point);
    }
}
