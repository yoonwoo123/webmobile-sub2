<template>
  <div>
    <ImgBanner imgSrc="https://source.unsplash.com/1600x900/?newyork">
      <div style="line-height:1.2em;font-size:1.2em;" slot="text">Translate</div>
    </ImgBanner>
    <Translate></Translate>
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
  }
}
</script>

<style>

</style>
