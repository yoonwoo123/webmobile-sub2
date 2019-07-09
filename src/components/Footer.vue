<template>
  <v-footer dark class="pa-3">
    <span>{{ weather }}  <font-awesome-icon icon="temperature-high" /> {{ temperature }}'C   <font-awesome-icon icon="tint" /> {{ humidity }}%</span>
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
      weather:'',
    }
  },
  methods: {
    getTemperature: function () {
      const weatherUrl = 'http://api.openweathermap.org/data/2.5/weather?q=Seoul&units=metric&lang=kr&appid=9605cf8a9a7b4126fb57deb954cac4d5'
      axios.get(weatherUrl)
        .then(response => response.data)
          .then((data) => {
            this.temperature = data.main.temp
            this.weather = data.weather[0].description
            this.humidity = data.main.humidity
          })
          // .then(data => this.temperature = data.main.temp)
            // .then(data => this.weather = data)
    }
  },
  mounted: function () {
    this.getTemperature()
  },
}
</script>
