<template>
  <v-footer class="pa-4" style="background:darkgrey !important;">
    <img :src="weatherIconUrl" alt="weather icon" height='50px'>
    <span>
       {{ weather }}
      <font-awesome-icon icon="temperature-high" /> {{ temperature }}'C
      <font-awesome-icon icon="tint" /> {{ humidity }}%
    </span>
    <v-spacer></v-spacer>
    <a href="https://lab.ssafy.com/tlswhd1020/webmobile-sub2"><font-awesome-icon :icon="['fab', 'gitlab']" /></a>
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
      humidity:'',
      weatherIconUrl:'',
    }
  },
  methods: {
    getWeather: function () {
      const weatherUrl = 'http://api.openweathermap.org/data/2.5/weather?q=Seoul&units=metric&lang=kr&appid=9605cf8a9a7b4126fb57deb954cac4d5'
      axios.get(weatherUrl)
        .then(response => response.data)
          .then((data) => {
            this.temperature = data.main.temp
            this.weather = data.weather[0].description
            this.humidity = data.main.humidity
            let weatherIcon = data.weather[0].icon
            this.weatherIconUrl = 'http://openweathermap.org/img/wn/' + weatherIcon + '@2x.png'
          })
    }
  },
  mounted: function () {
    this.getWeather()
  },
}
</script>
