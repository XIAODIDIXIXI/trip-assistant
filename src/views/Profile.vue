<script setup>
import { UserFilled } from '@element-plus/icons-vue'
</script>

<template>
  <div class="profile">
    <div class="welcome">
      <h1 class="welcome-title">👤 我的</h1>
      <p class="welcome-sub">个人中心，你的旅行记忆</p>
    </div>

    <!-- 个人信息卡片 -->
    <div class="profile-card">
      <div class="avatar-placeholder">
        <el-icon :size="40"><UserFilled /></el-icon>
      </div>
      <div class="profile-info">
        <h3>旅行者</h3>
        <p>请先登录</p>
      </div>
      <el-button type="primary" round size="large">登录 / 注册</el-button>
    </div>

    <!-- 数据概览 -->
    <div class="stats-row">
      <div class="stat-item">
        <div class="stat-num">0</div>
        <div class="stat-label">行程</div>
      </div>
      <div class="stat-item">
        <div class="stat-num">0</div>
        <div class="stat-label">点亮</div>
      </div>
      <div class="stat-item">
        <div class="stat-num">0</div>
        <div class="stat-label">会话</div>
      </div>
      <div class="stat-item">
        <div class="stat-num">0</div>
        <div class="stat-label">收藏</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.profile {
  max-width: 960px;
  margin: 0 auto;
}

.welcome {
  margin-bottom: 28px;
}

.welcome-title {
  font-size: 28px;
  margin-bottom: 6px;
}

.welcome-sub {
  font-size: 15px;
  color: var(--text-muted);
}

.profile-card {
  background: var(--bg-card);
  border-radius: var(--radius-lg);
  padding: 32px;
  display: flex;
  align-items: center;
  gap: 20px;
  margin-bottom: 20px;
  box-shadow: 0 2px 16px rgba(0, 0, 0, 0.04);
}

.avatar-placeholder {
  width: 72px;
  height: 72px;
  border-radius: 50%;
  background: var(--bg-page);
  display: flex;
  align-items: center;
  justify-content: center;
  color: var(--text-muted);
}

.profile-info {
  flex: 1;
}

.profile-info h3 {
  font-size: 18px;
  margin-bottom: 4px;
}

.profile-info p {
  color: var(--text-muted);
  font-size: 14px;
}

.stats-row {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 14px;
}

.stat-item {
  background: var(--bg-card);
  border-radius: var(--radius-md);
  padding: 24px;
  text-align: center;
  box-shadow: 0 1px 8px rgba(0, 0, 0, 0.03);
}

.stat-num {
  font-family: var(--font-display);
  font-size: 28px;
  color: var(--accent);
}

.stat-label {
  font-size: 13px;
  color: var(--text-muted);
  margin-top: 4px;
}
</style>
