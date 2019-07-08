<template>
  <v-layout align-center justify-center row fill-height>
    <v-flex xs8 text-xs-center>
      <v-layout align-center justify-center row fill-height elevation-5 style="min-height:500px;" white pa-4>
        <v-flex xs12 text-xs-center>
          <v-facebook-login app-id="966242223397117"></v-facebook-login>        </v-flex>
      </v-layout>
    </v-flex>
  </v-layout>
</template>

<script>

import VFacebookLogin from 'vue-facebook-login-component'

// OR, use cherry-pick export (better consistency)

export default {
  name: 'LoginPage',
  components: {
    VFacebookLogin
  }
}

</script>
