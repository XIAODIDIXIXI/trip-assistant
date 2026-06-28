package com.travelai.service.impl;

import com.travelai.domain.Trip;
import com.travelai.domain.TripRequest;
import com.travelai.mapper.TripMapper;
import com.travelai.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 行程服务实现 — 生成行程、调AI、写入数据库
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripMapper tripMapper;

    @Override
    public Trip generateTrip(TripRequest request) {
        log.info("收到行程规划请求：{} {}天 ￥{}", request.getCity(), request.getDays(), request.getBudget());

        // TODO: 调用 DeepSeek AI 生成真实行程
        String aiContent = buildMockContent(request);

        Trip trip = new Trip();
        trip.setUserId(1L); // 先硬编码用户ID，等登录完成后替换
        trip.setCity(request.getCity());
        trip.setDays(request.getDays());
        trip.setBudget(request.getBudget());
        trip.setTravelType(request.getTravelType());
        trip.setPreferences(request.getPreferences());
        trip.setContent(aiContent);

        tripMapper.insert(trip);
        log.info("行程已保存，id={}", trip.getId());
        return trip;
    }

    /**
     * 模拟 AI 生成的行程内容（JSON格式）
     */
    private String buildMockContent(TripRequest request) {
        String city = request.getCity();
        int days = request.getDays();

        StringBuilder json = new StringBuilder();
        json.append("{\"city\":\"").append(city).append("\",");
        json.append("\"days\":").append(days).append(",");
        json.append("\"schedule\":[");

        String[] times = {"上午", "下午", "晚上"};
        String[][] spots = {
            {"抵达" + city + "，入住酒店", "游览市中心", "品尝当地美食"},
            {"参观著名景点", "体验本地文化", "夜市探索"},
            {"自由活动", "购买纪念品", "返程"}
        };

        for (int d = 0; d < days; d++) {
            json.append("{\"day\":").append(d + 1).append(",\"items\":[");
            int dayIdx = Math.min(d, spots.length - 1);
            for (int t = 0; t < 3; t++) {
                json.append("{\"time\":\"").append(times[t]).append("\",");
                json.append("\"activity\":\"").append(spots[dayIdx][t]).append("\"}");
                if (t < 2) json.append(",");
            }
            json.append("]}");
            if (d < days - 1) json.append(",");
        }

        json.append("]}");
        return json.toString();
    }
}
