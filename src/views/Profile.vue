<script setup>
</script>

<template>
  <div class="profile">
    <van-nav-bar title="我的" fixed />

    <div class="content">
      <!-- 个人信息 -->
      <div class="profile-header">
        <div class="avatar">
          <van-icon name="user-o" size="32" />
        </div>
        <h3>旅行者</h3>
        <p>请先登录</p>
        <van-button type="primary" round size="small">登录 / 注册</van-button>
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
  </div>
</template>

<style scoped>
.profile {
  min-height: 100vh;
}

.content {
  padding-top: 46px;
}

/* 个人信息 */
.profile-header {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 32px 16px 24px;
  margin: 12px;
  background: var(--bg-card);
  border-radius: var(--radius-lg);
}

.avatar {
  width: 72px;
  height: 72px;
  border-radius: 50%;
  background: var(--bg-page);
  display: flex;
  align-items: center;
  justify-content: center;
  color: var(--text-muted);
  margin-bottom: 12px;
}

.profile-header h3 {
  font-size: 18px;
  margin-bottom: 4px;
}

.profile-header p {
  color: var(--text-muted);
  font-size: 14px;
  margin-bottom: 16px;
}

/* 数据概览 */
.stats-row {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 8px;
  padding: 0 12px;
}

.stat-item {
  background: var(--bg-card);
  border-radius: var(--radius-md);
  padding: 20px 8px;
  text-align: center;
}

.stat-num {
  font-family: var(--font-display);
  font-size: 28px;
  color: var(--accent);
}

.stat-label {
  font-size: 12px;
  color: var(--text-muted);
  margin-top: 4px;
}
</style>
