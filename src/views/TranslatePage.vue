<template>
  <div>
    <ImgBanner imgSrc="https://source.unsplash.com/1600x900/?sanfrancisco">
      <div style="line-height:1.2em;font-size:1.2em;" slot="text">Translate</div>
    </ImgBanner>
    <v-container>
      <v-form v-model="valid">
        <v-container>
          <v-layout justify-center>
            <v-flex
              xs6
              sm12
            >
              <v-textarea
                v-model="inputString"
                placeholder="텍스트 입력"
                required
              ></v-textarea>
              <v-textarea
                placeholder="번역"
                disabled
                :value="result"
              ></v-textarea>
            </v-flex>
          </v-layout>
          <v-btn @click="">번역</v-btn>
          <v-btn @click="clear">취소</v-btn>
        </v-container>
      </v-form>
    </v-container>
  </div>
</template>

<script>
import ImgBanner from '../components/ImgBanner'
import Translate from '../components/Translate'
export default {
  name: 'TranslatePage',
  components: {
    ImgBanner,
    Translate
  },
  data () {
    return {
      result: ''
    }
  },
  methods: {
    clear () {
      this.result = ''
    },
  }
}
</script>

<style>

</style>
