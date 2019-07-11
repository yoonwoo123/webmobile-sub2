<template>
  <div>
    <ImgBanner imgSrc="https://source.unsplash.com/1600x900/?newyork">
      <div style="line-height:1.2em;font-size:1.2em;" slot="text">Translate</div>
    </ImgBanner>
    <Translate></Translate>
  </div>

</template>

<script>
import FirebaseService from '@/services/FirebaseService'
import ImgBanner from '../components/ImgBanner'
import Translate from '../components/Translate'
export default {
  name: 'TranslatePage',
  components: {
    ImgBanner,
    Translate
  },
  mounted () {
    FirebaseService.logging(this.$session.get("name"), this.$route['path'])
  }
}
</script>

<style>

</style>
