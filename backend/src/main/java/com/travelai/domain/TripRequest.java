package com.travelai.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 前端提交的行程规划请求
 */
@Data
public class TripRequest {
    @NotBlank(message = "目的地不能为空")
    private String city;

    @NotNull(message = "天数不能为空")
    private Integer days;

    private Integer budget;
    private String travelType;   // family/couple/solo/friend
    private String preferences;  // food,nature,culture
}
