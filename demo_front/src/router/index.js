import { createRouter, createWebHistory } from 'vue-router'
import PageHome from '@/views/PageHome.vue'
import PageAbout from '@/views/PageAbout'
import BoardList from "@/views/board/BoardList";
import PageLogin from "@/views/PageLogin";

const routes = [
  {
    path: '/',
    name: 'PageHome',
    component: PageHome
  },
  {
    path: '/about',
    name: 'About',
    component: PageAbout
  },
  {
    path: '/board/list',
    name: 'BoardList',
    component: BoardList
  },
  {
    path: '/login',
    name: 'Login',
    component: PageLogin
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router