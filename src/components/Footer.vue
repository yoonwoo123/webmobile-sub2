<template>
  <v-footer class="pa-4" style="background:darkgrey !important;">
    <img :src="weatherIconUrl" alt="weather icon" height='50px'>
    <span>
       {{ weather }}
      <font-awesome-icon icon="temperature-high" /> {{ temperature }}'C
      <font-awesome-icon icon="tint" /> {{ humidity }}%
    </span>
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
      // const weatherIcon = {
      //   'Thunderstorm': 'http://openweathermap.org/img/wn/11d@2x.png',
      //   'Drizzle': 'http://openweathermap.org/img/wn/09d@2x.png',
      //   'Rain': 'http://openweathermap.org/img/wn/10d@2x.png',
      //   'Snow': 'http://openweathermap.org/img/wn/13d@2x.png',
      //   'Clear': 'http://openweathermap.org/img/wn/01d@2x.png',
      //   'Clouds': 'http://openweathermap.org/img/wn/03d@2x.png',
      // }
      const weatherUrl = 'http://api.openweathermap.org/data/2.5/weather?q=Seoul&units=metric&lang=kr&appid=9605cf8a9a7b4126fb57deb954cac4d5'
      axios.get(weatherUrl)
        .then(response => response.data)
          .then((data) => {
            this.temperature = data.main.temp
            this.weather = data.weather[0].description
            this.humidity = data.main.humidity
            let weatherIcon = data.weather[0].icon
            this.weatherIconUrl = 'http://openweathermap.org/img/wn/' + weatherIcon + '@2x.png'
            // console.log(data.weather)
            // if (data.weather.id[0] === 7) {
            //     this.weatherIconUrl = 'http://openweathermap.org/img/wn/50d@2x.png'
            // } else {
            //   this.weatherIconUrl = weatherIcon[data.weather.main]
            // }
          })
    }
  },
  mounted: function () {
    this.getWeather()
  },
}
</script>
