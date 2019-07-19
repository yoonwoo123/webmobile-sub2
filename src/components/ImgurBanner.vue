<template>
  <div class="filebox">
    <!-- <ImgBanner v-bind:res="res"></ImgBanner> -->
    <input ref="inputFile" id="ex-file" name="img" type="file" accept="image/x-png,image/gif,image/jpeg" style="display: none;" @change="onFileChagne"/>
    <v-btn @click="randomimage">랜덤 배너</v-btn>
    <v-btn @click="pickFile">배너 바꾸기</v-btn>
  </div>
</template>


<script type="text/javascript">
import axios from 'axios'
import FirebaseService from '@/services/FirebaseService'

export default {
    name: 'ImgurBanner',
    data () {
      return {
        url:'',
        file: null
      }
    },
    methods: {
      pickFile() {
        this.$refs.inputFile.click()
      },
      onFileChagne(e) {
        this.file = e.target.files[0];
        console.log(this.file)
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
          // console.log(response)
          // console.log(response['data']['data']['link']);
          this.$store.state.imgSrc = response['data']['data']['link'];
          // FirebaseService.postPortfolio(this.title, this.body, response['data']['data']['link'])
        })
        .catch( response => { console.log(response) });
        // FirebaseService.postPortfolio(this.title, this.body, response['data']['data']['link'])
      },
      randomimage() {
        this.$store.state.imgSrc = "https://source.unsplash.com/1600x900/?newyork"
      }
      // deliverFile (image) {
      //   this.file = image;
      // }
    },
}
</script>
