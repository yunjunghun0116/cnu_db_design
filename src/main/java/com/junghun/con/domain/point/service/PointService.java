package com.junghun.con.domain.point.service;

import com.junghun.con.domain.point.dto.MakePointDto;
import com.junghun.con.domain.point.entity.Point;
import com.junghun.con.domain.point.exception.NotFoundPointException;
import com.junghun.con.domain.point.exception.UnavailablePointException;
import com.junghun.con.domain.point.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<Point> getUserPoint(Long userId) {
        return repository.findByUserCanUsePoint(userId);
    }

    public Point usePoint(Long id) {
        Point point = repository.findById(id).orElseThrow(() -> new NotFoundPointException(id + " 아이디를 가진 포인트가 존재하지 않습니다."));
        if (point.getExpiredDate().isBefore(LocalDateTime.now())) {
            throw new UnavailablePointException("사용 불가능한 포인트입니다.");
        }

        Point usedPoint = Point.builder()
                .id(id)
                .userId(point.getUserId())
                .point(point.getPoint())
                .minOrderPrice(point.getMinOrderPrice())
                .receivedDate(point.getReceivedDate())
                .expiredDate(point.getExpiredDate())
                .isUsed(true)
                .build();

        return repository.save(usedPoint);
    }
}
