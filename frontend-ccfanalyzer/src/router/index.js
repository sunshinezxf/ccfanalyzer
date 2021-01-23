import Vue from 'vue'
import Router from 'vue-router'
import Homepage from '@/views/home/Homepage'
import SearchPaper from '@/views/search/SearchPaper'
import PaperDetail from '@/views/search/PaperDetail'
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
    }
  ]
})
