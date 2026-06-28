package com.travelai.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("trip")
public class Trip {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String city;
    private Integer days;
    private Integer budget;
    private String travelType;
    private String preferences;
    private String content; // JSON 格式的 AI 行程内容
    private LocalDateTime createdAt;
}
