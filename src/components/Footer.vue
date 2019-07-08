<template>
  <v-footer dark class="pa-3">
    <v-spacer></v-spacer>
    <div>&copy;2019 — HyunGyu Yoon</div>
  </v-footer>
</template>

<script>
import axios from 'axios'

export default {
	name: 'Footer',
  data () {
    return {
      temperature: '',
    }
  },
  methods: {
    getTemperature: function () {
      const kmaUrl = 'http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?ServiceKey=1n75UtuOxfMND6RAspnfGNXQGtH%2BO1OkBn%2BGsOYO5aPZ4wtm3D%2FyXmC3tg9qNYbu18lGDMik4fL%2BT2jhJh%2BlqQ%3D%3D&base_date=20190708&base_time=1400&nx=1&ny=1'
      axios.get(kmaUrl)
        .then(response => console.log(response))
    }
  },
  mounted: function () {
    this.getTemperature()
  },
}
</script>
