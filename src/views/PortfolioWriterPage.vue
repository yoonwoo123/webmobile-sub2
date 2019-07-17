<template>
  <v-container>
      <v-layout>
      <v-flex>
        <h2 class="headline mb-3 font-weight-bold text-xs-center">Portfolio 작성</h2>
        <v-text-field label="Title" regular v-model="title"></v-text-field>
        <Imgur v-on:pass="deliverFile"></Imgur>
        <markdown-editor v-model="body" ref="markdownEditor"></markdown-editor>
        <v-btn color="blue-grey lighten-4" @click="post">등록하기</v-btn>
        <v-btn>취소</v-btn>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script type="text/javascript">
import axios from 'axios'
import FirebaseService from '@/services/FirebaseService'
import Imgur from '../components/Imgur'

export default {
	name: 'PortfolioWriterPage',
	components: {
    Imgur
	},
  data () {
    return {
      title: '',
      body: '',
      file: null,
    }
  },
  methods:{
    post:function(){
      var form = new FormData();
      form.append('image', this.file);
      // let file = this.file;
      // axios.post('https://api.imgur.com/3/image', { image: file }, { headers: { Authorization: 'Client-ID 546c25a59c58ad7' }})
      axios({
        method: 'post',
        url: 'https://api.imgur.com/3/image',
        headers: { 'Authorization': 'Client-ID 546c25a59c58ad7' },
        data: form
      })
      .then( response => {
        // console.log(response['data']['data']['link']);
        FirebaseService.postPortfolio(this.title, this.body, response['data']['data']['link'])
      })
      .catch( response => { console.log(response) });
      // FirebaseService.postPortfolio(this.title, this.body, response['data']['data']['link'])
    },
    deliverFile (image) {
      this.file = image;
    }
  },
  mounted () {
    FirebaseService.logging(this.$session.get("name"), this.$route['path'])
  }
}

</script>
