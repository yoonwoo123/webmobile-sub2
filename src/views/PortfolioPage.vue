<template>
  <div>
    <ImgBanner id="image" imgSrc="https://source.unsplash.com/1600x900/?newyork">
      <div style="line-height:1.2em;font-size:1.2em;" slot="text">Portfolio</div>
    </ImgBanner>
    <v-container>

      <!-- Portfolio -->
      <v-layout>
        <v-flex xs12>
          <PortfolioList :limits="6" :load-more="true"></PortfolioList>
        </v-flex>
      </v-layout>

    </v-container>
  </div>
</template>

<script>
import ImgBanner from '../components/ImgBanner'
import PortfolioList from '../components/PortfolioList'
import FirebaseService from '@/services/FirebaseService'

export default {
	name: 'PortfolioPage',
	components: {
		ImgBanner,
		PortfolioList,
	},
  created () {
    console.log('created')
  },
  mounted () {
    // console.log(this)
    // var temp = this.location['href']
    // console.log(this.$route)
    FirebaseService.logging(this.$route['path'])
  },
  updated () {
    console.log('updated')
  },
  beforeDestroy () {
    console.log('bd')
  }
}
</script>
