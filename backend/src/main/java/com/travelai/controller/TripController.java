package com.travelai.controller;

import com.travelai.domain.Trip;
import com.travelai.domain.TripRequest;
import com.travelai.service.TripService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 行程控制器 — 接收前端请求，返回行程结果
 */
@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    /**
     * 生成行程
     * POST /api/trips/generate
     */
    @PostMapping("/generate")
    public ResponseEntity<Map<String, Object>> generateTrip(@Valid @RequestBody TripRequest request) {
        Trip trip = tripService.generateTrip(request);

        return ResponseEntity.ok(Map.of(
            "code", 200,
            "message", "行程生成成功",
            "data", trip
        ));
    }
}
