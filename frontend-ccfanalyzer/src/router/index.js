import Vue from 'vue'
import Router from 'vue-router'
import Homepage from '@/views/home/Homepage'
import SearchPaper from '@/views/search/SearchPaper'
import PaperDetail from '@/views/search/PaperDetail'
import AuthorPortrait from '@/views/portrait/AuthorPortrait'
import AffiliationPortrait from '@/views/portrait/AffiliationPortrait'
import ConferencePortrait from '@/views/portrait/ConferencePortrait'
import Login from '@/views/user/Login'
import Register from '@/views/user/Register'
import Collections from '@/views/user/Collections'
import PersonalWarehouse from '@/views/user/PersonalWarehouse'
import PaperShared from '@/views/user/PaperShared'
import MyTeams from '@/views/user/MyTeams'
import TeamDetails from '@/views/user/TeamDetails'
import AdminLogin from '@/views/Admin/AdminLogin'
import UpdateTime from '@/views/Admin/UpdateTime'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/SearchPaper',
      name: 'SearchPaper',
      component: SearchPaper,
      meta: { requireAuth: false },
    },
    {
      path: '/',
      name: 'Homepage',
      component: Homepage,
      meta: { requireAuth: false },
    },
    {
      path: '/PaperDetail',
      name: 'PaperDetail',
      component: PaperDetail,
      meta: { requireAuth: false },
    },
    {
      path: '/AuthorPortrait',
      name: 'AuthorPortrait',
      component: AuthorPortrait,
      meta: { requireAuth: false },
    },
    {
      path: '/AffiliationPortrait',
      name: 'AffiliationPortrait',
      component: AffiliationPortrait,
      meta: { requireAuth: false },
    },
    {
      path: '/ConferencePortrait',
      name: 'ConferencePortrait',
      component: ConferencePortrait,
      meta: { requireAuth: false },
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login,
      meta: { requireAuth: false },
    },
    {
      path: '/Register',
      name: 'Register',
      component: Register,
      meta: { requireAuth: false },
    },
    {
      path: '/Collections',
      name: 'Collections',
      component: Collections,
      meta: { requireAuth: true },
    },
    {
      path: '/PersonalWarehouse',
      name: 'PersonalWarehouse',
      component: PersonalWarehouse,
      meta: { requireAuth: true },
    },
    {
      path: '/PaperShared',
      name: 'PaperShared',
      component: PaperShared,
      meta: { requireAuth: true },
    },
    {
      path: '/MyTeams',
      name: 'MyTeams',
      component: MyTeams,
      meta: { requireAuth: true },
    },
    {
      path: '/TeamDetails',
      name: 'TeamDetails',
      component: TeamDetails,
      meta: { requireAuth: true },
    },
    {
      path: '/AdminLogin',
      name: 'AdminLogin',
      component: AdminLogin,
      meta: { requireAuth: true },
    },
    {
      path: '/UpdateTime',
      name: 'UpdateTime',
      component: UpdateTime,
      meta: { requireAuth: true },
    }
  ]
})
