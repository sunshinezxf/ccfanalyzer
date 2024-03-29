// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import { Icon, Progress } from 'view-design'
Vue.use(ElementUI, { locale })
Vue.component('Icon', Icon)
Vue.component('Progress', Progress)
import Vue from 'vue'
import App from './App'
import store from './store'
import locale from 'element-ui/lib/locale/lang/en'
import 'view-design/dist/styles/iview.css'
import VueRouter from 'vue-router'
import router from './router'
import * as echarts from 'echarts'

import axios from 'axios'

Vue.config.productionTip = false
Vue.prototype.$echarts = echarts
const routerPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return routerPush.call(this, location).catch(error => error)
}

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (JSON.parse(localStorage.getItem("flag"))) {
      next();
    } else {
      next({
        path: "/Login"//指向为你的登录界面
      });
    }
  } else {
    next();
  }
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  components: { App },
  template: '<App/>',
  router
})
