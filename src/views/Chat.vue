<script setup>
</script>

<template>
  <div class="chat">
    <van-nav-bar title="AI 对话" fixed />

    <div class="content">
      <div class="placeholder-card">
        <div class="placeholder-icon">💬</div>
        <h3>AI 对话即将上线</h3>
        <p>流式聊天 + 行程上下文 + 地图嵌入</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.chat {
  min-height: 100vh;
}

.content {
  padding-top: 46px;
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
}

.placeholder-card {
  text-align: center;
  padding: 48px 24px;
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
  font-size: 14px;
}
</style>
