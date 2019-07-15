import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
		accessToken: "",
		user: "",
    imgSrc:"https://source.unsplash.com/1600x900/?newyork"
  }
})
