package com.junghun.con.domain.point.controller;

import com.junghun.con.domain.point.dto.MakePointDto;
import com.junghun.con.domain.point.entity.Point;
import com.junghun.con.domain.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/point")
@RequiredArgsConstructor
public class PointController {

    private final PointService service;

    @PutMapping("/make")
    public ResponseEntity<Point> makePoint(@RequestBody MakePointDto makePointDto) {
        Point point = service.makePoint(makePointDto);
        return new ResponseEntity<>(point, HttpStatus.CREATED);
    }

}
