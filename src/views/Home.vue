<script setup>
</script>

<template>
  <div class="home">
    <!-- 顶部导航 -->
    <van-nav-bar title="AI 旅游助手" fixed />

    <!-- 公告 -->
    <div class="content-top">
      <van-notice-bar
        left-icon="volume-o"
        text="每一次出发，都是一个新的开始。告诉我们你的目的地，剩下的交给我们。"
        background="#F8F5F0"
        color="#636E72"
      />
    </div>

    <!-- 欢迎区 -->
    <div class="welcome">
      <h1 class="welcome-title">早安，准备好出发了吗？</h1>
      <p class="welcome-sub">你的下一段旅程从这里开始</p>
    </div>

    <!-- 规划面板 -->
    <div class="card">
      <h2 class="card-title">规划你的旅程</h2>

      <div class="plan-form">
        <van-field
          label="目的地"
          placeholder="请选择目的地"
          is-link
          readonly
          clickable
        />
        <van-field
          label="天数"
          placeholder="请输入天数"
          type="digit"
        />
        <van-field
          label="预算（元）"
          placeholder="请输入预算"
          type="number"
        />

        <div class="form-section">
          <div class="form-label">出行类型</div>
          <div class="tag-row">
            <span class="tag">👨‍👩‍👧 家庭</span>
            <span class="tag tag-active">💑 情侣</span>
            <span class="tag">🧑‍💻 独自</span>
            <span class="tag">👥 朋友</span>
          </div>
        </div>

        <div class="form-section">
          <div class="form-label">兴趣偏好</div>
          <div class="tag-row">
            <span class="tag">🍜 美食</span>
            <span class="tag tag-active">🏔️ 自然</span>
            <span class="tag">🏛️ 人文</span>
            <span class="tag">🛍️ 购物</span>
            <span class="tag">🚴 户外</span>
          </div>
        </div>

        <van-button type="primary" block round size="large">
          🚀 生成行程
        </van-button>
      </div>
    </div>

    <!-- 数据卡片行 -->
    <div class="stats-row">
      <div class="stat-card">
        <div class="stat-icon">☀️</div>
        <div class="stat-value">--°</div>
        <div class="stat-name">目的地天气</div>
      </div>
      <div class="stat-card">
        <div class="stat-icon">💰</div>
        <div class="stat-value">--</div>
        <div class="stat-name">预估预算</div>
      </div>
      <div class="stat-card">
        <div class="stat-icon">🌍</div>
        <div class="stat-value">0</div>
        <div class="stat-name">已点亮</div>
      </div>
      <div class="stat-card">
        <div class="stat-icon">📋</div>
        <div class="stat-value">0</div>
        <div class="stat-name">行程</div>
      </div>
    </div>

    <!-- 热门目的地 -->
    <div class="card">
      <h2 class="card-title">热门目的地</h2>
      <div class="city-tags">
        <span class="city-tag">北京</span>
        <span class="city-tag">上海</span>
        <span class="city-tag">成都</span>
        <span class="city-tag">杭州</span>
        <span class="city-tag">西安</span>
        <span class="city-tag">三亚</span>
        <span class="city-tag">大理</span>
        <span class="city-tag">桂林</span>
      </div>
    </div>

    <!-- 行程结果占位 -->
    <div class="result-placeholder">
      <p>输入目的地和天数，点击"生成行程"开始规划 ✈️</p>
    </div>
  </div>
</template>

<style scoped>
.home {
  padding-bottom: 20px;
}

/* 顶部留出 NavBar 空间 */
.content-top {
  margin-top: 46px;
}

/* 欢迎区 */
.welcome {
  padding: 20px 16px 12px;
}

.welcome-title {
  font-size: 24px;
  margin-bottom: 4px;
}

.welcome-sub {
  font-size: 14px;
  color: var(--text-muted);
}

/* 卡片 */
.card {
  background: var(--bg-card);
  border-radius: var(--radius-lg);
  padding: 16px;
  margin: 0 12px 12px;
  box-shadow: 0 1px 8px rgba(0, 0, 0, 0.03);
}

.card-title {
  font-size: 17px;
  margin-bottom: 14px;
  padding-bottom: 10px;
  border-bottom: 1px solid var(--border);
}

/* 表单 */
.plan-form {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.plan-form :deep(.van-field) {
  background: var(--bg-page);
  border-radius: var(--radius-md);
}

.form-section {
  padding: 8px 0;
}

.form-label {
  font-size: 13px;
  color: var(--text-muted);
  margin-bottom: 8px;
}

.tag-row {
  display: flex;
  gap: 8px;
  flex-wrap: wrap;
}

.tag {
  padding: 6px 14px;
  background: var(--bg-page);
  border: 1px solid var(--border);
  border-radius: 20px;
  font-size: 13px;
  color: var(--text-secondary);
  cursor: pointer;
}

.tag-active {
  border-color: var(--accent);
  color: var(--accent);
  background: var(--accent-bg);
}

/* 数据卡片行 */
.stats-row {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 8px;
  padding: 0 12px;
  margin-bottom: 12px;
}

.stat-card {
  background: var(--bg-card);
  border-radius: var(--radius-md);
  padding: 14px 8px;
  text-align: center;
  box-shadow: 0 1px 6px rgba(0, 0, 0, 0.02);
}

.stat-icon {
  font-size: 20px;
  margin-bottom: 4px;
}

.stat-value {
  font-family: var(--font-display);
  font-size: 18px;
  color: var(--text-primary);
  font-weight: 600;
}

.stat-name {
  font-size: 11px;
  color: var(--text-muted);
}

/* 热门目的地 */
.city-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
}

.city-tag {
  padding: 6px 16px;
  background: var(--bg-page);
  border: 1px solid var(--border);
  border-radius: 20px;
  font-size: 13px;
  color: var(--text-secondary);
}

/* 结果占位 */
.result-placeholder {
  text-align: center;
  padding: 32px 16px;
  color: var(--text-muted);
  font-size: 13px;
  margin: 0 12px 12px;
  background: var(--bg-card);
  border-radius: var(--radius-lg);
  border: 1px dashed var(--border-strong);
}
</style>
