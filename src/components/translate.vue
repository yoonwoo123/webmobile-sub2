<template lang="html">

</template>

<script>
  import TranslateService from '@/services/TranslateService'

  export default {
    name: 'TranslatePage',
    methods: {
      async quickstart() {
        await TranslateService.quickstart()
      }
    },
    mounted () {
      this.quickstart();
    }
  }
</script>

<style lang="css" scoped>
</style>
