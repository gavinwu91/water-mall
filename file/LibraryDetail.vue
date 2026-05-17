<script setup lang="ts">
import { computed, ref, watch } from 'vue'
import {
  ArrowLeft,
  Search,
  User,
  Male,
  Female,
  Postcard,
  Collection,
  DataAnalysis,
  WarningFilled,
  View,
  CircleCheckFilled,
  Edit,
  Delete
} from '@element-plus/icons-vue'

interface LibraryPerson {
  id: number
  name: string
  gender: 'Male' | 'Female'
  idNo: string
  risk: 'Critical' | 'Important' | 'Standard'
  source: string
  lastSeen: string
  avatarUrl: string
}

const props = defineProps<{
  libraryId: number
  libraryName: string
}>()

defineEmits<{
  (event: 'back'): void
}>()

const searchText = ref('')
const riskFilter = ref('All')
const currentPage = ref(1)
const pageSize = ref(8)

const people = ref<LibraryPerson[]>([
  { id: 1, name: 'Ahmed Al Balushi', gender: 'Male', idNo: 'OMN-7845-2190', risk: 'Critical', source: 'Airport Entry Camera', lastSeen: '2026-05-14 10:28', avatarUrl: 'https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 2, name: 'Fatma Al Rashdi', gender: 'Female', idNo: 'OMN-5621-9044', risk: 'Important', source: 'Central Market Gate', lastSeen: '2026-05-13 18:42', avatarUrl: 'https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 3, name: 'Khalid Al Harthy', gender: 'Male', idNo: 'OMN-3380-6712', risk: 'Standard', source: 'Harbor District', lastSeen: '2026-05-13 09:16', avatarUrl: 'https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 4, name: 'Mariam Al Siyabi', gender: 'Female', idNo: 'OMN-1197-4580', risk: 'Important', source: 'North Checkpoint', lastSeen: '2026-05-12 22:07', avatarUrl: 'https://images.unsplash.com/photo-1544005313-94ddf0286df2?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 5, name: 'Omar Al Zadjali', gender: 'Male', idNo: 'OMN-9072-3318', risk: 'Critical', source: 'Mall Entrance B', lastSeen: '2026-05-12 14:35', avatarUrl: 'https://images.unsplash.com/photo-1492562080023-ab3db95bfbce?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 6, name: 'Noor Al Kindi', gender: 'Female', idNo: 'OMN-4206-8159', risk: 'Standard', source: 'Residential Zone', lastSeen: '2026-05-11 07:50', avatarUrl: 'https://images.unsplash.com/photo-1524504388940-b1c1722653e1?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 7, name: 'Salim Al Farsi', gender: 'Male', idNo: 'OMN-6732-0041', risk: 'Important', source: 'City Command Node', lastSeen: '2026-05-10 21:14', avatarUrl: 'https://images.unsplash.com/photo-1519345182560-3f2917c472ef?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 8, name: 'Aisha Al Maqbali', gender: 'Female', idNo: 'OMN-2457-8830', risk: 'Standard', source: 'Business Park', lastSeen: '2026-05-10 11:22', avatarUrl: 'https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 9, name: 'Said Al Said', gender: 'Male', idNo: 'OMN-1234-5678', risk: 'Standard', source: 'Subway Station A', lastSeen: '2026-05-09 16:30', avatarUrl: 'https://images.unsplash.com/photo-1500648767791-00dcc994a43e?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 10, name: 'Muna Al Rawahi', gender: 'Female', idNo: 'OMN-8765-4321', risk: 'Critical', source: 'West Highway Toll', lastSeen: '2026-05-09 08:15', avatarUrl: 'https://images.unsplash.com/photo-1494790108377-be9c29b29330?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 11, name: 'Hamad Al Hinai', gender: 'Male', idNo: 'OMN-4567-8901', risk: 'Important', source: 'Port Security East', lastSeen: '2026-05-08 19:40', avatarUrl: 'https://images.unsplash.com/photo-1513956589380-bad6acb9b9d4?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 12, name: 'Zahra Al Ajmi', gender: 'Female', idNo: 'OMN-9876-5432', risk: 'Standard', source: 'Financial District', lastSeen: '2026-05-08 11:05', avatarUrl: 'https://images.unsplash.com/photo-1548142813-c348350df52b?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 13, name: 'Fahad Al Busaidi', gender: 'Male', idNo: 'OMN-2345-6789', risk: 'Standard', source: 'Metro Platform 2', lastSeen: '2026-05-07 22:50', avatarUrl: 'https://images.unsplash.com/photo-1489980508314-941910ded1f4?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 14, name: 'Laila Al Maskari', gender: 'Female', idNo: 'OMN-7654-3210', risk: 'Important', source: 'Main Square Cam 4', lastSeen: '2026-05-07 14:12', avatarUrl: 'https://images.unsplash.com/photo-1554151228-14d9def656e4?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 15, name: 'Yousef Al Amri', gender: 'Male', idNo: 'OMN-3456-7890', risk: 'Critical', source: 'Border Post North', lastSeen: '2026-05-06 09:33', avatarUrl: 'https://images.unsplash.com/photo-1542909168-82c3e7fdca5c?auto=format&fit=crop&w=360&h=460&q=80' },
  { id: 16, name: 'Sara Al Shabibi', gender: 'Female', idNo: 'OMN-6543-2109', risk: 'Standard', source: 'Convention Center', lastSeen: '2026-05-06 02:44', avatarUrl: 'https://images.unsplash.com/photo-1567532939604-b6b5b0db2604?auto=format&fit=crop&w=360&h=460&q=80' }
])

const filteredPeople = computed(() => {
  const keyword = searchText.value.trim().toLowerCase()

  return people.value.filter(person => {
    const matchesRisk = riskFilter.value === 'All' || person.risk === riskFilter.value
    const matchesKeyword = !keyword ||
      person.name.toLowerCase().includes(keyword) ||
      person.idNo.toLowerCase().includes(keyword)

    return matchesRisk && matchesKeyword
  })
})

const paginatedPeople = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value
  const end = start + pageSize.value
  return filteredPeople.value.slice(start, end)
})

watch([searchText, riskFilter], () => {
  currentPage.value = 1
})

const totalCritical = computed(() => people.value.filter(person => person.risk === 'Critical').length)
const totalImportant = computed(() => people.value.filter(person => person.risk === 'Important').length)

const handleEdit = (person: LibraryPerson) => {
  console.log('Edit person:', person)
}

const handleDelete = (person: LibraryPerson) => {
  console.log('Delete person:', person)
}

const getRiskClass = (risk: LibraryPerson['risk']) => risk.toLowerCase()
</script>

<template>
  <div class="library-detail-layout">
    <aside class="library-side">
      <button class="back-btn" @click="$emit('back')" title="Back to Libraries">
        <el-icon><ArrowLeft /></el-icon>
      </button>

      <section class="library-profile">
        <div class="profile-top">
          <div class="hero-icon">
            <el-icon><Collection /></el-icon>
          </div>
          <span class="online-dot">ONLINE</span>
        </div>
        <div class="library-code">LIB-{{ String(props.libraryId).padStart(4, '0') }}</div>
        <h2>{{ props.libraryName }}</h2>
        <p>Active face library personnel roster, used by surveillance tasks and alarm matching.</p>
        <div class="profile-tags">
          <span>Face Library</span>
          <span>Encrypted</span>
        </div>
      </section>

      <section class="side-card metric-panel">
        <div class="panel-title">
          <el-icon><DataAnalysis /></el-icon>
          Library Status
        </div>
        <div class="metric-row">
          <span>Total Persons</span>
          <strong>{{ people.length }}</strong>
        </div>
        <div class="metric-row danger">
          <span>Critical</span>
          <strong>{{ totalCritical }}</strong>
        </div>
        <div class="metric-row warn">
          <span>Important</span>
          <strong>{{ totalImportant }}</strong>
        </div>
        <div class="metric-row">
          <span>Last Sync</span>
          <strong>10:30</strong>
        </div>
      </section>

      <section class="side-card">
        <div class="panel-title">
          <el-icon><WarningFilled /></el-icon>
          Risk Filter
        </div>
        <button
          v-for="item in ['All', 'Critical', 'Important', 'Standard']"
          :key="item"
          class="risk-filter"
          :class="{ active: riskFilter === item }"
          @click="riskFilter = item"
        >
          <span>{{ item }}</span>
          <em>{{ item === 'All' ? people.length : people.filter(person => person.risk === item).length }}</em>
        </button>
      </section>
    </aside>

    <main class="people-main">
      <header class="people-header">
        <div class="header-search">
          <div class="search-input">
            <el-icon><Search /></el-icon>
            <input v-model="searchText" placeholder="Search by name or certificate number..." />
          </div>
          <div class="result-count">
            <strong>{{ filteredPeople.length }}</strong> records
          </div>
        </div>
      </header>

      <div class="person-grid">
        <article v-for="person in paginatedPeople" :key="person.id" class="person-card" :class="getRiskClass(person.risk)">
          <!-- Floating hover action overlay in top-right corner of card -->
          <div class="card-actions-floating">
            <button class="action-btn edit" @click.stop="handleEdit(person)" title="Edit">
              <el-icon><Edit /></el-icon>
            </button>
            <button class="action-btn delete" @click.stop="handleDelete(person)" title="Delete">
              <el-icon><Delete /></el-icon>
            </button>
          </div>

          <!-- Left Column: Passport Portrait (Dominates left side) -->
          <div class="portrait">
            <img :src="person.avatarUrl" :alt="person.name" />
            <div class="scan-line"></div>
            <span class="photo-label">PHOTO</span>
          </div>
          
          <!-- Right Column: Meta + Compact Fields -->
          <div class="person-info-compact">
            <div class="person-meta">
              <span class="person-index">ID-{{ String(person.id).padStart(4, '0') }}</span>
              <h3 class="person-name" :title="person.name">{{ person.name }}</h3>
              <span class="risk-badge" :class="getRiskClass(person.risk)">{{ person.risk }}</span>
            </div>

            <!-- Details Section (Super Compact) -->
            <div class="field-grid">
              <div class="field-row">
                <el-icon :class="person.gender.toLowerCase()">
                  <Male v-if="person.gender === 'Male'" />
                  <Female v-else />
                </el-icon>
                <span class="label">Gender</span>
                <strong>{{ person.gender }}</strong>
              </div>

              <div class="field-row">
                <el-icon><Postcard /></el-icon>
                <span class="label">ID No.</span>
                <strong :title="person.idNo">{{ person.idNo }}</strong>
              </div>
            </div>

            <!-- Footer Section (Ultra Small Text) -->
            <div class="card-footer-compact">
              <div class="footer-item" :title="'Source: ' + person.source">
                <span>SRC:</span> {{ person.source }}
              </div>
              <div class="footer-item" :title="'Last: ' + person.lastSeen">
                <span>LST:</span> {{ person.lastSeen }}
              </div>
            </div>
          </div>
        </article>
      </div>

      <!-- Pagination Section -->
      <div v-if="filteredPeople.length > pageSize" class="cyber-pagination">
        <el-pagination
          v-model:current-page="currentPage"
          :page-size="pageSize"
          layout="prev, pager, next"
          :total="filteredPeople.length"
          background
        />
      </div>

      <div v-if="!filteredPeople.length" class="empty-state">
        <el-icon><View /></el-icon>
        <h3>No personnel found</h3>
        <p>Adjust the keyword or risk filter to view more records.</p>
      </div>

      <footer class="sync-footer">
        <span><el-icon><CircleCheckFilled /></el-icon> Face templates verified</span>
        <span>Encrypted identity storage</span>
        <span>Updated by Command Center</span>
      </footer>
    </main>
  </div>
</template>

<style scoped lang="scss">
.library-detail-layout {
  height: 100%;
  display: grid;
  grid-template-columns: 300px minmax(0, 1fr);
  gap: 24px;
  color: #e2e8f0;
  margin-top: -24px; /* Counter-act parent padding */
}

.library-side,
.people-main {
  min-width: 0;
  padding-top: 24px; /* Internal alignment */
}

.library-side {
  display: flex;
  flex-direction: column;
  gap: 16px; /* Vertical spacing after back-btn */
}

.back-btn {
  width: 36px;
  height: 36px;
  display: grid;
  place-items: center;
  border: 1px solid rgba(148, 163, 184, 0.16);
  border-radius: 8px;
  background: rgba(15, 23, 42, 0.55);
  color: #cbd5e1;
  font-size: 18px;
  cursor: pointer;
  transition: 0.2s;
  margin-bottom: 0;

  &:hover {
    color: #38bdf8;
    border-color: rgba(56, 189, 248, 0.55);
    background: rgba(56, 189, 248, 0.12);
    transform: translateX(-2px);
  }
}

.side-card,
.library-profile {
  border: 1px solid rgba(148, 163, 184, 0.12);
  border-radius: 16px;
  background: rgba(15, 23, 42, 0.52);
  padding: 18px;
  box-shadow: 0 18px 34px rgba(0, 0, 0, 0.18);
}

.library-profile {
  position: relative;
  overflow: hidden;
  background:
    linear-gradient(160deg, rgba(3, 105, 161, 0.28), rgba(15, 23, 42, 0.86) 52%),
    repeating-linear-gradient(135deg, rgba(56, 189, 248, 0.05) 0 1px, transparent 1px 10px);
  border-color: rgba(56, 189, 248, 0.22);

  &::after {
    content: "";
    position: absolute;
    inset: auto -40px -60px auto;
    width: 150px;
    height: 150px;
    border: 1px solid rgba(56, 189, 248, 0.16);
    border-radius: 50%;
  }

  .profile-top {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 18px;
  }

  .online-dot {
    border: 1px solid rgba(34, 197, 94, 0.28);
    border-radius: 999px;
    background: rgba(34, 197, 94, 0.1);
    color: #86efac;
    padding: 5px 9px;
    font-size: 10px;
    font-weight: 900;
  }

  .hero-icon {
    width: 52px;
    height: 52px;
    display: grid;
    place-items: center;
    border-radius: 14px;
    background: rgba(56, 189, 248, 0.13);
    color: #38bdf8;
    font-size: 25px;
    border: 1px solid rgba(56, 189, 248, 0.25);
  }

  .library-code {
    color: #38bdf8;
    font-family: Consolas, monospace;
    font-size: 12px;
    font-weight: 800;
    margin-bottom: 8px;
  }

  h2 {
    margin: 0;
    color: #f8fafc;
    font-size: 22px;
    line-height: 1.2;
  }

  p {
    margin: 10px 0 0;
    color: #94a3b8;
    font-size: 13px;
    line-height: 1.6;
  }

  .profile-tags {
    display: flex;
    gap: 8px;
    flex-wrap: wrap;
    margin-top: 18px;

    span {
      border: 1px solid rgba(148, 163, 184, 0.14);
      border-radius: 7px;
      background: rgba(2, 6, 23, 0.35);
      color: #cbd5e1;
      padding: 6px 9px;
      font-size: 11px;
      font-weight: 700;
    }
  }
}

.panel-title {
  display: flex;
  align-items: center;
  gap: 8px;
  color: #cbd5e1;
  font-size: 13px;
  font-weight: 800;
  margin-bottom: 14px;

  .el-icon {
    color: #38bdf8;
  }
}

.metric-panel {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.metric-row {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 10px 0;
  border-bottom: 1px solid rgba(148, 163, 184, 0.08);
  color: #94a3b8;
  font-size: 13px;

  &:last-child {
    border-bottom: 0;
  }

  strong {
    color: #f8fafc;
    font-size: 17px;
    font-family: Consolas, monospace;
  }

  &.danger strong {
    color: #ef4444;
  }

  &.warn strong {
    color: #f59e0b;
  }
}

.risk-filter {
  width: 100%;
  border: 1px solid rgba(148, 163, 184, 0.1);
  background: rgba(30, 41, 59, 0.32);
  color: #94a3b8;
  border-radius: 10px;
  padding: 11px 12px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  cursor: pointer;
  margin-top: 8px;
  transition: 0.2s;

  em {
    font-style: normal;
    color: #64748b;
    font-family: Consolas, monospace;
  }

  &:hover,
  &.active {
    border-color: rgba(56, 189, 248, 0.5);
    color: #fff;
    background: rgba(56, 189, 248, 0.12);
  }

  &.active em {
    color: #38bdf8;
  }
}

.people-main {
  display: flex;
  flex-direction: column;
  gap: 16px; /* EXACTLY match sidebar gap for alignment */
}

.people-header {
  margin-bottom: 0; /* Rely on parent gap for alignment */
}

.header-search {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 18px;
  padding: 0 14px;
  height: 36px; /* Match back-btn height */
  border: 1px solid rgba(148, 163, 184, 0.1);
  border-radius: 8px; /* Match back-btn radius */
  background: rgba(15, 23, 42, 0.42);
}

.search-input {
  flex: 1;
  height: 100%;
  position: relative;

  .el-icon {
    position: absolute;
    top: 50%;
    left: 0; /* Tighter search icon */
    transform: translateY(-50%);
    color: #64748b;
  }

  input {
    width: 100%;
    height: 100%;
    background: transparent;
    border: none;
    color: #f8fafc;
    outline: none;
    padding: 0 14px 0 28px;
    font-size: 13px;

    &:focus {
      color: #fff;
    }
  }
}

.result-count {
  color: #64748b;
  font-size: 12px;
  white-space: nowrap;

  strong {
    color: #38bdf8;
    font-size: 14px;
  }
}

.person-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(290px, 1fr)); /* Clean 4-5 cards per row spacing */
  gap: 12px;
}

.person-card {
  position: relative;
  display: grid;
  grid-template-columns: 115px minmax(0, 1fr); /* Split: Photo is larger, occupies 115px */
  gap: 12px;
  border: 1px solid rgba(55, 65, 81, 0.65);
  border-radius: 12px;
  background:
    linear-gradient(180deg, rgba(30, 41, 59, 0.65), rgba(15, 23, 42, 0.72)),
    #0f172a;
  padding: 10px;
  min-height: 155px; /* Proportionally larger compact height */
  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.02);
  transition: 0.2s cubic-bezier(0.4, 0, 0.2, 1);
  overflow: hidden;

  &::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 3px;
    height: 100%;
    border-radius: 12px 0 0 12px;
    background: #38bdf8;
    opacity: 0.8;
  }

  &.critical::before {
    background: #ef4444;
  }

  &.important::before {
    background: #f59e0b;
  }

  &:hover {
    transform: translateY(-2px);
    border-color: rgba(56, 189, 248, 0.35);
    box-shadow: 0 12px 24px rgba(0, 0, 0, 0.3);
    
    .card-actions-floating {
      opacity: 1;
      transform: translateY(0);
    }
  }
}

.portrait {
  position: relative;
  grid-row: span 3; /* Occupy left side fully */
  width: 100%;     /* Fills the 115px grid column */
  height: 148px;   /* Proportionally larger passport portrait */
  border-radius: 6px;
  overflow: hidden;
  background: #020617;
  border: 1px solid rgba(148, 163, 184, 0.16);

  img {
    width: 100%;
    height: 100%;
    display: block;
    object-fit: cover;
    filter: saturate(0.92) contrast(1.04);
  }

  &::after {
    content: "";
    position: absolute;
    inset: 0;
    background:
      linear-gradient(180deg, transparent 65%, rgba(2, 6, 23, 0.68)),
      linear-gradient(90deg, rgba(56, 189, 248, 0.08), transparent 24%, transparent 76%, rgba(56, 189, 248, 0.04));
    pointer-events: none;
  }
}

.scan-line {
  position: absolute;
  left: 0;
  right: 0;
  top: 48%;
  height: 1px;
  background: rgba(56, 189, 248, 0.92);
  box-shadow: 0 0 12px rgba(56, 189, 248, 0.8);
  opacity: 0.5;
}

.photo-label {
  position: absolute;
  left: 4px;
  bottom: 4px;
  z-index: 2;
  border: 1px solid rgba(56, 189, 248, 0.25);
  border-radius: 4px;
  background: rgba(2, 6, 23, 0.65);
  color: #bae6fd;
  padding: 2px 4px;
  font-size: 8px;
  font-weight: 800;
  letter-spacing: 0.5px;
}

.person-info-compact {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  min-width: 0;
  gap: 8px;
}

.person-meta {
  display: flex;
  flex-direction: column;
  gap: 2px;
}

.person-name {
  margin: 0;
  color: #f8fafc;
  font-size: 14px; /* Scaled up font size */
  font-weight: 800;
  line-height: 1.2;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.person-index {
  display: block;
  color: #38bdf8;
  font-family: Consolas, monospace;
  font-size: 10px; /* Scaled up font size */
  font-weight: 900;
  opacity: 0.85;
}

.card-actions-floating {
  position: absolute;
  top: 6px;
  right: 6px;
  display: flex;
  gap: 4px;
  z-index: 10;
  opacity: 0;
  transform: translateY(-4px);
  transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
}

.action-btn {
  width: 24px;
  height: 24px;
  border-radius: 6px;
  display: grid;
  place-items: center;
  border: 1px solid rgba(148, 163, 184, 0.2);
  background: rgba(15, 23, 42, 0.85);
  color: #cbd5e1;
  font-size: 11px;
  cursor: pointer;
  transition: all 0.15s;

  &:hover {
    color: #fff;
    border-color: #38bdf8;
    background: rgba(56, 189, 248, 0.25);
  }

  &.delete:hover {
    border-color: #ef4444;
    background: rgba(239, 68, 68, 0.25);
    color: #ef4444;
  }
}

.risk-badge {
  width: fit-content;
  border-radius: 4px;
  padding: 2px 6px;
  font-size: 10px; /* Scaled up risk-badge font size */
  font-weight: 900;
  white-space: nowrap;
  margin-top: 2px;

  &.critical {
    color: #fecaca;
    background: rgba(239, 68, 68, 0.15);
    border: 1px solid rgba(239, 68, 68, 0.25);
  }

  &.important {
    color: #fde68a;
    background: rgba(245, 158, 11, 0.14);
    border: 1px solid rgba(245, 158, 11, 0.25);
  }

  &.standard {
    color: #bae6fd;
    background: rgba(56, 189, 248, 0.12);
    border: 1px solid rgba(56, 189, 248, 0.2);
  }
}

.field-grid {
  display: flex;
  flex-direction: column;
  gap: 5px;
}

.field-row {
  min-width: 0;
  display: flex;
  align-items: center;
  gap: 6px;
  border: 1px solid rgba(148, 163, 184, 0.05);
  border-radius: 6px;
  background: rgba(2, 6, 23, 0.22);
  color: #94a3b8;
  padding: 6px 8px;
  font-size: 12px; /* Scaled up row text size */

  .el-icon {
    flex-shrink: 0;
    color: #38bdf8;
    font-size: 14px; /* Scaled up icon size */
  }

  .el-icon.female {
    color: #fb7185;
  }

  .label {
    color: #526173;
    font-weight: 700;
  }

  strong {
    color: #cbd5e1;
    font-weight: 700;
    margin-left: auto;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
}

.card-footer-compact {
  margin-top: 4px;
  padding-top: 8px;
  border-top: 1px solid rgba(148, 163, 184, 0.06);
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.footer-item {
  color: #526173;
  font-size: 10px; /* Scaled up footer font size */
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;

  span {
    font-weight: 700;
    color: #475569;
  }
}

.empty-state {
  min-height: 220px;
  display: grid;
  place-items: center;
  text-align: center;
  border: 1px dashed rgba(148, 163, 184, 0.12);
  border-radius: 12px;
  color: #64748b;
  padding: 20px;

  .el-icon {
    font-size: 30px;
    color: #38bdf8;
  }

  h3 {
    margin: 8px 0 4px;
    color: #cbd5e1;
    font-size: 15px;
  }

  p {
    margin: 0;
    font-size: 12px;
  }
}

.sync-footer {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  color: #526173;
  font-size: 10px;
  margin-top: 10px;

  span {
    display: inline-flex;
    align-items: center;
    gap: 4px;
    border: 1px solid rgba(148, 163, 184, 0.06);
    border-radius: 999px;
    background: rgba(15, 23, 42, 0.22);
    padding: 6px 10px;
  }

  .el-icon {
    color: #22c55e;
    font-size: 11px;
  }
}

/* Pagination */
.cyber-pagination {
  margin-top: 24px;
  display: flex;
  justify-content: center;
  margin-bottom: 24px;

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

@media (max-width: 1100px) {
  .library-detail-layout {
    grid-template-columns: 1fr;
  }

  .library-side {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
  }

  .back-btn {
    grid-column: 1 / -1;
  }
}

@media (max-width: 720px) {
  .library-side,
  .person-grid {
    grid-template-columns: 1fr;
  }

  .people-header {
    align-items: stretch;
    flex-direction: column;
  }
}
</style>
