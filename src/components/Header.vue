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

    <!-- Login modal pop -->

    <v-btn class="hidden-sm-and-down" fab small>
      <v-icon size='25px' color="deep-orange" @click="dialog=true">fa-user-circle</v-icon>
    </v-btn>

    <v-dialog v-model="dialog" persistent max-width="600px" >

      <v-card>
        <v-card-title>
          <span class="headline">Login</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field label="Email*" required></v-text-field>
              </v-flex>
              <v-flex xs12>
                <v-text-field label="Password*" type="password" required></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
          <small>*indicates required field</small>
        </v-card-text>
        <v-facebook-login app-id="966242223397117"></v-facebook-login>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="dialog = false">cancel</v-btn>
          <v-btn color="blue darken-1" flat @click="showRegister">Account</v-btn>
          <v-btn color="blue darken-1" flat @click="">Login</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <v-dialog v-model="dialog2" persistent max-width="600px">
      <v-card>
        <v-card-title>
          <span class="headline">Register</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12 sm6 md4>
                <v-text-field label="Legal first name*" required></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field label="Legal middle name" hint="example of helper text only on focus"></v-text-field>
              </v-flex>
              <v-flex xs12 sm6 md4>
                <v-text-field
                  label="Legal last name*"
                  hint="example of persistent helper text"
                  persistent-hint
                  required
                ></v-text-field>
              </v-flex>
              <v-flex xs12>
                <v-text-field label="Email*" required></v-text-field>
              </v-flex>
              <v-flex xs12>
                <v-text-field label="Password*" type="password" required></v-text-field>
              </v-flex>
              <v-flex xs12 sm6>
                <v-select
                  :items="['0-17', '18-29', '30-54', '54+']"
                  label="Age*"
                  required
                ></v-select>
              </v-flex>
              <v-flex xs12 sm6>
                <v-autocomplete
                  :items="['Skiing', 'Ice hockey', 'Soccer', 'Basketball', 'Hockey', 'Reading', 'Writing', 'Coding', 'Basejump']"
                  label="Interests"
                  multiple
                ></v-autocomplete>
              </v-flex>
            </v-layout>
          </v-container>
          <small>*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="dialog2 = false">Close</v-btn>
          <v-btn color="blue darken-1" flat @click="dialog2 = false">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>



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
import VFacebookLogin from 'vue-facebook-login-component'

export default {
  name: 'Header',
  components:{
    VFacebookLogin
  },
  data () {
    return {
      drawer: null,
      items: [
        { title: 'Login', icon: 'fa-user-circle', name: 'login'},
        { title: 'Home', icon: 'fa-h-square', name: 'home'},
        { title: 'Portfolio', icon: 'fa-laptop', name: 'portfolio'},
        { title: 'Post', icon: 'fa-clipboard', name: 'post' }
        // { title: 'Project', icon: 'fa-git-square' ,name:'project'}
      ],
      dialog: false,
      dialog2:false
    }
  },
  methods : {
    alertBookmark: function() {
      alert("북마크 ctrl+D")
    },
    showRegister:function(){
      this.dialog = false;
      this.dialog2 = true;
    },
    showLogin:function(){
      this.dialog = true;
      this.dialog2 = false;
    },
    hideModal:function(){
      this.dialog = false;
      this.dialog2 = false;
    }
  }
}

</script>
