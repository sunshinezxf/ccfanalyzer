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
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/SearchPaper',
      name: 'SearchPaper',
      component: SearchPaper,
      meta: {
        isLogin: false
      }
    },
    {
      path: '/',
      name: 'Homepage',
      component: Homepage,
      meta: {
        isLogin: false
      }
    },
    {
      path: '/PaperDetail',
      name: 'PaperDetail',
      component: PaperDetail,
      meta: {
        isLogin: false
      }
    },
    {
      path: '/AuthorPortrait',
      name: 'AuthorPortrait',
      component: AuthorPortrait,
      meta: {
        isLogin: false
      }
    },
    {
      path: '/AffiliationPortrait',
      name: 'AffiliationPortrait',
      component: AffiliationPortrait,
      meta: {
        isLogin: false
      }
    },
    {
      path: '/ConferencePortrait',
      name: 'ConferencePortrait',
      component: ConferencePortrait,
      meta: {
        isLogin: false
      }
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login,
      meta: {
        isLogin: false
      }
    },
    {
      path: '/Register',
      name: 'Register',
      component: Register,
      meta: {
        isLogin: false
      }
    },
    {
      path: '/Collections',
      name: 'Collections',
      component: Collections,
      meta: {
        isLogin: true
      }
    },
    {
      path: '/PersonalWarehouse',
      name: 'PersonalWarehouse',
      component: PersonalWarehouse,
      meta: {
        isLogin: true
      }
    }
  ]
})
