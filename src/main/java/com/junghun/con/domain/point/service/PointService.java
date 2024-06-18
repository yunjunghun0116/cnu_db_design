package com.junghun.con.domain.point.service;

import com.junghun.con.domain.point.dto.MakePointDto;
import com.junghun.con.domain.point.entity.Point;
import com.junghun.con.domain.point.exception.NotFoundPointException;
import com.junghun.con.domain.point.exception.UnavailablePointException;
import com.junghun.con.domain.point.repository.PointRepository;
import com.junghun.con.domain.user.entity.User;
import com.junghun.con.domain.user.exception.NotFoundUserException;
import com.junghun.con.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository repository;

    private final UserRepository userRepository;

    public Point makePoint(MakePointDto makePointDto) {

        User user = userRepository.findById(makePointDto.getUserId()).orElseThrow(()->new NotFoundUserException("해당 id를 가진 유저를 찾을 수 없습니다."));
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

    public void welcomePoint(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new NotFoundUserException("해당 id를 가진 유저를 찾을 수 없습니다."));

        Point point = Point.builder()
                .user(user)
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
                .user(point.getUser())
                .point(point.getPoint())
                .minOrderPrice(point.getMinOrderPrice())
                .receivedDate(point.getReceivedDate())
                .expiredDate(point.getExpiredDate())
                .isUsed(true)
                .build();

        return repository.save(usedPoint);
    }

    public void useAllPoint(Long userId) {
        List<Point> pointList = getUserPoint(userId);

        for(Point point : pointList){
            Point usedPoint = Point.builder()
                    .id(point.getId())
                    .user(point.getUser())
                    .point(point.getPoint())
                    .minOrderPrice(point.getMinOrderPrice())
                    .receivedDate(point.getReceivedDate())
                    .expiredDate(point.getExpiredDate())
                    .isUsed(true)
                    .build();
            repository.save(usedPoint);
        }


    }
}
