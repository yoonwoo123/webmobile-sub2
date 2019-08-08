<template>
  <div>
    <v-img id="ban" v-bind:src="this.$store.state.imgSrc"
           aspect-ratio="1.7" v-resize="resize"  v-bind:style="{height:newHeight}">
      <v-layout align-center justify-center row fill-height>
        <v-flex text-xs-center >
          <span class="text-shadow display-2 font-weight-light">
            <slot name="text"/>
          </span>
        </v-flex>
      </v-layout>
    </v-img>
  </div>
</template>

<script>

export default {
	name: 'ImgBanner',
	props: {
		res: {type: String,
             default: "https://source.unsplash.com/1600x900/?newyork"
    },
		text: {type: String}
	},
  data () {
    return {
      newHeight: null
    }
  },
	methods: {
    resize(){
      this.newHeight = window.innerWidth < 600 ? window.innerHeight-56 +'px' : null
    },
	},
}
</script>
<style>
  .text-shadow {
    text-shadow: 0 0 15px rgb(255,255,255);
  }
</style>
