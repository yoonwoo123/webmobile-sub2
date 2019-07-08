<template>
  <v-layout>
  <v-toolbar fixed app>
    <!-- <v-toolbar-side-icon></v-toolbar-side-icon> -->
    <v-icon large color="blue-grey" @click="$router.push({name:'home'})">fa-h-square</v-icon>
    <v-toolbar-title @click="$router.push({name:'home'})"><strong>윤현규의 블로그</strong></v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <!-- <v-btn flat @click="$router.push({name:'portfolio'})"><strong>Portfolio</strong></v-btn> -->
      <v-btn flat router :to="{name:'portfolio'}" exact><strong>Portfolio</strong></v-btn>
      <v-btn flat router :to="{name:'post'}" exact><strong>Post</strong></v-btn>
      <!-- <v-btn flat router :to="{name:'project'}" exact><strong>Project</strong></v-btn> -->
    </v-toolbar-items>
    <v-btn class="hidden-sm-and-down" fab small @click="$router.push({name:'login'})"><v-icon size='25px' color="deep-orange">fa-user-circle</v-icon></v-btn>
    <v-btn class="hidden-sm-and-down" fab small @click="alertBookmark"><v-icon size='25px' color="yellow darken-1">fa-star</v-icon></v-btn>
    <v-toolbar-side-icon class="hidden-md-and-up" @click.stop="drawer = !drawer">
    </v-toolbar-side-icon>
  </v-toolbar>

  <v-navigation-drawer
    v-model="drawer"
    fixed
    temporary
    right
  >
  <v-toolbar flat>
    <v-icon color='pink' size="30px" @click.stop="drawer = !drawer">fa-chevron-circle-right</v-icon>
    <v-list>
      <v-list-tile>
        <v-list-tile-title class="title">
          <strong>Menu</strong>
        </v-list-tile-title>

      </v-list-tile>
    </v-list>
    <v-btn fab small @click="alertBookmark"><v-icon size='25px' color="yellow darken-1">fa-star</v-icon></v-btn>
  </v-toolbar>

  <v-divider></v-divider>

  <v-list dense class="pt-0">
    <v-list-tile
      v-for="item in items"
      :key="item.title"
      @click=""
      router :to="{name: item.name}" exact
    >
      <v-list-tile-action>
        <v-icon>{{ item.icon }}</v-icon>
      </v-list-tile-action>

      <v-list-tile-content>
        <v-list-tile-title>{{ item.title }}</v-list-tile-title>
      </v-list-tile-content>
    </v-list-tile>
  </v-list>
  </v-navigation-drawer>
</v-layout>
</template>

<script>

export default {
  name: 'Header',
  data () {
    return {
      drawer: null,
      items: [
        { title: 'Login', icon: 'fa-user-circle', name: 'login'},
        { title: 'Home', icon: 'fa-h-square', name: 'home'},
        { title: 'Portfolio', icon: 'fa-laptop', name: 'portfolio'},
        { title: 'Post', icon: 'fa-clipboard', name: 'post' }
        // { title: 'Project', icon: 'fa-git-square' ,name:'project'}
      ]
    }
  },
  methods : {
    alertBookmark: function() {
      alert("북마크 ctrl+D")
    }
  }
}

</script>
