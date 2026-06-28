-- 创建数据库
CREATE DATABASE IF NOT EXISTS travel_ai DEFAULT CHARSET utf8mb4;

USE travel_ai;

-- 用户表
CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    phone VARCHAR(20) NOT NULL UNIQUE,
    nickname VARCHAR(50),
    avatar VARCHAR(255),
    created_at DATETIME,
    updated_at DATETIME
);

-- 行程表
CREATE TABLE IF NOT EXISTS trip (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    city VARCHAR(50) NOT NULL COMMENT '目的地城市',
    days INT NOT NULL COMMENT '旅行天数',
    budget INT NOT NULL DEFAULT 0 COMMENT '预算',
    travel_type VARCHAR(20) COMMENT '出行类型: family/couple/solo/friend',
    preferences VARCHAR(200) COMMENT '兴趣偏好，逗号分隔',
    content JSON COMMENT 'AI生成的行程内容JSON',
    created_at DATETIME
);
