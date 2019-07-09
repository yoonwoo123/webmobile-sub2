<template>
  <div id="app">
    <input type="text" v-model="inputString" placeholder="번역하고 싶은 문장을 입력하세요.">
    <button @click="translate">번역</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'TranslateService',
  data () {
    return {
      inputString: ''
    }
  },
  methods: {
    translate () {
      axios.post('https://translation.googleapis.com/language/translate/v2', null, {params: {
        q: this.inputString,
        target: "ko",
        format: "text",
        source: "en",
        key: "AIzaSyASXFH5twgIsjrvHby5cD39HRLaEaXOeO4"
      }})
      .then( response => { console.log(response) })
      .catch( response => { console.log(response) });
    }
  }
}
</script>

<style>
</style>

