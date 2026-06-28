package com.travelai.service;

import com.travelai.domain.Trip;
import com.travelai.domain.TripRequest;

/**
 * 行程服务接口 — 定义行程相关操作
 */
public interface TripService {

    /**
     * 生成行程（调 AI + 存入数据库）
     */
    Trip generateTrip(TripRequest request);
}
