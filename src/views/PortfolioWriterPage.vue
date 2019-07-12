<template>
  <v-container>
      <v-layout>
      <v-flex>
        <h2 class="headline mb-3 font-weight-bold text-xs-center">Portfolio 작성</h2>
        <v-text-field label="Title" regular></v-text-field>
        <Imgur></Imgur>
        <markdown-editor v-model="content" ref="markdownEditor"></markdown-editor>
        <v-btn color="blue-grey lighten-4" @click="post">등록하기</v-btn>
        <v-btn>취소</v-btn>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script type="text/javascript">
import FirebaseService from '@/services/FirebaseService'
import Imgur from '../components/Imgur'

export default {
	name: 'PortfolioWriterPage',
	components: {
    Imgur
	},
  methods:{
    post:function(){
      firebase.postPortfolio(this.title, this.body, "http://dy.gnch.or.kr/img/no-image.jpg")
    }
  },
  mounted () {
    FirebaseService.logging(this.$session.get("name"), this.$route['path'])
  }
}

</script>
