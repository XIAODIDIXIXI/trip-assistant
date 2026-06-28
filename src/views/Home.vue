<script setup>
import { reactive, ref, computed } from 'vue'

// 表单数据
const formData = reactive({
  city: '',
  days: 3,
  budget: 3000,
  travelType: 'couple',
  preferences: 'nature',
})

// 解析行程 JSON 内容
const parsedContent = computed(() => {
  if (!result.value?.content) return null
  try {
    const c = JSON.parse(result.value.content)
    if (c?.schedule?.length) return c
    return null
  } catch {
    return null
  }
})

// 出行类型选项
const travelTypes = [
  { label: '👨‍👩‍👧 家庭', value: 'family' },
  { label: '💑 情侣', value: 'couple' },
  { label: '🧑‍💻 独自', value: 'solo' },
  { label: '👥 朋友', value: 'friend' },
]

// 兴趣偏好
const prefs = [
  { label: '🍜 美食', value: 'food' },
  { label: '🏔️ 自然', value: 'nature' },
  { label: '🏛️ 人文', value: 'culture' },
  { label: '🛍️ 购物', value: 'shopping' },
  { label: '🚴 户外', value: 'outdoor' },
]

// 热门城市
const hotCities = ['北京', '上海', '成都', '杭州', '西安', '三亚', '大理', '桂林']

// 行程结果
const result = ref(null)
const loading = ref(false)
const error = ref('')

// 提交生成行程
const handleSubmit = async () => {
  if (!formData.city.trim()) {
    error.value = '请输入目的地'
    return
  }

  loading.value = true
  error.value = ''
  result.value = null

  try {
    const res = await fetch('http://localhost:8080/api/trips/generate', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        city: formData.city,
        days: formData.days,
        budget: formData.budget,
        travelType: formData.travelType,
        preferences: formData.preferences,
      }),
    })

    if (!res.ok) throw new Error('请求失败: ' + res.status)

    const json = await res.json()
    result.value = json.data
  } catch (e) {
    error.value = '生成失败：' + e.message
  } finally {
    loading.value = false
  }
}

// 点击热门城市自动填入
const selectCity = (city) => {
  formData.city = city
}

// 切换出行类型
const toggleType = (type) => {
  formData.travelType = type
}

// 切换偏好
const togglePref = (pref) => {
  formData.preferences = pref
}
</script>

<template>
  <div class="home">
    <van-nav-bar title="AI 旅游助手" fixed />

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
          v-model="formData.city"
          label="目的地"
          placeholder="请选择或输入目的地"
          clearable
        />
        <van-field
          v-model.number="formData.days"
          label="天数"
          placeholder="请输入天数"
          type="digit"
        />
        <van-field
          v-model.number="formData.budget"
          label="预算（元）"
          placeholder="请输入预算"
          type="number"
        />

        <!-- 热门城市快捷选择 -->
        <div class="form-section">
          <div class="form-label">🔥 热门城市速选</div>
          <div class="tag-row">
            <span
              v-for="city in hotCities"
              :key="city"
              class="city-quick"
              :class="{ active: formData.city === city }"
              @click="selectCity(city)"
            >{{ city }}</span>
          </div>
        </div>

        <!-- 出行类型 -->
        <div class="form-section">
          <div class="form-label">出行类型</div>
          <div class="tag-row">
            <span
              v-for="t in travelTypes"
              :key="t.value"
              class="tag"
              :class="{ 'tag-active': formData.travelType === t.value }"
              @click="toggleType(t.value)"
            >{{ t.label }}</span>
          </div>
        </div>

        <!-- 兴趣偏好 -->
        <div class="form-section">
          <div class="form-label">兴趣偏好</div>
          <div class="tag-row">
            <span
              v-for="p in prefs"
              :key="p.value"
              class="tag"
              :class="{ 'tag-active': formData.preferences === p.value }"
              @click="togglePref(p.value)"
            >{{ p.label }}</span>
          </div>
        </div>

        <!-- 错误提示 -->
        <div v-if="error" class="error-msg">{{ error }}</div>

        <van-button
          type="primary"
          block
          round
          size="large"
          :loading="loading"
          @click="handleSubmit"
        >
          🚀 生成行程
        </van-button>
      </div>
    </div>

    <!-- 行程结果 -->
    <div v-if="result" class="card result-card">
      <h2 class="card-title">📋 {{ result.city }} {{ result.days }}日行程</h2>

      <!-- 解析 JSON 行程内容 -->
      <div v-if="result.content" class="schedule-list">
        <template v-if="parsedContent">
          <div
            v-for="day in parsedContent.schedule"
            :key="day.day"
            class="day-block"
          >
            <div class="day-title">Day {{ day.day }}</div>
            <div class="day-items">
              <div v-for="(item, i) in day.items" :key="i" class="day-item">
                <span class="item-time">{{ item.time }}</span>
                <span class="item-activity">{{ item.activity }}</span>
              </div>
            </div>
          </div>
        </template>
        <div v-else class="raw-content">
          <p>行程内容：</p>
          <pre>{{ result.content }}</pre>
        </div>
      </div>
    </div>

    <!-- 结果占位 -->
    <div v-else-if="!loading" class="result-placeholder">
      <p>输入目的地和天数，点击"生成行程"开始规划 ✈️</p>
    </div>
  </div>
</template>

<style scoped>
.home {
  padding-bottom: 20px;
}

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

.city-quick {
  padding: 6px 14px;
  background: var(--bg-page);
  border: 1px solid var(--border);
  border-radius: 20px;
  font-size: 13px;
  color: var(--text-secondary);
  cursor: pointer;
}

.city-quick.active {
  border-color: var(--accent);
  color: var(--accent);
  background: var(--accent-bg);
}

.error-msg {
  color: #e74c3c;
  font-size: 13px;
  text-align: center;
  padding: 4px 0;
}

/* 行程结果 */
.result-card {
  border-left: 3px solid var(--accent);
}

.schedule-list .day-block {
  margin-bottom: 16px;
}

.day-title {
  font-family: var(--font-display);
  font-size: 16px;
  color: var(--accent);
  font-weight: 600;
  margin-bottom: 8px;
}

.day-items {
  display: flex;
  flex-direction: column;
  gap: 6px;
}

.day-item {
  display: flex;
  gap: 10px;
  padding: 10px 14px;
  background: var(--bg-page);
  border-radius: var(--radius-sm);
}

.item-time {
  font-size: 13px;
  color: var(--text-muted);
  flex-shrink: 0;
  width: 36px;
}

.item-activity {
  font-size: 14px;
  color: var(--text-primary);
}

.raw-content pre {
  white-space: pre-wrap;
  font-size: 12px;
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
