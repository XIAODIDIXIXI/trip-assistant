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
