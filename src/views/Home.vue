<script setup>
</script>

<template>
  <div class="home">
    <!-- 欢迎区 -->
    <div class="welcome">
      <h1 class="welcome-title">早安，准备好出发了吗？</h1>
      <p class="welcome-sub">你的下一段旅程从这里开始</p>
    </div>

    <!-- 规划面板 -->
    <div class="plan-card">
      <h2 class="card-title">规划你的旅程</h2>

      <div class="plan-form">
        <div class="form-row">
          <el-input
            placeholder="目的地"
            size="large"
            class="plan-input"
          />
          <el-input-number
            placeholder="天数"
            :min="1"
            :max="30"
            size="large"
            class="plan-input"
          />
          <el-input-number
            placeholder="预算（元）"
            :min="0"
            :step="500"
            size="large"
            class="plan-input"
          />
        </div>

        <div class="form-row">
          <el-radio-group size="large">
            <el-radio-button value="family">👨‍👩‍👧 家庭</el-radio-button>
            <el-radio-button value="couple">💑 情侣</el-radio-button>
            <el-radio-button value="solo">🧑‍💻 独自</el-radio-button>
            <el-radio-button value="friend">👥 朋友</el-radio-button>
          </el-radio-group>
        </div>

        <div class="form-row">
          <el-checkbox-group size="large">
            <el-checkbox-button value="food">🍜 美食</el-checkbox-button>
            <el-checkbox-button value="nature">🏔️ 自然</el-checkbox-button>
            <el-checkbox-button value="culture">🏛️ 人文</el-checkbox-button>
            <el-checkbox-button value="shopping">🛍️ 购物</el-checkbox-button>
            <el-checkbox-button value="outdoor">🚴 户外</el-checkbox-button>
          </el-checkbox-group>
        </div>

        <el-button type="primary" size="large" round class="plan-submit">
          🚀 生成行程
        </el-button>
      </div>
    </div>

    <!-- 数据卡片行 -->
    <div class="stats-row">
      <div class="stat-card">
        <div class="stat-icon">☀️</div>
        <div class="stat-info">
          <div class="stat-value">--°</div>
          <div class="stat-name">目的地天气</div>
        </div>
      </div>
      <div class="stat-card">
        <div class="stat-icon">💰</div>
        <div class="stat-info">
          <div class="stat-value">--</div>
          <div class="stat-name">预估预算</div>
        </div>
      </div>
      <div class="stat-card">
        <div class="stat-icon">🌍</div>
        <div class="stat-info">
          <div class="stat-value">0</div>
          <div class="stat-name">已点亮城市</div>
        </div>
      </div>
      <div class="stat-card">
        <div class="stat-icon">📋</div>
        <div class="stat-info">
          <div class="stat-value">0</div>
          <div class="stat-name">历史行程</div>
        </div>
      </div>
    </div>

    <!-- 热门目的地 -->
    <div class="section-card">
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
        <span class="city-tag">拉萨</span>
        <span class="city-tag">厦门</span>
      </div>
    </div>

    <!-- 生成结果占位 -->
    <div class="result-placeholder">
      <p>输入目的地和天数，点击"生成行程"开始规划</p>
    </div>
  </div>
</template>

<style scoped>
.home {
  max-width: 960px;
  margin: 0 auto;
}

/* 欢迎区 */
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

/* 规划面板 */
.plan-card {
  background: var(--bg-card);
  border-radius: var(--radius-lg);
  padding: 28px;
  margin-bottom: 20px;
  box-shadow: 0 2px 16px rgba(0, 0, 0, 0.04);
}

.card-title {
  font-size: 18px;
  margin-bottom: 20px;
  padding-bottom: 12px;
  border-bottom: 1px solid var(--border);
}

.plan-form {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.form-row {
  display: flex;
  gap: 12px;
}

.plan-input {
  flex: 1;
}

.plan-submit {
  align-self: flex-start;
  margin-top: 4px;
  padding: 12px 36px;
}

/* 数据卡片行 */
.stats-row {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 14px;
  margin-bottom: 20px;
}

.stat-card {
  background: var(--bg-card);
  border-radius: var(--radius-md);
  padding: 18px;
  display: flex;
  align-items: center;
  gap: 12px;
  box-shadow: 0 1px 8px rgba(0, 0, 0, 0.03);
}

.stat-icon {
  font-size: 24px;
}

.stat-value {
  font-family: var(--font-display);
  font-size: 20px;
  color: var(--text-primary);
  font-weight: 600;
}

.stat-name {
  font-size: 12px;
  color: var(--text-muted);
}

/* 热门目的地 */
.section-card {
  background: var(--bg-card);
  border-radius: var(--radius-lg);
  padding: 24px 28px;
  margin-bottom: 20px;
  box-shadow: 0 2px 16px rgba(0, 0, 0, 0.04);
}

.city-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}

.city-tag {
  padding: 8px 20px;
  background: var(--bg-page);
  border: 1px solid var(--border);
  border-radius: 20px;
  font-size: 14px;
  color: var(--text-secondary);
  cursor: pointer;
  transition: all 0.2s;
}

.city-tag:hover {
  border-color: var(--accent);
  color: var(--accent);
  background: var(--accent-bg);
}

/* 结果占位 */
.result-placeholder {
  text-align: center;
  padding: 48px 20px;
  color: var(--text-muted);
  font-size: 14px;
  background: var(--bg-card);
  border-radius: var(--radius-lg);
  border: 2px dashed var(--border-strong);
}
</style>
