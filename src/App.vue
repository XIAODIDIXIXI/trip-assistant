<script setup>
import { useRoute } from 'vue-router'
import { HomeFilled, ChatDotRound, UserFilled } from '@element-plus/icons-vue'

const route = useRoute()
</script>

<template>
  <el-container class="layout">
    <!-- 侧边导航栏 -->
    <el-aside width="200px" class="sidebar">
      <div class="logo">AI 旅游助手</div>
      <el-menu
        :default-active="route.path"
        router
        background-color="#001529"
        text-color="#ffffffb3"
        active-text-color="#fff"
      >
        <el-menu-item index="/">
          <el-icon><HomeFilled /></el-icon>
          <span>首页</span>
        </el-menu-item>
        <el-menu-item index="/chat">
          <el-icon><ChatDotRound /></el-icon>
          <span>AI 对话</span>
        </el-menu-item>
        <el-menu-item index="/profile">
          <el-icon><UserFilled /></el-icon>
          <span>我的</span>
        </el-menu-item>
      </el-menu>
    </el-aside>

    <!-- 主内容区 -->
    <el-main>
      <router-view />
    </el-main>
  </el-container>
</template>

<style>
/* 全局布局 */
body {
  margin: 0;
}
</style>

<style scoped>
.layout {
  min-height: 100vh;
}

.sidebar {
  background-color: #001529;
  min-height: 100vh;
}

.logo {
  color: #fff;
  font-size: 18px;
  font-weight: 600;
  text-align: center;
  padding: 20px 0;
  border-bottom: 1px solid #ffffff1a;
}

.el-main {
  background-color: #f0f2f5;
}
</style>
