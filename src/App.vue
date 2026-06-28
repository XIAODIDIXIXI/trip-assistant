<template>
  <div class="app-shell">
    <!-- 主内容区 -->
    <div class="main-content">
      <router-view />
    </div>

    <!-- 底部导航栏 -->
    <van-tabbar route>
      <van-tabbar-item to="/" icon="home-o">首页</van-tabbar-item>
      <van-tabbar-item to="/chat" icon="chat-o">对话</van-tabbar-item>
      <van-tabbar-item to="/footprint" icon="location-o">足迹</van-tabbar-item>
      <van-tabbar-item to="/profile" icon="user-o">我的</van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<style scoped>
.app-shell {
  min-height: 100vh;
  background: var(--bg-page);
  padding-bottom: 50px; /* 给 tabbar 留空间 */
}

.main-content {
  min-height: 100vh;
}
</style>
