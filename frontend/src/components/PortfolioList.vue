<template>
  <v-layout mt-5 wrap>
    <v-flex mr-2 xs12 class="text-xs-right">
      <v-btn dark color="blue-grey lighten-1" router :to="{name:'portfoliowriter'}"><v-icon size="20">fa-plus</v-icon>&nbsp;&nbsp; <strong>portfolio</strong></v-btn>
    </v-flex>
    <v-flex v-for="i in portfolios.length > limits ? limits : portfolios.length" xs12 sm6 md4>
      <Portfolio class="ma-3"
              :date="portfolios[i - 1].created_at.toString()"
              :title="portfolios[i - 1].title"
              :body="portfolios[i - 1].body"
              :imgSrc="portfolios[i - 1].img"
      ></Portfolio>
    </v-flex>

    <v-flex xs12 text-xs-center round my-5 v-if="loadMore">
      <v-btn color="info" dark v-on:click="loadMorePortfolios"><v-icon size="25" class="mr-2">fa-plus</v-icon> 더 보기</v-btn>
    </v-flex>
  </v-layout>
</template>
<script>
import Portfolio from '@/components/Portfolio'
import FirebaseService from '@/services/FirebaseService'

export default {
	name: 'PortfoliosList',
	props: {
		limits: {type: Number, default: 4},
    loadMore: {type: Boolean, default: true}
	},
	data() {
		return {
			portfolios: []
		}
	},
	components: {
		Portfolio
	},
	mounted() {
		this.getPortfolios()
	},
	methods: {
		async getPortfolios() {
			this.portfolios = await FirebaseService.getPortfolios()
		},
		loadMorePortfolios() {
      this.limits += 4;
    }
	},
}
</script>
<style>
  .mw-700 {
    max-width: 700px;
    margin: auto;
  }
</style>
