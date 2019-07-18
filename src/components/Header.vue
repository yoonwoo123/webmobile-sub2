<template>
  <v-layout>
  <v-toolbar fixed app>
    <!-- <v-toolbar-side-icon></v-toolbar-side-icon> -->
    <v-icon large color="blue-grey" @click="$router.push({name:'home'})">fa-h-square</v-icon>
    <v-toolbar-title @click="$router.push({name:'home'})"><strong>HPHK</strong></v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <!-- <v-btn flat @click="$router.push({name:'portfolio'})"><strong>Portfolio</strong></v-btn> -->

      <v-toolbar-title v-if="name!=null" @click="$router.push({name:'home'})"  class="profile-toolbar">
          <div class="profile_icon profile-div">
            <img v-if="img!=null" :src="img" class="profile-img"/>
            <img v-if="img==null" src="/img/icons/apple-touch-icon.png" class="profile-img"/>
            <span class="profile-name">{{name}}</span>
          </div>
      </v-toolbar-title>
      <v-btn flat v-if="name != null" @click="logout" exact><strong>Logout</strong></v-btn>

      <v-btn flat router :to="{name:'portfolio'}" exact><strong>Portfolio</strong></v-btn>
      <v-btn flat router :to="{name:'post'}" exact><strong>Post</strong></v-btn>
      <v-btn flat router :to="{name:'translate'}" exact><strong>Translate</strong></v-btn>
      <!-- <v-btn flat router :to="{name:'project'}" exact><strong>Project</strong></v-btn> -->
    </v-toolbar-items>




    <!-- Login modal pop - by sj-->

    <v-btn v-if="name == null" class="hidden-sm-and-down" fab small>
      <v-icon size='25px' color="deep-orange" @click="dialog=true">fa-user-circle</v-icon>
    </v-btn>

    <!-- login form -->
    <v-dialog v-model="dialog" persistent max-width="600px" >
      <v-card>
        <v-card-title>
          <span class="headline">Login</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field v-model="email" label="Email*" required></v-text-field>
              </v-flex>
              <v-flex xs12>
                <v-text-field v-model="password" label="Password*" type="password" required></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
          <small>*indicates required field</small>
        </v-card-text>
        <v-btn round dark v-on:click="loginWithGoogle" ><v-icon size="25" class="mr-2">fa-google</v-icon> Google 로그인</v-btn>
        <v-btn color="primary" round dark v-on:click="loginWithFacebook" ><v-icon size="25" class="mr-2">fa-facebook</v-icon> Facebook 로그인</v-btn>
        <!-- <v-facebook-login app-id="966242223397117"></v-facebook-login> -->
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="dialog = false">Cancel</v-btn>
          <v-btn color="blue darken-1" flat @click="showRegister">Account</v-btn>
          <v-btn color="blue darken-1" flat @click="loginWithMail" @keyup.enter="loginWithMail">Login</v-btn>
          <!-- <v-btn color="blue darken-1" flat @click="logout">logout</v-btn> -->
          <!-- <v-btn color="blue darken-1" flat @click="loginCheck">check</v-btn> -->
        </v-card-actions>
      </v-card>
    </v-dialog>

    <!-- register form -->
    <v-dialog v-model="dialog2" persistent max-width="600px">
      <v-card>
        <v-card-title>
          <span class="headline">Register</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12 sm6 md4>
                <v-text-field v-model="cname" label="your name" required></v-text-field>
              </v-flex>
              <v-flex xs12>
                <v-text-field v-model="cemail" label="Email*" required></v-text-field>
              </v-flex>
              <v-flex xs12>
                <v-text-field v-model="cpassword" label="Password*" type="password" required></v-text-field>
              </v-flex>
            </v-layout>
          </v-container>
          <small>*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click="dialog2 = false">Close</v-btn>
          <v-btn color="blue darken-1" flat @click="signUp">register</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-btn class="hidden-sm-and-down" fab small @click="alertBookmark"><v-icon size='25px' color="yellow darken-1">fa-star</v-icon></v-btn>
    <v-toolbar-side-icon class="hidden-md-and-up" @click.stop="drawer = !drawer">
    </v-toolbar-side-icon>
  </v-toolbar>

  <v-navigation-drawer v-model="drawer" fixed temporary right >
  <v-toolbar flat>
    <v-icon color='pink' size="30px" @click.stop="drawer = !drawer">fa-chevron-circle-right</v-icon>

    <v-list-tile-title class="title" style="height:auto;">
      <v-toolbar-title v-if="name!=null" @click="$router.push({name:'home'})"  class="profile-toolbar">
          <div class="profile_icon profile-div">
            <img v-if="img!=null" :src="img" class="profile-img"/>
            <img v-if="img==null" src="/img/icons/apple-touch-icon.png" class="profile-img"/>
            <span class="profile-name">{{name}}</span>
          </div>
      </v-toolbar-title>

    </v-list-tile-title>
    <v-btn v-if="name == null" fab small>
      <v-icon size='25px' color="deep-orange" @click="dialog=true">fa-user-circle</v-icon>
    </v-btn>
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

    <v-list-tile flat v-if="name != null" @click="logout" router :to="'home'" exact>
      <v-list-tile-action>
        <v-icon>fa-user-circle</v-icon>
      </v-list-tile-action>
      <v-list-tile-content>
        <v-list-tile-title>Logout</v-list-tile-title>
      </v-list-tile-content>
    </v-list-tile>
  </v-list>

  </v-navigation-drawer>

</v-layout>
</template>

<script>
import FirebaseService from '@/services/FirebaseService'
//commit test
export default {
  name: 'Header',
  data () {
    return {
      drawer: null,
      items: [
        { title: 'Home', icon: 'fa-h-square', name: 'home'},
        { title: 'Portfolio', icon: 'fa-laptop', name: 'portfolio'},
        { title: 'Post', icon: 'fa-clipboard', name: 'post' },
        { title: 'Translate', icon: 'fa-language', name: 'translate' }
        // { title: 'Project', icon: 'fa-git-square' ,name:'project'}
      ],
      dialog: false,
      dialog2:false,
      email:null,
      password:null,
      name:null,
      img:null,
      cname:null,
      cemail:null,
      cpassword:null
    }
  },
  mounted () {
    if (!this.$session.exists()) {
      this.$router.push('/')
    } else{
      this.name = this.$session.get("name")
      this.img = this.$session.get("img")
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
    },
    signUp:function(){
      firebase.auth().createUserWithEmailAndPassword(email, password)
      .catch(function(error) {
        var errorCode = error.code;
        var errorMessage = error.message;
      });
    },
    async loginWithGoogle() {
			const result = await FirebaseService.loginWithGoogle()
      if(result != null){
        this.$session.start()
        this.$session.set("name",result.user.displayName)
        this.$session.set("img",result.user.photoURL)
        this.name = this.$session.get("name")
        this.img = this.$session.get("img")
        console.log(this.name)
        console.log(this.img)
        this.hideModal()
        this.$router.push({name:'home'})
      } else{
        alert(" 회원정보가 일치하지 않습니다.")
      }
		},
    async loginWithFacebook() {
			const result = await FirebaseService.loginWithFacebook()
      if(result != null){
        this.$session.start()
        this.$session.set("name",result.user.displayName)
        this.$session.set("img",result.user.photoURL)
        this.name = this.$session.get("name")
        this.img = this.$session.get("img")
        console.log(this.name)
        console.log(this.img)
        this.hideModal()
        this.$router.push({name:'home'})
      } else {
        alert("회원정보가 일치하지 않습니다.")
      }
		},
    async loginWithMail() {
      if(this.email !=null && this.password !=null){
        const result = await FirebaseService.loginWithEmail(this.email, this.password)
        if(result != null){
          this.$session.set("name",result.user.displayName)
          this.$session.set("img",result.user.photoURL)
          this.name = this.$session.get("name")
          this.img = this.$session.get("img")
          console.log(result)
          this.hideModal()
          alert(this.name + " 회원님 환영합니다.")
        } else {
          alert("회원정보가 일치하지 않습니다.")
        }
      }
      else{
        alert("로그인정보를 확인해주세요.")
      }
    },
    async signUp(){
      if(this.cname !=null && this.cemail !=null && this.cpassword !=null){
        const result = await FirebaseService.registerWithEmail(this.cemail, this.cpassword)
        FirebaseService.updateName(this.cname)
        this.hideModal()
        alert(this.cname + "회원님 가입을 축하합니다.")
      }
      else{
        alert("회원정보를 확인해주세요!")
      }

    },
    async logout(){
      this.name = null
      this.img = null
      FirebaseService.logout("logout Success")
      this.$session.destroy()
      this.$router.push('/')
    },
    loginCheck(){
  		console.log(this.$store.state.user)
      console.log(this.$store.state.accessToken)
  	}
  }
}
</script>

<style>
.profile_icon{
  padding: 0 10px;
  border-radius: 10%;
}
.profile_icon:hover {
  cursor: pointer;

  background-color: rgba(0,0,0,0.12);
}
.profile-name{
  float:left;
  margin:5px;
  font-weight:bold;
  font-size:17px;
}
.profile-img {
  margin:5px;
  float:left;
  width:35px;
  border-radius:50%
}
.profile-div{
  align-items: center;
  display: flex;
  margin:auto
}
.profile-toolbar{
  width:inherit;
  height:100%;
  display:flex
}
</style>
