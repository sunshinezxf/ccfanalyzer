import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    background: {
      backgroundImage: 'url(' + require('@/assets/background.jpg') + ')',
      backgroundRepeat: 'no-repeat',
      backgroundSize: 'cover'
    }
  },
  mutations: {
    flushBackground (state) {
      var now = new Date()
      var hh = now.getHours()
      if (hh >= 6 && hh < 8) {
        state.background.backgroundImage = 'url(' + require('@/assets/background_night.jpg') + ')'
      } else if (hh >= 8 && hh < 17) {
        state.background.backgroundImage = 'url(' + require('@/assets/background_night.jpg') + ')'
      } else if (hh >= 17 && hh < 20) {
        state.background.backgroundImage = 'url(' + require('@/assets/background_night.jpg') + ')'
      } else {
        state.background.backgroundImage = 'url(' + require('@/assets/background_night.jpg') + ')'
      }
    }
  },
  actions: {
    flushFun (context) {
      context.commit('flushBackground')
    }
  }
})

export default store
