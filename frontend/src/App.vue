<template>
  <v-app>
    <Header></Header>
    <v-content  v-scroll="onScroll">
      <router-view/>
      <GotoTop v-if="offsetTop >= 300"></GotoTop>
    </v-content>
    <Footer></Footer>
  </v-app>
</template>

<script>
import store from './store'
import Header from './components/Header'
import Footer from './components/Footer'
import GotoTop from './components/GotoTop'

export default {
  components : {
    Header,
    Footer,
    GotoTop
  },
	name: 'App',
	store,
  data: () => ({
    offsetTop: 0
  }),
  methods: {
    onScroll () {
      this.offsetTop = window.scrollY
    }
  }
}
</script>
