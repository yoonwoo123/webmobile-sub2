<template>
  <div>
    <ImgBanner>
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
    // 페이지 이동시에 DB에 로그를 남김.
    FirebaseService.logging(this.$session.get("name"), this.$route['path'])
  }
}
</script>

<style>

</style>
