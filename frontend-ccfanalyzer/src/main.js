// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/en'
import 'view-design/dist/styles/iview.css'
import VueRouter from 'vue-router'
Vue.use(ElementUI, { locale })
import { Icon, Progress } from 'view-design'
Vue.component('Icon', Icon)
Vue.component('Progress', Progress)
Vue.config.productionTip = false
const routerPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return routerPush.call(this, location).catch(error => error)
}
/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  components: { App },
  template: '<App/>'
})
