<script setup lang="ts">
import { ref } from 'vue'
import {
  Search,
  Plus,
  Filter,
  Edit,
  Delete,
  Collection,
  OfficeBuilding,
  InfoFilled,
  More
} from '@element-plus/icons-vue'
import LibraryDetail from './LibraryDetail.vue'

interface Library {
  id: number
  libraryName: string
  level: number
  deptName: string
  remark: string
}

const libraries = ref<Library[]>([
  { id: 1, libraryName: 'Critical Blacklist', level: 1, deptName: 'Security Command Center', remark: 'Highest priority monitoring for restricted personnel' },
  { id: 2, libraryName: 'Regional Suspicious', level: 2, deptName: 'North District Police', remark: 'Frequent offenders in the downtown area' },
  { id: 3, libraryName: 'VIP Service List', level: 3, deptName: 'Customer Experience', remark: 'High-value customers for greeting alerts' },
  { id: 4, libraryName: 'Employee Records', level: 3, deptName: 'Human Resources', remark: 'Access control and attendance verification' },
  { id: 5, libraryName: 'Former Staff (Banned)', level: 2, deptName: 'Site Management', remark: 'Restricted access for terminated employees' },
  { id: 6, libraryName: 'Delivery Whitelist', level: 3, deptName: 'Logistics', remark: 'Verified delivery personnel for dock access' }
])

const selectedLibrary = ref<Library | null>(null)

const getLevelConfig = (level: number) => {
  switch (level) {
    case 1: return { label: 'CRITICAL', color: '#ef4444', bg: 'rgba(239, 68, 68, 0.15)', shadow: '0 0 15px rgba(239, 68, 68, 0.3)' }
    case 2: return { label: 'IMPORTANT', color: '#f59e0b', bg: 'rgba(245, 158, 11, 0.15)', shadow: '0 0 15px rgba(245, 158, 11, 0.3)' }
    case 3: return { label: 'STANDARD', color: '#38bdf8', bg: 'rgba(56, 189, 248, 0.15)', shadow: '0 0 15px rgba(56, 189, 248, 0.3)' }
    default: return { label: 'UNKNOWN', color: '#94a3b8', bg: 'rgba(148, 163, 184, 0.15)', shadow: 'none' }
  }
}

const handleModify = (lib: Library) => {
  console.log('Modify', lib)
}

const handleDelete = (lib: Library) => {
  console.log('Delete', lib)
}
</script>

<template>
  <div class="library-manager-layout">
    <!-- Drill-down view -->
    <LibraryDetail 
      v-if="selectedLibrary" 
      :library-id="selectedLibrary.id" 
      :library-name="selectedLibrary.libraryName"
      @back="selectedLibrary = null"
    />

    <!-- Main Grid View -->
    <template v-else>
      <!-- Page Header -->
      <header class="page-header">
        <div class="header-left">
          <h1 class="title">Identity Libraries</h1>
          <p class="subtitle">Management center for facial recognition target databases</p>
        </div>
        <div class="header-right">
          <div class="stats-overview">
            <div class="stat-box">
              <span class="label">Total Libraries</span>
              <span class="value">24</span>
            </div>
            <div class="divider"></div>
            <div class="stat-box">
              <span class="label">Total Targets</span>
              <span class="value">12.8k</span>
            </div>
          </div>
          <button class="btn-create">
            <el-icon><Plus /></el-icon> Create Library
          </button>
        </div>
      </header>

      <!-- Toolbar -->
      <div class="toolbar">
        <div class="search-box">
          <el-icon class="icon"><Search /></el-icon>
          <input type="text" placeholder="Search libraries by name..." />
        </div>
        <div class="filters">
          <select class="cyber-select">
            <option>All Levels</option>
            <option>Critical</option>
            <option>Important</option>
            <option>Standard</option>
          </select>
          <button class="btn-filter">
            <el-icon><Filter /></el-icon> Filters
          </button>
        </div>
      </div>

      <!-- Library Grid -->
      <div class="library-grid">
        <div 
          v-for="lib in libraries" 
          :key="lib.id" 
          class="lib-card"
          @click="selectedLibrary = lib"
        >
          <div class="card-glow"></div>
          <div class="card-content">
            <div class="card-header">
              <div class="icon-wrap" :style="{ color: getLevelConfig(lib.level).color }">
                <el-icon><Collection /></el-icon>
              </div>
              <div class="title-wrap">
                <h3 class="lib-name">{{ lib.libraryName }}</h3>
                <div class="lib-id">LIB-ID: 00{{ lib.id }}</div>
              </div>
              <div class="level-badge" :style="{ 
                color: getLevelConfig(lib.level).color,
                background: getLevelConfig(lib.level).bg,
                boxShadow: getLevelConfig(lib.level).shadow
              }">
                {{ getLevelConfig(lib.level).label }}
              </div>
            </div>

            <div class="card-body">
              <div class="info-row">
                <el-icon><OfficeBuilding /></el-icon>
                <span>{{ lib.deptName }}</span>
              </div>
              <div class="info-row remark">
                <el-icon><InfoFilled /></el-icon>
                <span>{{ lib.remark }}</span>
              </div>
            </div>

            <div class="card-footer">
              <div class="action-group">
                <button class="btn-action edit" @click.stop="handleModify(lib)">
                  <el-icon><Edit /></el-icon> Modify
                </button>
                <button class="btn-action delete" @click.stop="handleDelete(lib)">
                  <el-icon><Delete /></el-icon>
                </button>
              </div>
              <button class="btn-more">
                <el-icon><More /></el-icon>
              </button>
            </div>
          </div>
        </div>
      </div>

      <!-- Pagination -->
      <div class="cyber-pagination">
        <el-pagination
          layout="prev, pager, next"
          :total="100"
          background
        />
      </div>
    </template>
  </div>
</template>

<style scoped lang="scss">
.library-manager-layout {
  padding: 24px;
  min-height: 100%;
  display: flex;
  flex-direction: column;
  background: transparent;
  color: #e2e8f0;
}

/* Header */
.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 32px;

  .title { font-size: 28px; font-weight: 800; color: #fff; margin: 0; letter-spacing: -0.5px; }
  .subtitle { font-size: 14px; color: #94a3b8; margin: 4px 0 0; }

  .header-right { display: flex; gap: 32px; align-items: center; }
}

.stats-overview {
  display: flex;
  align-items: center;
  gap: 24px;
  background: rgba(15, 23, 42, 0.3);
  border: 1px solid rgba(148, 163, 184, 0.1);
  padding: 10px 24px;
  border-radius: 12px;

  .stat-box {
    display: flex;
    flex-direction: column;
    .label { font-size: 11px; color: #64748b; text-transform: uppercase; font-weight: 700; }
    .value { font-size: 18px; color: #fff; font-weight: 800; font-family: 'Inter', sans-serif; }
  }
  .divider { width: 1px; height: 30px; background: rgba(148, 163, 184, 0.1); }
}

.btn-create {
  background: linear-gradient(135deg, #0ea5e9, #38bdf8);
  color: #fff;
  border: none;
  border-radius: 10px;
  padding: 12px 24px;
  font-weight: 700;
  display: flex;
  align-items: center;
  gap: 8px;
  cursor: pointer;
  box-shadow: 0 4px 15px rgba(14, 165, 233, 0.4);
  transition: all 0.3s;
  &:hover { transform: translateY(-2px); box-shadow: 0 8px 25px rgba(14, 165, 233, 0.6); }
}

/* Toolbar */
.toolbar {
  display: flex;
  justify-content: space-between;
  margin-bottom: 32px;
  gap: 24px;
}

.search-box {
  flex: 1;
  position: relative;
  max-width: 400px;
  .icon { position: absolute; left: 16px; top: 50%; transform: translateY(-50%); color: #64748b; }
  input {
    width: 100%;
    background: rgba(15, 23, 42, 0.6);
    border: 1px solid rgba(148, 163, 184, 0.1);
    border-radius: 12px;
    padding: 12px 16px 12px 48px;
    color: #fff;
    font-size: 14px;
    outline: none;
    transition: 0.2s;
    &:focus { border-color: #38bdf8; background: rgba(15, 23, 42, 0.8); }
  }
}

.filters {
  display: flex;
  gap: 12px;
}

.cyber-select {
  background: rgba(15, 23, 42, 0.6);
  border: 1px solid rgba(148, 163, 184, 0.1);
  color: #fff;
  border-radius: 10px;
  padding: 0 16px;
  font-size: 13px;
  outline: none;
  cursor: pointer;
  &:hover { border-color: #38bdf8; }
}

.btn-filter {
  background: rgba(30, 41, 59, 0.5);
  border: 1px solid rgba(148, 163, 184, 0.15);
  color: #cbd5e1;
  padding: 0 16px;
  border-radius: 10px;
  display: flex;
  align-items: center;
  gap: 8px;
  cursor: pointer;
  &:hover { border-color: #38bdf8; color: #fff; }
}

/* Grid & Cards */
.library-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(270px, 1fr)); /* Narrower columns to easily fit 4 per row */
  gap: 24px;
}

.lib-card {
  position: relative;
  background: rgba(30, 41, 59, 0.4);
  border-radius: 20px;
  border: 1px solid rgba(148, 163, 184, 0.1);
  overflow: hidden;
  transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);
  
  &:hover {
    transform: translateY(-8px);
    background: rgba(30, 41, 59, 0.6);
    border-color: rgba(56, 189, 248, 0.4);
    box-shadow: 0 12px 40px rgba(0, 0, 0, 0.4);
    
    .card-glow { opacity: 1; }
  }
}

.card-glow {
  position: absolute;
  top: 0; left: 0; width: 100%; height: 100%;
  background: radial-gradient(circle at top right, rgba(56, 189, 248, 0.15), transparent 60%);
  opacity: 0;
  transition: 0.4s;
  pointer-events: none;
}

.card-content { padding: 24px; }

.card-header {
  display: flex;
  align-items: flex-start;
  gap: 16px;
  margin-bottom: 20px;

  .icon-wrap {
    width: 48px;
    height: 48px;
    background: rgba(15, 23, 42, 0.4);
    border-radius: 12px;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 24px;
    border: 1px solid rgba(148, 163, 184, 0.1);
  }

  .title-wrap {
    flex: 1;
    .lib-name { margin: 0; font-size: 18px; font-weight: 700; color: #f8fafc; }
    .lib-id { font-size: 11px; color: #64748b; font-family: monospace; margin-top: 2px; }
  }

  .level-badge {
    font-size: 10px;
    font-weight: 800;
    padding: 4px 10px;
    border-radius: 6px;
    letter-spacing: 0.5px;
  }
}

.card-body {
  margin-bottom: 24px;
  display: flex;
  flex-direction: column;
  gap: 12px;

  .info-row {
    display: flex;
    align-items: center;
    gap: 10px;
    font-size: 13px;
    color: #94a3b8;
    .el-icon { color: #38bdf8; font-size: 16px; }
    
    &.remark {
      align-items: flex-start;
      margin-top: 4px;
      .el-icon { color: #64748b; }
      span { 
        line-height: 1.5;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        overflow: hidden;
      }
    }
  }
}

.card-footer {
  padding-top: 20px;
  border-top: 1px solid rgba(148, 163, 184, 0.08);
  display: flex;
  justify-content: space-between;
  align-items: center;

  .action-group { display: flex; gap: 8px; }
}

.btn-action {
  padding: 8px 16px;
  border-radius: 8px;
  border: 1px solid rgba(148, 163, 184, 0.1);
  background: rgba(15, 23, 42, 0.3);
  color: #94a3b8;
  font-size: 13px;
  font-weight: 600;
  display: flex;
  align-items: center;
  gap: 6px;
  cursor: pointer;
  transition: 0.2s;

  &:hover { background: rgba(56, 189, 248, 0.1); border-color: #38bdf8; color: #fff; }
  &.delete:hover { background: rgba(239, 68, 68, 0.1); border-color: #ef4444; color: #ef4444; }
}

.btn-more {
  background: none;
  border: none;
  color: #475569;
  cursor: pointer;
  padding: 4px;
  display: flex;
  align-items: center;
  &:hover { color: #fff; }
}

/* Pagination */
.cyber-pagination {
  margin-top: 40px;
  display: flex;
  justify-content: center;
  padding-bottom: 40px;

  :deep(.el-pagination) {
    --el-pagination-bg-color: rgba(15, 23, 42, 0.5);
    --el-pagination-text-color: #94a3b8;
    --el-pagination-button-color: #94a3b8;
    --el-pagination-hover-color: #38bdf8;
    
    .el-pager li {
      border: 1px solid rgba(148, 163, 184, 0.1);
      border-radius: 8px;
      margin: 0 4px;
      &.is-active {
        background: rgba(14, 165, 233, 0.2);
        border-color: #38bdf8;
        color: #38bdf8;
      }
    }
  }
}
</style>
