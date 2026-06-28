<script setup>
</script>

<template>
  <div class="profile">
    <van-nav-bar title="我的" fixed />

    <div class="content">
      <!-- 个人信息 -->
      <div class="profile-header">
        <div class="avatar">
          <van-icon name="user-o" size="28" />
        </div>
        <div class="profile-text">
          <h3>旅行者</h3>
          <p>登录后解锁更多功能</p>
        </div>
        <van-button type="primary" round size="small">登录 / 注册</van-button>
      </div>

      <!-- 功能菜单 -->
      <van-cell-group inset>
        <van-cell title="我的行程" icon="notes-o" is-link />
        <van-cell title="历史会话" icon="chat-o" is-link />
        <van-cell title="浏览城市" icon="location-o" is-link />
        <van-cell title="成就徽章" icon="medal-o" is-link />
        <van-cell title="设置" icon="setting-o" is-link />
      </van-cell-group>

      <!-- 足迹数据 -->
      <div class="footprint-preview">
        <div class="fp-left">
          <div class="fp-num">0</div>
          <div class="fp-label">已点亮城市</div>
        </div>
        <div class="fp-right">
          <div class="fp-num">0</div>
          <div class="fp-label">历史行程</div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.profile {
  min-height: 100vh;
  background: var(--bg-page);
}

.content {
  padding-top: 46px;
  padding-bottom: 20px;
}

/* 个人信息 */
.profile-header {
  display: flex;
  align-items: center;
  gap: 14px;
  padding: 20px 16px;
  margin: 12px 12px 16px;
  background: var(--bg-card);
  border-radius: var(--radius-lg);
}

.avatar {
  width: 56px;
  height: 56px;
  border-radius: 50%;
  background: linear-gradient(135deg, var(--accent-light), var(--accent));
  display: flex;
  align-items: center;
  justify-content: center;
  color: #fff;
  flex-shrink: 0;
}

.profile-text {
  flex: 1;
}

.profile-text h3 {
  font-size: 17px;
  font-weight: 600;
}

.profile-text p {
  color: var(--text-muted);
  font-size: 13px;
  margin-top: 2px;
}

/* 菜单 */
.van-cell-group {
  margin-bottom: 16px;
}

/* 足迹预览 */
.footprint-preview {
  display: flex;
  margin: 0 12px;
  gap: 12px;
}

.fp-left,
.fp-right {
  flex: 1;
  background: var(--bg-card);
  border-radius: var(--radius-md);
  padding: 18px 16px;
  text-align: center;
}

.fp-num {
  font-family: var(--font-display);
  font-size: 32px;
  color: var(--accent);
  font-weight: 600;
}

.fp-label {
  font-size: 12px;
  color: var(--text-muted);
  margin-top: 4px;
}
</style>
