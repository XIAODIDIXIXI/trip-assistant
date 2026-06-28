<script setup>
import { useRoute } from 'vue-router'
import { HomeFilled, ChatDotRound, MapLocation, UserFilled } from '@element-plus/icons-vue'

const route = useRoute()
</script>

<template>
  <div class="app-shell">
    <!-- 侧边导航栏 -->
    <aside class="sidebar">
      <!-- 签名：渐变地平线 -->
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

      <!-- 底部足迹统计 -->
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
