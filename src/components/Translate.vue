<template>
  <v-container>
    <v-form>
      <v-container>
        <v-layout justify-center>
          <v-flex xs12 sm6>
            <v-textarea
              v-model="inputString"
              placeholder="텍스트 입력"
              required
            ></v-textarea>
            <v-textarea
              outline
              placeholder="번역"
              disabled
              :value="result"
            ></v-textarea>
          </v-flex>
        </v-layout>
        <v-btn @click="langchange">{{ source }}->{{ target }}</v-btn>
        <v-btn @click="translate">번역</v-btn>
        <v-btn @click="clear">지우기</v-btn>
      </v-container>
    </v-form>
  </v-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Translate',
  data () {
    return {
      result: '',
      inputString: '',
      target: 'en',
      source: 'ko'

    }
  },
  methods: {
    translate () {
      axios.post('https://translation.googleapis.com/language/translate/v2', null, {params: {
        q: this.inputString,
        target: this.target,
        format: "text",
        source: this.source,
        key: "AIzaSyASXFH5twgIsjrvHby5cD39HRLaEaXOeO4"
      }})
      .then( response => { this.result = response["data"]["data"]["translations"][0]["translatedText"] })
      .catch( response => { console.log(response) });
    },
    clear () {
      this.result = ''
      this.inputString = ''
    },
    langchange () {
      let temp = this.target
      this.target = this.source
      this.source = temp
    }
  }
}
</script>

<style>
</style>
