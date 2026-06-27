# Phase 1: 前端骨架 + A1 柔和晨雾设计 — 实施计划

> **对于 agentic workers:** 使用 superpowers:subagent-driven-development 或 superpowers:executing-plans 按任务执行。步骤用 checkbox (`- [ ]`) 追踪。

**目标：** 用 A1 柔和晨雾配色方案重写前端骨架，包含侧边栏导航、四个页面、Element Plus 按需引入。

**架构：** Vue3 + Vite + Element Plus + Vue Router 4，history 模式，左侧深色侧边栏 + 右侧内容区布局。

**技术栈：** Vue 3.5, Vite 8, Element Plus (on-demand), Vue Router 4, @element-plus/icons-vue

## 全局约束

- 配色严格使用 A1 柔和晨雾 token：底色 `#F8F5F0`，侧边栏 `#1A2332`，强调 `#E17055`
- 字体：Georgia 衬线标题 + 系统无衬线正文
- 圆角：卡片/按钮 10-12px，输入框 10px
- Element Plus 按需引入，无需手动 import 组件
- 路由已配置：`/` `/chat` `/footprint` `/profile`

---

### Task 1: 清理模板文件

**文件：**
- 删除：`src/components/HelloWorld.vue`
- 删除：`src/style.css`
- 删除：`src/assets/hero.png`, `src/assets/vite.svg`, `src/assets/vue.svg`

- [ ] **Step 1: 删除不需要的模板文件**

```bash
cd c:/Users/JJD/Desktop/trip-assistant && rm -f src/components/HelloWorld.vue src/style.css src/assets/hero.png src/assets/vite.svg src/assets/vue.svg
```

- [ ] **Step 2: 确认清理**

Run: `ls src/components/` — 应该是空目录

---

### Task 2: 全局样式 — 设计系统 CSS 变量

**文件：**
- 创建：`src/assets/styles/global.css`

**产出：** 全局 CSS 变量 token 系统 + body 重置 + 字体引入

- [ ] **Step 1: 创建样式目录**

```bash
mkdir -p c:/Users/JJD/Desktop/trip-assistant/src/assets/styles
```

- [ ] **Step 2: 写全局样式文件**

```css
/* src/assets/styles/global.css */

/* ===== A1 柔和晨雾 — 设计 Token ===== */
:root {
  --bg-page: #F8F5F0;
  --bg-card: #FFFFFF;
  --bg-sidebar: #1A2332;
  --accent: #E17055;
  --accent-light: #E8896F;
  --accent-bg: rgba(225, 112, 85, 0.08);
  --text-primary: #2D3436;
  --text-secondary: #636E72;
  --text-muted: #B0A89E;
  --border: #F0EBE3;
  --border-strong: #E0D8CC;
  --radius-sm: 6px;
  --radius-md: 10px;
  --radius-lg: 12px;
  --font-display: Georgia, 'Times New Roman', serif;
  --font-body: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
  --sidebar-width: 220px;
}

/* ===== 全局重置 ===== */
*,
*::before,
*::after {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: var(--font-body);
  font-size: 15px;
  line-height: 1.6;
  color: var(--text-secondary);
  background: var(--bg-page);
  -webkit-font-smoothing: antialiased;
}

h1, h2, h3, h4 {
  font-family: var(--font-display);
  color: var(--text-primary);
  line-height: 1.3;
}

a {
  color: var(--accent);
  text-decoration: none;
}

/* ===== 滚动条 ===== */
::-webkit-scrollbar {
  width: 6px;
}
::-webkit-scrollbar-track {
  background: transparent;
}
::-webkit-scrollbar-thumb {
  background: var(--border-strong);
  border-radius: 3px;
}
```

- [ ] **Step 3: 在 main.js 引入**

修改 `src/main.js`，把原来的 `import './style.css'` 换成新路径：

```js
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './assets/styles/global.css'
import App from './App.vue'
import router from './router'

const app = createApp(App)
app.use(ElementPlus)
app.use(router)
app.mount('#app')
```

---

### Task 3: App.vue — 侧边栏布局重写

**文件：**
- 修改：`src/App.vue`

**产出：** A1 风格侧边栏布局 + 渐变地平线签名 + 圆点高亮 + 路由出口

- [ ] **Step 1: 重写 App.vue 模板和样式**

```vue
<script setup>
import { useRoute } from 'vue-router'
import { HomeFilled, ChatDotRound, MapLocation, UserFilled } from '@element-plus/icons-vue'

const route = useRoute()
</script>

<template>
  <div class="app-shell">
    <!-- 侧边导航栏 -->
    <aside class="sidebar">
      <!-- 地平线渐变 -->
      <div class="sidebar-horizon" />

      <!-- Logo -->
      <div class="sidebar-brand">
        <div class="brand-dot" />
        <span>AI 旅游助手</span>
      </div>

      <!-- 导航菜单 -->
      <el-menu
        :default-active="route.path"
        router
        class="sidebar-menu"
      >
        <el-menu-item index="/">
          <el-icon><HomeFilled /></el-icon>
          <span>首页</span>
        </el-menu-item>
        <el-menu-item index="/chat">
          <el-icon><ChatDotRound /></el-icon>
          <span>对话</span>
        </el-menu-item>
        <el-menu-item index="/footprint">
          <el-icon><MapLocation /></el-icon>
          <span>足迹</span>
        </el-menu-item>
        <el-menu-item index="/profile">
          <el-icon><UserFilled /></el-icon>
          <span>我的</span>
        </el-menu-item>
      </el-menu>

      <!-- 底部足迹数据 -->
      <div class="sidebar-footer">
        <div class="footer-stat">
          <div class="stat-num">0</div>
          <div class="stat-label">已点亮城市</div>
        </div>
      </div>
    </aside>

    <!-- 主内容区 -->
    <main class="main-content">
      <router-view />
    </main>
  </div>
</template>

<style scoped>
.app-shell {
  display: flex;
  min-height: 100vh;
  background: var(--bg-page);
}

/* ===== 侧边栏 ===== */
.sidebar {
  width: var(--sidebar-width);
  min-height: 100vh;
  background: var(--bg-sidebar);
  display: flex;
  flex-direction: column;
  position: fixed;
  left: 0;
  top: 0;
  bottom: 0;
  z-index: 100;
}

/* 签名：渐变地平线 */
.sidebar-horizon {
  height: 3px;
  background: linear-gradient(90deg, var(--accent), #F39C12, transparent 80%);
  flex-shrink: 0;
}

/* Logo */
.sidebar-brand {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 24px 20px 20px;
}

.brand-dot {
  width: 8px;
  height: 8px;
  border-radius: 50%;
  background: var(--accent);
  box-shadow: 0 0 8px rgba(225, 112, 85, 0.4);
}

.sidebar-brand span {
  font-family: var(--font-display);
  font-size: 17px;
  color: #E8D5C0;
  white-space: nowrap;
}

/* 导航菜单 */
.sidebar-menu {
  flex: 1;
  background: transparent;
  border-right: none;
  padding: 8px 12px;
}

.sidebar-menu :deep(.el-menu-item) {
  color: rgba(255, 255, 255, 0.45);
  border-radius: var(--radius-md);
  margin-bottom: 2px;
  height: 44px;
  line-height: 44px;
  font-size: 14px;
  transition: all 0.2s;
}

.sidebar-menu :deep(.el-menu-item:hover) {
  color: rgba(255, 255, 255, 0.8);
  background: rgba(255, 255, 255, 0.05);
}

.sidebar-menu :deep(.el-menu-item.is-active) {
  color: var(--accent);
  background: var(--accent-bg);
}

/* 底部统计 */
.sidebar-footer {
  padding: 20px;
  border-top: 1px solid rgba(255, 255, 255, 0.06);
}

.footer-stat {
  text-align: center;
}

.stat-num {
  font-family: var(--font-display);
  font-size: 28px;
  color: var(--accent);
}

.stat-label {
  font-size: 11px;
  color: rgba(255, 255, 255, 0.3);
  margin-top: 2px;
}

/* ===== 主内容区 ===== */
.main-content {
  flex: 1;
  margin-left: var(--sidebar-width);
  min-height: 100vh;
  padding: 32px;
}
</style>
```

---

### Task 4: 首页 — 规划面板 + 热门目的地

**文件：**
- 修改：`src/views/Home.vue`

- [ ] **Step 1: 写首页模板和样式**

```vue
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

    <!-- 生成结果区（后续联动时展开） -->
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
```

---

### Task 5: 足迹页 — 页面占位

**文件：**
- 修改：`src/views/Footprint.vue`（注意：当前还不存在，需创建）

- [ ] **Step 1: 创建足迹页占位**

```vue
<script setup>
</script>

<template>
  <div class="footprint">
    <div class="welcome">
      <h1 class="welcome-title">🌍 我的足迹</h1>
      <p class="welcome-sub">去过的城市，会在地球上点亮</p>
    </div>

    <div class="placeholder-card">
      <div class="placeholder-icon">🌍</div>
      <h3>3D 地球即将上线</h3>
      <p>尽情期待你的足迹遍布星球</p>
    </div>
  </div>
</template>

<style scoped>
.footprint {
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

.placeholder-card {
  background: var(--bg-card);
  border-radius: var(--radius-lg);
  padding: 64px 24px;
  text-align: center;
  box-shadow: 0 2px 16px rgba(0, 0, 0, 0.04);
}

.placeholder-icon {
  font-size: 64px;
  margin-bottom: 16px;
}

.placeholder-card h3 {
  font-size: 20px;
  margin-bottom: 8px;
}

.placeholder-card p {
  color: var(--text-muted);
}
</style>
```

- [ ] **Step 2: 注册足迹路由**

修改 `src/router/index.js`：

```js
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  { path: '/', name: 'home', component: () => import('../views/Home.vue') },
  { path: '/chat', name: 'chat', component: () => import('../views/Chat.vue') },
  { path: '/footprint', name: 'footprint', component: () => import('../views/Footprint.vue') },
  { path: '/profile', name: 'profile', component: () => import('../views/Profile.vue') },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
```

---

### Task 6: 对话页 + 我的页 — 占位重写

**文件：**
- 修改：`src/views/Chat.vue`
- 修改：`src/views/Profile.vue`

- [ ] **Step 1: 重写对话页占位**

```vue
<script setup>
</script>

<template>
  <div class="chat">
    <div class="welcome">
      <h1 class="welcome-title">💬 AI 对话</h1>
      <p class="welcome-sub">你的私人旅游管家，随时解答</p>
    </div>

    <div class="placeholder-card">
      <div class="placeholder-icon">💬</div>
      <h3>AI 对话即将上线</h3>
      <p>流式聊天 + 行程上下文 + 地图卡片嵌入</p>
    </div>
  </div>
</template>

<style scoped>
.chat {
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

.placeholder-card {
  background: var(--bg-card);
  border-radius: var(--radius-lg);
  padding: 64px 24px;
  text-align: center;
  box-shadow: 0 2px 16px rgba(0, 0, 0, 0.04);
}

.placeholder-icon {
  font-size: 64px;
  margin-bottom: 16px;
}

.placeholder-card h3 {
  font-size: 20px;
  margin-bottom: 8px;
}

.placeholder-card p {
  color: var(--text-muted);
}
</style>
```

- [ ] **Step 2: 重写我的页占位**

```vue
<script setup>
</script>

<template>
  <div class="profile">
    <div class="welcome">
      <h1 class="welcome-title">👤 我的</h1>
      <p class="welcome-sub">个人中心，你的旅行记忆</p>
    </div>

    <!-- 个人信息占位 -->
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
```

注意：Profile.vue 需要 import icon：

```vue
<script setup>
import { UserFilled } from '@element-plus/icons-vue'
</script>
```

---

### Task 7: Element Plus 主题覆盖

**文件：**
- 修改：`src/assets/styles/global.css`（追加内容）

**产出：** 覆盖 Element Plus 默认主题色为 `#E17055`

- [ ] **Step 1: 在 global.css 末尾追加 Element Plus 变量覆盖**

```css
/* ===== Element Plus 主题覆盖 ===== */
:root {
  --el-color-primary: var(--accent);
  --el-color-primary-light-3: var(--accent-light);
  --el-border-radius-base: var(--radius-md);
  --el-border-radius-round: 20px;
  --el-font-size-base: 15px;
  --el-font-family: var(--font-body);
}

/* 按钮 */
.el-button--primary {
  --el-button-bg-color: linear-gradient(90deg, var(--accent), var(--accent-light));
  --el-button-border-color: transparent;
}

/* 输入框 */
.el-input__wrapper {
  background: var(--bg-page);
  border-radius: var(--radius-md);
  box-shadow: none;
  border: 1px solid var(--border);
}
```

---

### Task 8: 构建验证

- [ ] **Step 1: 运行构建**

```bash
cd c:/Users/JJD/Desktop/trip-assistant && npx vite build
```

- [ ] **Step 2: 检查输出**

确认无报错，输出包含 `Home-*.js` `Chat-*.js` `Footprint-*.js` `Profile-*.js` 四个分块。

- [ ] **Step 3: 启动开发服务器验证**

```bash
cd c:/Users/JJD/Desktop/trip-assistant && npm run dev
```

打开 `http://localhost:5173/`，检查：
- 侧边栏深色 + 渐变地平线
- 四个页面能正常切换
- 首页表单和卡片正确显示
- 配色与 A1 设计一致

---

## 自检

- [x] 每个任务有具体文件路径
- [x] 每个步骤有完整代码
- [x] CSS 变量覆盖风格统一
- [x] 四个页面 + 一个布局
- [x] A1 柔和晨雾 token 贯穿全局
